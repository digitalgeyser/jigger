// Copyright 2014 Platycore

package com.digitalgeyser.jigger.impl;

import java.io.File;

import com.digitalgeyser.jigger.model.FileRelativity;
import com.digitalgeyser.jigger.model.IRelativeFile;

/**
 * Default implementation of IRelativeFile
 * 
 * Created on Oct 19, 2014
 * 
 * @author Timotej
 */
public class RelativeFile implements IRelativeFile {

  private final File f;

  public RelativeFile(final File f) {
    this.f = f;
  }

  @Override
  public File file() {
    return f;
  }

  @Override
  public FileRelativity relativity() {
    return FileRelativity.ABSOLUTE;
  }

}
