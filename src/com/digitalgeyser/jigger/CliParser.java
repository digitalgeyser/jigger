// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import com.digitalgeyser.jigger.command.CommandRegistry;


/**
 * This class contains everything that
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class CliParser {

  static enum Cmd {
    INIT;
  }

  static enum Args {
    VERSION,
    HELP;
  }

  /**
   * Entry method that parses entire command line and returns a parsed
   * object.
   *
   * @param
   * @returns CliData
   */
  public static CliOptions parse(final String[] args) {
    CliOptions cd = new CliOptions();

    boolean gotCommand = false;
    for (String arg: args ) {
      if ( arg.equals("-?")) {
        cd.processArgument(Args.HELP, "");
      } else if ( arg.startsWith("-") ) {
        while(arg.startsWith("-")) {
          arg = arg.substring(1);
        }
        boolean match = false;
        for ( Args a: Args.values() ) {
          if ( arg.toUpperCase().startsWith(a.name().toUpperCase())) {
            // Match
            cd.processArgument(a, arg.substring(a.name().length()));
            match = true;
            break;
          }
        }
        if ( !match ) {
          Print.out().println("Invalid option: " + arg);
        }
      } else {
        if ( !gotCommand ) {
          String cmdName = arg.toLowerCase();
          ICliCommand cmd = CommandRegistry.instance().command(cmdName);
          if ( cmd == null ) {
            Print.out().println("Invalid command: " + arg);
            break;
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
