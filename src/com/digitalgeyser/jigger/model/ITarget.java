// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

/**
 * Target is the output of a translation.
 * 
 * Created on Oct 19, 2014
 * 
 * @author Timotej
 */
public interface ITarget extends ISaveable {

  /**
   * The file that is behind this target.
   * 
   * 
   * @param
   * @returns IRelativeFile
   */
  public IRelativeFile relativeFile();
}
