// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

/**
 * Classes of this type are implementing a single CLI command.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public interface ICliCommand {

  /** Executes a command */
  public void execute(Context ctx, String[] args);
}