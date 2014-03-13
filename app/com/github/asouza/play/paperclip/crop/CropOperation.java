package com.github.asouza.play.paperclip.crop;

public interface CropOperation {

	public abstract int topLeftX();

	public abstract int topLeftY();

	public abstract int cropWidth();

	public abstract int cropHeight();

}