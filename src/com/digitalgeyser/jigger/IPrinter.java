// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

/**
 * Interface that describes the printing.
 * 
 * Created on Oct 12, 2014
 * 
 * @author Timotej
 */
public interface IPrinter {

  /** Prints a line to output stream */
  public void println(String s);

  /** Prints a line to error stream */
  public void printlnErr(String s);

  /** Prints an exception */
  public void printException(Throwable t);
}
