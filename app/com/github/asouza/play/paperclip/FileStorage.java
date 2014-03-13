package com.github.asouza.play.paperclip;

import java.io.InputStream;
import java.net.URL;

public interface FileStorage {

	URL store(InputStream is, String path, String contentTypeOf);

}
