// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * Abstraction for a directory.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class AbsoluteDirectory {

  private final File dir;

  private AbsoluteDirectory(final File dir) {
    this.dir = dir;
  }

  public AbsoluteDirectory(final String path) {
    this(new File(path));
  }

  public AbsoluteDirectory(final AbsoluteDirectory dir, final String name) {
    this(new File(dir.dir(), name));
  }

  /**
   * Create a file in this directory. File will be empty. Same as 'touch'.
   *
   *
   * @param
   * @returns File
   */
  public AbsoluteFile touch(final String name) throws IOException {
    AbsoluteFile af = new AbsoluteFile(this, name);
    af.touch();
    return af;
  }

  public AbsoluteDirectory subdir(final String name) {
    return new AbsoluteDirectory(this, name);
  }

  public AbsoluteDirectory mkdir(final String name) throws IOException {
    AbsoluteDirectory dir = subdir(name);
    dir.mkdir();
    return dir;
  }

  public void mkdir() {
    dir.mkdirs();
  }

  public boolean exists() {
    return dir.exists();
  }

  public void rmdir() throws IOException {
    FileUtils.deleteDirectory(dir);
  }

  File dir() {
    return dir;
  }

}
