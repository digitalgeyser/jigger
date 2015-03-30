// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.text.ParseException;

import com.digitalgeyser.jigger.command.CommandRegistry;

/**
 * This class contains everything related with parsing the command line.
 *
 * Created on Oct 5, 2014
 *
 * @author Timotej
 */
public class CliParser {

  /**
   * Entry method that parses entire command line and returns a parsed object.
   *
   * Command line format is:
   *    ./jig [GLOBAL_OPTIONS] [COMMAND] [COMMAND_OPTIONS]
   *
   * For example:
   *
   *
   * @param
   * @returns CliData
   */
  public static CliOptions parse(final IPrinter p, final String[] args)
      throws ParseException {
    CliOptions cli = new CliOptions();

    boolean gotCommand = false;
    for (String arg : args) {
      if (!gotCommand && arg.startsWith("-")) {
        while (arg.startsWith("-")) {
          arg = arg.substring(1);
        }
        boolean match = false;
        for (GlobalOptions a : GlobalOptions.values()) {
          if (arg.toUpperCase().startsWith(a.name().toUpperCase())) {
            // Match
            cli.processArgument(p, a, arg.substring(a.name().length()));
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
          cli.setCommand(cmdName, cmd);
          gotCommand = true;
        } else {
          cli.addTarget(arg);
        }
      }
    }
    return cli;
  }
}
