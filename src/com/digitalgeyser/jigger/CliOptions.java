// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.util.ArrayList;
import java.util.List;

import com.digitalgeyser.jigger.CliParser.Args;

/**
 * When parsing command line, of tthese objects gets created.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class CliOptions {
  private final List<String> commandArgs = new ArrayList<String>();
  private ICliCommand command = null;

  synchronized void addTarget(final String t) {
    commandArgs.add(t);
  }

  void processArgument(final Args a, final String s) {
    switch(a) {
    case VERSION:
      Print.out().println("Jigger, version " + Main.VERSION);
      break;
    case HELP:
      Print.out().println("Usage: jig [OPTIONS] TARGET1 TARGET2 ...");
      Print.out().println("Valid options:");
      for ( Args arg: Args.values() ) {
        Print.out().println("  -" + arg.name().toLowerCase() + ": ");
      }
      break;
    }
  }

  /**
   * Returns the command that was requested.
   * @returns CliCommand
   */
  public ICliCommand command() { return command; }

  /**
   * Returns all the targets that were requested to be built from the
   * command line.
   */
  public String[] commandArgs() {
    return commandArgs.toArray(new String[0]);
  }

  /**
   * Sets the command
   */
  public void setCommand(final ICliCommand cmd) {
    this.command = cmd;
  }

  /**
   * Returns the count of all the targets that were requested
   *
   * @returns int
   */
  public int commandArgCount() {
    return commandArgs.size();
  }
}