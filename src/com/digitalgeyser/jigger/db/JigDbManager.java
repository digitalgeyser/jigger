// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db;

import com.digitalgeyser.jigger.db.fs.DotJigDatabase;

/**
 * Toplevel class for managing different database implementations.
 * 
 * Created on Oct 12, 2014
 * 
 * @author Timotej
 */
public class JigDbManager {

  private static class LazyHolder {
    private static final JigDbManager instance = new JigDbManager();
  }

  /**
   * Returns the single instance of this class.
   * 
   * 
   * @param
   * @returns CommandRegistry
   */
  public static JigDbManager instance() {
    return LazyHolder.instance;
  }

  private JigDbManager() {
  }

  /**
   * Returns the default implementation of the IJigDatabase that will be used if
   * nothing else is specified.
   * 
   * 
   * @param
   * @returns IJigDatabase
   */
  public IJigDatabase getDefault() {
    return new DotJigDatabase();
  }

}
