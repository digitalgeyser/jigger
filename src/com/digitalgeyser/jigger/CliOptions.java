// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.util.ArrayList;
import java.util.List;


/**
 * When parsing command line, this object gets created as a result of the parse.
 *
 * Created on Oct 5, 2014
 *
 * @author Timotej
 */
public class CliOptions {
  private final List<String> commandArgs = new ArrayList<String>();
  private String commandName = null;
  private ICliCommand command = null;
  private boolean verbose = false;

  synchronized void addTarget(final String t) {
    commandArgs.add(t);
  }

  void processArgument(final IPrinter p, final GlobalOptions a, final String s) {
    switch (a) {
    case VERSION:
      p.println("Jigger, version " + Main.VERSION);
      break;
    case VERBOSE:
      p.println("Verbose mode on.");
      this.verbose = true;
      break;
    }
  }

  /**
   * Returns the command that was requested.
   *
   * @returns CliCommand
   */
  public ICliCommand command() {
    return command;
  }

  /**
   * Returns all the targets that were requested to be built from the command
   * line.
   */
  public String[] commandArgs() {
    return commandArgs.toArray(new String[0]);
  }

  /**
   * Sets the command
   */
  public void setCommand(final String cmdName, final ICliCommand cmd) {
    this.commandName = cmdName;
    this.command = cmd;
  }

  /**
   * Returns the command name. May be null if no command was present.
   *
   * @returns String
   */
  public String commandName() {
    return commandName;
  }

  /**
   * Returns the count of all the targets that were requested
   *
   * @returns int
   */
  public int commandArgCount() {
    return commandArgs.size();
  }

  /**
   * Returns true if -verbose switch was passed on cli.
   *
   */
  public boolean isVebose() {
    return verbose;
  }
}