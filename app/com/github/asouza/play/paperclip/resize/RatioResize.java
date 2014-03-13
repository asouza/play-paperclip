package com.github.asouza.play.paperclip.resize;

import com.github.asouza.play.paperclip.UploadedImage;

public class RatioResize implements ImageResize {
	
	private double ratio;

	public RatioResize(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public int width(UploadedImage image) {
		int originalWidth = image.getWidth();
		return (int) (originalWidth * ratio);
	}

	@Override
	public int height(UploadedImage image) {
		int originalHeight = image.getHeight();
		return (int) (originalHeight * ratio);
	}

}
