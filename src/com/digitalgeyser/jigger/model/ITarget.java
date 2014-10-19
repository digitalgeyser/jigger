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
   * Writable output that is behind the target.
   *
   *
   * @param
   * @returns IWritable
   */
  public IWritable writable();
}
