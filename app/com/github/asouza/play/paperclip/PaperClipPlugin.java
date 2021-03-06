package com.github.asouza.play.paperclip;

import java.io.InputStream;
import java.net.URL;

import com.github.asouza.play.paperclip.crop.CenteredCrop;
import com.github.asouza.play.paperclip.crop.CropOperation;
import com.github.asouza.play.paperclip.crop.DefaultImageCropper;
import com.github.asouza.play.paperclip.storage.FileStorage;
import com.github.asouza.play.paperclip.storage.LocalFileStorage;

import play.Application;
import play.Logger;
import play.api.Plugin;

public class PaperClipPlugin implements Plugin{
	
	private Application application;

	public PaperClipPlugin(Application application) {
		this.application = application;
	}

	@Override
	public boolean enabled() {
		return true;
	}

	@Override
	public void onStart() {
		Logger.info("Starting PaperClip plugin");
	}

	@Override
	public void onStop() {
		Logger.info("Stoping PaperClip plugin");		
	}

	public FileStorage storage() {
		return new LocalFileStorage();
	}

	public UploadedImage centeredCrop(UploadedImage image, int width, int height) {
		CenteredCrop centeredCrop = new CenteredCrop(image,width, height);		
		return imageCropper().crop(image,centeredCrop);
	}

	private DefaultImageCropper imageCropper() {
		return new DefaultImageCropper();
	}
	

}
