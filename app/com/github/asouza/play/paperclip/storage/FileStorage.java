package com.github.asouza.play.paperclip.storage;

import java.io.InputStream;

public interface FileStorage {

	String store(InputStream is, String path, String contentTypeOf);

}
