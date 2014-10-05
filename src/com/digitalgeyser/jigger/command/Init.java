// Copyright 2014 Platycore

package com.digitalgeyser.jigger.command;

import com.digitalgeyser.jigger.Context;
import com.digitalgeyser.jigger.ICliCommand;

/**
 * Init command.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class Init implements ICliCommand {

  @Override
  public void execute(final Context ctx, final String[] args) {
    ctx.init();
  }

}
