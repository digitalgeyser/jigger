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
   * The retrievable that is behind this source.
   *
   *
   * @param
   * @returns RelativeFile
   */
  public IReadable readable();
}
