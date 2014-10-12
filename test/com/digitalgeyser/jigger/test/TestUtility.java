// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import com.digitalgeyser.jigger.IPrinter;
import com.digitalgeyser.jigger.Print;

/**
 * Various utilities useful for testing.
 *
 * Created on Oct 12, 2014
 * @author Timotej
 */
public class TestUtility {

  private static IPrinter printer = new Print();

  public static IPrinter printer() {
    return printer;
  }

}
