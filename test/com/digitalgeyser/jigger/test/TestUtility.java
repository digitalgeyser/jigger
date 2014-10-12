// Copyright 2014 Platycore

package com.digitalgeyser.jigger.test;

import com.digitalgeyser.jigger.IPrint;
import com.digitalgeyser.jigger.Print;

/**
 * Various utilities useful for testing.
 *
 * Created on Oct 12, 2014
 * @author Timotej
 */
public class TestUtility {

  private static IPrint printer = new Print();

  public static IPrint printer() {
    return printer;
  }

}
