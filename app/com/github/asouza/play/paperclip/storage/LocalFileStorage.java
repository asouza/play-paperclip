package com.github.asouza.play.paperclip.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import play.Configuration;
import play.Logger;

public class LocalFileStorage implements FileStorage {
	
	private String assetsUrl = Configuration.root().getString("play_paperclip.assets_url");

	@Override
	public String store(InputStream is, String path, String contentTypeOf) {
		Logger.debug("Saving file in public/images/" + path);
		File dest = new File("public/images/", path);
		dest.getParentFile().mkdirs();
		copy(is, dest);
		return urlFor(path);
	}

	private String urlFor(String path) {
		return assetsUrl + "/" + path;
	}

	private void copy(InputStream is, File dest) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(dest);
			IOUtils.copy(is, fileOutputStream);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}
