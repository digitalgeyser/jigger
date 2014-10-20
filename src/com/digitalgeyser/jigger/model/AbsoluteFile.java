// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Abstraction for a file.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class AbsoluteFile {

  private final File f;

  public AbsoluteFile(final String path) {
    this.f = new File(path);
  }

  public AbsoluteFile(final AbsoluteFile f, final String name) {
    this.f = new File(f.f, name);
  }

  public boolean exists() {
    return f.exists();
  }

  public void mkdirs() {
    f.mkdirs();
  }

  public boolean isDirectory() {
    return f.isDirectory();
  }

  public void deleteDirectory() throws IOException {
    FileUtils.deleteDirectory(f);
  }
}
