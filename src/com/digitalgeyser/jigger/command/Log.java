// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.JigContext;

/**
 * Log command deals with log.
 *
 * Created on Dec 8, 2014
 * @author Timotej
 */
public class Log implements ICliCommand {

  @Override
  public void execute(final JigContext jc) {
    String[] args = jc.cliOptions().commandArgs();
    if ( args.length == 0 ) {
      // Print log

    } else if ( "clean".equals(args[0]) ) {

    }
  }

}
