package com.github.asouza.play.paperclip;

import static org.apache.commons.io.FilenameUtils.getExtension;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;


public class UploadedImage {
	
	private final BufferedImage image;

	private FileStorage storage;

	private File uploadedFile;

	private long timestamp;

	public UploadedImage(BufferedImage image, FileStorage storage, File uploadedFile) {
		this.image = image;
		this.storage = storage;
		this.uploadedFile = uploadedFile;
		this.timestamp = System.nanoTime();
	}

	public File getUploadedFile() {
		return uploadedFile;
	}
	
	public URL save(String folder) {
		String filename = timestampedName();
		InputStream is = imageToInputStream(folder);
		return storage.store(is, folder, contentTypeOf(filename));
	}

	private String timestampedName() {
		String extension = FilenameUtils.getExtension(uploadedFile.getName());
		String name = FilenameUtils.getBaseName(uploadedFile.getName());
		return name + "_" + timestamp + "."+extension;
	}

	private String contentTypeOf(String localPath) {
		return "image/" + getExtension(localPath);
	}

	private InputStream imageToInputStream(String localPath) {
		String extension = getExtension(localPath);
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(image, extension, os);
			return new ByteArrayInputStream(os.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public int getHeight() {
		return getImage().getHeight();
	}

	public int getWidth() {
		return getImage().getWidth();
	}

	public UploadedImage recreate(BufferedImage cropped) {
		return new UploadedImage(cropped, storage, uploadedFile);
	}

}

