// Copyright 2014 Platycore

package com.digitalgeyser.jigger.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Abstraction for a file.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class JigFile {

  private final File f;

  public JigFile(final String path) {
    this.f = new File(path);
  }

  public JigFile(final JigDir f, final String name) {
    this.f = new File(f.dir(), name);
  }

  public String name() {
    return f.getName();
  }

  public boolean exists() {
    return f.exists();
  }

  public void touch() throws IOException {
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(f);
    } finally {
      fos.close();
    }
  }

  public File file() {
    return f;
  }
}
