// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

/**
 * Enum of all available commands from the command line.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public enum CliCommand {
  INIT;
  
  public static void printHelp() {
    Print.out().println("Valid commands:");
    for ( CliCommand c: values() ) {
      Print.out().println("  " + c.name().toLowerCase());
    }
  }
}
