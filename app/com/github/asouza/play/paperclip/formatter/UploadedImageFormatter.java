package com.github.asouza.play.paperclip.formatter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Http.Request;

import com.github.asouza.play.paperclip.PaperClipPlugin;
import com.github.asouza.play.paperclip.UploadedImage;
import com.github.asouza.play.paperclip.storage.FileStorage;

public class UploadedImageFormatter {

	final static FileStorage storage = play.Play.application()
			.plugin(PaperClipPlugin.class).storage();

	public static UploadedImage toUploadedImage(Request request,
			String paramName) {
		MultipartFormData body = request.body().asMultipartFormData();
		FilePart filePart = body.getFile(paramName);
		if (filePart == null){
			return null;
		}
		File uploadedFile = filePart.getFile();
		BufferedImage image = readImage(uploadedFile);
		return new UploadedImage(image, storage,filePart);
	}

	private static BufferedImage readImage(File file) {
		try {
			return ImageIO.read(file);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
