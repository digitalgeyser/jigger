// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.util.List;

/**
 * This class contains everything that
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class CliParser {

  private static enum Args {
    VERSION,
    HELP;
  }

  public static class CliData {
    private List<String> targets;

    void addTarget(final String t) {
      targets.add(t);
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
      }
    }
  }

  /**
   * Entry method that parses entire command line and returns a parsed
   * object.
   *
   * @param
   * @returns CliData
   */
  public static CliData parse(final String[] args) {
    CliData cd = new CliData();

    for (String arg: args ) {
      if ( arg.equals("-?")) {
        cd.processArgument(Args.HELP, "");
      } else if ( arg.startsWith("-") ) {
        while(arg.startsWith("-")) {
          arg = arg.substring(1);
        }
        for ( Args a: Args.values() ) {
          if ( arg.toUpperCase().startsWith(a.name().toUpperCase())) {
            // Match
            cd.processArgument(a, arg.substring(a.name().length()));
            break;
          }
        }
      } else {
        cd.addTarget(arg);
      }
    }
    return cd;
  }
}
