// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.IPrinter;
import com.digitalgeyser.jigger.JigContext;

/**
 * Help commands prints the help for a given command.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class Help implements ICliCommand {

  @Override
  public void execute(final JigContext jc) {
    String[] args = jc.cliOptions().commandArgs();
    if (args.length == 0) {
      printGeneralHelp(jc.printer());
    } else {
      printCommandHelp(jc.printer(), args[0]);
    }
  }

  private static void printGeneralHelp(final IPrinter p) {
    p.println("General help");
  }

  private static void printCommandHelp(final IPrinter p, final String cmd) {
    ICliCommand c = CommandRegistry.instance().command(cmd);
    if (c == null) {
      p.println("Invalid command: " + cmd);
    } else {
      URL url = CommandRegistry.instance().commandHelp(cmd);
      if (url == null) {
        p.println("No help for command: " + cmd);
      } else {
        try {
          String s = IOUtils.toString(url);
          p.println(s);
        } catch (IOException ioe) {
          p.println("Could find help for command: " + cmd);
          p.printException(ioe);
        }
      }
    }
  }
}
