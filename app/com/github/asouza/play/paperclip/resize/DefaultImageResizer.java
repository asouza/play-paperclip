package com.github.asouza.play.paperclip.resize;

import java.awt.image.BufferedImage;

import org.imgscalr.Scalr;

import com.github.asouza.play.paperclip.UploadedImage;

public class DefaultImageResizer {
	
	public UploadedImage resize(UploadedImage image, ImageResize resize) {
		int width = resize.width(image);
		int height = resize.height(image);
		BufferedImage newImage = Scalr.resize(image.getImage(), width, height);
		return image.recreate(newImage);
	}
}
