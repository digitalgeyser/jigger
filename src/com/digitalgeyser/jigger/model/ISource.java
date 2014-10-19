// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

/**
 * Source is something that exists as an input for translation.
 * 
 * Created on Oct 19, 2014
 * 
 * @author Timotej
 */
public interface ISource extends ISaveable {

  /**
   * The file that is behind this source.
   * 
   * 
   * @param
   * @returns IRelativeFile
   */
  public IRelativeFile relativeFile();
}
