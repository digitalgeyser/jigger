// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

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

    Context ctx = new Context();
    if ( opts.command() == CliCommand.INIT ) {
      ctx.init();
    }
    if ( !ctx.read()) {
      return;
    }
    runCommand(ctx, opts.command(), opts.commandArgs());
  }

  private void runCommand(final Context ctx,
                          final CliCommand cmd,
                          final String[] args) {
    Print.out().println("Running '" + cmd + "'");
  }
}
