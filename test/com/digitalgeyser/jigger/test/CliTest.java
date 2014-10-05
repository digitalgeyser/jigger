// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import org.junit.Assert;
import org.junit.Test;

import com.digitalgeyser.jigger.CliCommand;
import com.digitalgeyser.jigger.CliOptions;

/**
 * Unit test for command line options.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class CliTest {

  @Test
  public void testCliOptions() {
    CliOptions opts = new CliOptions();
    opts.setCommand(CliCommand.INIT);
    Assert.assertEquals(CliCommand.INIT, opts.command());
  }
}
