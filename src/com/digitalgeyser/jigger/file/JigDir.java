// Copyright 2014 Platycore

package com.digitalgeyser.jigger.file;

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
public class JigDir {

  private final File dir;

  private JigDir(final File dir) {
    this.dir = dir;
  }

  public JigDir(final String path) {
    this(new File(path));
  }

  public JigDir(final JigDir dir, final String name) {
    this(new File(dir.dir(), name));
  }

  /**
   * Create a file in this directory. File will be empty. Same as 'touch'.
   *
   *
   * @param
   * @returns File
   */
  public JigFile touch(final String name) throws IOException {
    JigFile af = new JigFile(this, name);
    af.touch();
    return af;
  }

  /**
   * Create a file reference in this directory.
   *
   *
   * @param
   * @returns File
   */
  public JigFile file(final String name) throws IOException {
    return new JigFile(this, name);
  }

  public JigDir subdir(final String name) {
    return new JigDir(this, name);
  }

  public JigDir mkdir(final String name) throws IOException {
    JigDir dir = subdir(name);
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
