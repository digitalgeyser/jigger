// Copyright 2014 Platycore

package com.digitalgeyser.jigger.impl;

import com.digitalgeyser.jigger.file.JigFile;
import com.digitalgeyser.jigger.model.ISource;

/**
 * Static class that deals with sources.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class SourceUtilities {

  private SourceUtilities() {
  }

  /**
   * This method creates a source from the file information. It will inspect the
   * file and create a right type out of it.
   *
   *
   * @param
   * @returns ISource
   */
  public static ISource createSource(final JigFile f) {
    return new UncategorizedFileSource(f);
  }

}
