// Copyright 2014 Platycore

package com.digitalgeyser.jigger.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.yaml.snakeyaml.Yaml;

/**
 * Static utilities for working with Yaml.
 *
 * Created on Dec 8, 2014
 * @author Timotej
 */
public class YamlUtilities {

  /**
   * Reads yaml from string, returning the parsed object.
   *
   *
   * @param
   * @returns Object
   */
  public static Object readYaml(final String s) throws IOException {
    Yaml y = new Yaml();
    return y.load(s);
  }

  /**
   * Read yaml from file, returning the parsed object.
   *
   *
   * @param
   * @returns Object
   */
  public static Object readYamlFile(final File f) throws IOException {
    Yaml y = new Yaml();
    FileInputStream fis = null;
    try {
      fis = new FileInputStream(f);
      return y.load(fis);
    } finally {
      if ( fis != null ) fis.close();
    }
  }
}
