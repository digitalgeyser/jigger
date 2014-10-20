// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import com.digitalgeyser.jigger.ICliCommand;
import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.model.AbsoluteFile;

/**
 * Method that drives the adding of resources.
 *
 * Created on Oct 6, 2014
 *
 * @author Timotej
 */
public class Add implements ICliCommand {

  @Override
  public void execute(final JigContext ctx) {
    String[] args = ctx.cliOptions().commandArgs();
    for (String a : args) {
      AbsoluteFile f = new AbsoluteFile(a);
      try {
        ctx.db().addSource(f);
      } catch (JigDbException jde) {
        ctx.printer().printException(jde);
      }
    }
  }
}
