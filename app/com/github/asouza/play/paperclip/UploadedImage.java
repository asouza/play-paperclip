package com.github.asouza.play.paperclip;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

import play.mvc.Http.MultipartFormData.FilePart;

import com.github.asouza.play.paperclip.storage.FileStorage;

import static org.apache.commons.io.FilenameUtils.getExtension;


public class UploadedImage {
	
	private final BufferedImage image;

	private FileStorage storage;

	private FilePart uploadedFile;

	private long timestamp;

	public UploadedImage(BufferedImage image, FileStorage storage, FilePart uploadedFile) {
		this.image = image;
		this.storage = storage;
		this.uploadedFile = uploadedFile;
		this.timestamp = System.nanoTime();
	}

	public String save(String folder) {
		String fileName = folder+"/"+timestampedName();
		InputStream is = imageToInputStream(fileName);
		return storage.store(is, fileName, contentTypeOf(fileName));
	}

	private String timestampedName() {
		String extension = FilenameUtils.getExtension(uploadedFile.getFilename());
		String name = FilenameUtils.getBaseName(uploadedFile.getFilename());
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

