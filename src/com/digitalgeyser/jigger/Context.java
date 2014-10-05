// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.io.File;

/**
 * The context class is carried along with ALL the build targets.
 * It lives for the entire duration of the execution of all targets.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class Context {

  /**
   * Initializes the .jig directory and the basic database.
   *
   *
   * @param
   * @returns void
   */
  public void init() {
    File dotJig = new File(".jig");
    if ( dotJig.exists() ) {
      Print.out().println(".jig already exists.");
    } else {
      dotJig.mkdirs();
    }
  }

  /**
   * Initialization of the context means reading the .jig directory.
   *
   *
   * @param
   * @returns boolean
   */
  public boolean read() {
    File dotJig = new File(".jig");
    if ( dotJig.exists() && dotJig.isDirectory() ) {
      try {
        readDotJig(dotJig);
        return true;
      } catch (Exception e) {
        Print.err(e);
        return false;
      }
    } else {
      Print.out().println("Can't find .jig directory. Do 'jig init' to create one.");
      return false;
    }
  }

  private void readDotJig(final File f) {

  }
}
