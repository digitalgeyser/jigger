// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import java.io.File;

/**
 * Object of this type resolve into a file, but carry along information how they
 * want to be saved in terms of relativity.
 * 
 * Created on Oct 19, 2014
 * 
 * @author Timotej
 */
public interface IRelativeFile {

  /**
   * Returns a file that this object represents.
   * 
   * @returns File
   */
  public File file();

  /**
   * Returns the relativity mode that will be used when saving this file path.
   * 
   * @returns FileRelativity
   */
  public FileRelativity relativity();
}
