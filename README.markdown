#Play-Paperclip

A plugin to handle with image manipulation.

##Usage

```
  public static Result storeImage() throws IOException {
    PaperClipPlugin plugin = play.Play.application().plugin(PaperClipPlugin.class);
   	UploadedImage image = UploadedImageFormatter.toUploadedImage(request(),"inputFileName");
  	UploadedImage croppedImage = plugin.centeredCrop(image,200,200);		
  	return ok(croppedImage.save("folder_in_public_images"));
  }
```

##Configuration

Just configure `PaperClipPlugin` in play.plugins

```
  10500:com.github.asouza.play.paperclip.PaperClipPlugin
```
