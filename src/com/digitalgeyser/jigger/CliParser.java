// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.text.ParseException;

import com.digitalgeyser.jigger.command.CommandRegistry;

/**
 * This class contains everything that
 * 
 * Created on Oct 5, 2014
 * 
 * @author Timotej
 */
public class CliParser {

  static enum Cmd {
    INIT;
  }

  static enum Args {
    VERSION, HELP;
  }

  /**
   * Entry method that parses entire command line and returns a parsed object.
   * 
   * @param
   * @returns CliData
   */
  public static CliOptions parse(final IPrint p, final String[] args)
      throws ParseException {
    CliOptions cd = new CliOptions();

    boolean gotCommand = false;
    for (String arg : args) {
      if (arg.equals("-?")) {
        cd.processArgument(p, Args.HELP, "");
      } else if (arg.startsWith("-")) {
        while (arg.startsWith("-")) {
          arg = arg.substring(1);
        }
        boolean match = false;
        for (Args a : Args.values()) {
          if (arg.toUpperCase().startsWith(a.name().toUpperCase())) {
            // Match
            cd.processArgument(p, a, arg.substring(a.name().length()));
            match = true;
            break;
          }
        }
        if (!match) {
          throw new ParseException("Invalid option: " + arg, -1);
        }
      } else {
        if (!gotCommand) {
          String cmdName = arg.toLowerCase();
          ICliCommand cmd = CommandRegistry.instance().command(cmdName);
          if (cmd == null) {
            throw new ParseException("Invalid command: " + arg, -1);
          }
          cd.setCommand(cmdName, cmd);
          gotCommand = true;
        } else {
          cd.addTarget(arg);
        }
      }
    }
    return cd;
  }
}
