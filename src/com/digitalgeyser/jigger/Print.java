// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

/**
 * Main interface to all printing.
 * 
 * Created on Oct 5, 2014
 * 
 * @author Timotej
 */
public class Print implements IPrint {

  @Override
  public void println(final String s) {
    System.out.println(s);
  }

  @Override
  public void printlnErr(final String s) {
    System.err.println(s);
  }

  public void printException(final Throwable t) {
    printlnErr("Exception: " + t.getMessage());
    t.printStackTrace();
  }
}
