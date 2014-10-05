// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.io.PrintStream;

/**
 * Main interface to all printing.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class Print {

  public static PrintStream out() {
    return System.out;
  }

  public static PrintStream err() {
    return System.err;
  }
}
