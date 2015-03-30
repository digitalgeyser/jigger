// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.text.ParseException;

import com.digitalgeyser.jigger.command.CommandRegistry;
import com.digitalgeyser.jigger.file.JigDir;

/**
 * Main entrypoint.
 *
 * Created on Oct 5, 2014
 *
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
    IPrinter p = new Print();
    CliOptions opts;

    try {
      opts = CliParser.parse(p, args);
    } catch (ParseException pe) {
      p.printException(pe);
      return;
    }
    JigContext jc = new JigContext(p, new JigDir("."), opts);
    if (jc.cliOptions().command() == null) {
      try {
        CommandRegistry.instance().printHelp(jc);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return;
    } else {
      try {
        jc.cliOptions().command().execute(jc);
      } catch (JigException je) {
        jc.printer().printException(je);
      }
    }
  }
}
