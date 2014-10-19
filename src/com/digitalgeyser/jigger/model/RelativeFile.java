// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import java.io.File;

/**
 * Default implementation of IRelativeFile
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class RelativeFile implements IReadable, IWritable {

  private final File f;
  private final FileRelativity relativity;

  public RelativeFile(final File f) {
    this.f = f;
    this.relativity = FileRelativity.ABSOLUTE;
  }

  public File file() {
    return f;
  }

  public FileRelativity relativity() {
    return relativity;
  }

}
