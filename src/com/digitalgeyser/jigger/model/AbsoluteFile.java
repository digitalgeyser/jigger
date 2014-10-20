// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

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
public class AbsoluteFile {

  private final File f;

  public AbsoluteFile(final String path) {
    this.f = new File(path);
  }

  public AbsoluteFile(final AbsoluteDirectory f, final String name) {
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
}
