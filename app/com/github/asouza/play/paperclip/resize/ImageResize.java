package com.github.asouza.play.paperclip.resize;

import com.github.asouza.play.paperclip.UploadedImage;

public interface ImageResize {

	int width(UploadedImage image);

	int height(UploadedImage image);

}
