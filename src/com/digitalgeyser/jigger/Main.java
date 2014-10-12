// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.io.File;

import com.digitalgeyser.jigger.command.CommandRegistry;

/**
 * Main entrypoint.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class Main {

  public static String VERSION = "0.0.1";

  /**
   * Main entrypoint.
   *
   * @param
   * @returns void
   */
  public static void main(final String[] args) {
    (new Main()).run(args);
  }

  private void run(final String[] args) {
    CliOptions opts = CliParser.parse(args);

    JigConfig jc = new JigConfig(new File("."));
    if ( opts.command() == null ) {
      CommandRegistry.instance().printHelp();
      return;
    } else {
      opts.command().execute(jc, opts.commandArgs());
    }
  }
}
