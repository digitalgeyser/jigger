// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import java.io.File;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.db.JigDbManager;

/**
 * The config class is carried along with ALL the build targets.
 * It lives for the entire duration of the execution of all targets.
 *
 * Created on Oct 5, 2014
 * @author Timotej
 */
public class JigConfig {

  private IJigDatabase jd;
  private final File workDir;

  public JigConfig(final File workDir) {
    this.workDir = workDir;
  }

  /**
   * Initializes the .jig directory and the basic database.
   *
   *
   * @param
   * @returns void
   */
  public void init() throws JigDbException {
    jd = JigDbManager.instance().getDefault();
    jd.createNew(workDir);
  }

  /**
   * Initialization of the context means reading the .jig directory.
   *
   *
   * @param
   * @returns boolean
   */
  public void read() throws JigDbException {
    jd = JigDbManager.instance().getDefault();
    jd.read(workDir);
  }

  /**
   * General method used to report errors.
   *
   *
   * @param
   * @returns void
   */
  public void reportError(final Exception e) {
    Print.err().println("Error: " + e.getMessage());
    e.printStackTrace();
  }
}
