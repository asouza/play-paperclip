package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import com.github.asouza.play.paperclip.PaperClipPlugin;
import com.github.asouza.play.paperclip.UploadedImage;
import com.github.asouza.play.paperclip.formatter.UploadedImageFormatter;

public class Application extends Controller {
		
	private static PaperClipPlugin plugin = play.Play.application().plugin(PaperClipPlugin.class);

    public static Result index() {
    	UploadedImage image = UploadedImageFormatter.toUploadedImage(request(),"cover");
		UploadedImage croppedImage = plugin.centeredCrop(image,200,200);    
    	croppedImage.save("covers");
        return ok("imagem salva");
    }
    
    public static Result uploadForm(){
    	return ok(views.html.index.render("Faca um upload"));
    }

}
