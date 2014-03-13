#Play-Paperclip

A plugin to handle with image manipulation.

#Usage

```
  PaperClipPlugin plugin = play.Play.application().plugin(PaperClipPlugin.class);
 	UploadedImage image = UploadedImageFormatter.toUploadedImage(request(),"inputFileName");
	UploadedImage croppedImage = plugin.centeredCrop(image,200,200);		
	return croppedImage.save("folder_in_public_images");
```