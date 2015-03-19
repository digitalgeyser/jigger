// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.db.JigDbManager;
import com.digitalgeyser.jigger.file.JigDir;

/**
 * The config class is carried along with ALL the build targets. It lives for
 * the entire duration of the execution of all targets.
 *
 * Created on Oct 5, 2014
 *
 * @author Timotej
 */
public class JigContext {

  private IJigDatabase jd;
  private final JigDir workDir;
  private final CliOptions opts;
  private final IPrinter print;

  public JigContext(final IPrinter p, final JigDir workDir,
      final CliOptions opts) {
    this.opts = opts;
    this.workDir = workDir;
    this.print = p;
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
   * Returns the database.
   *
   * @returns IJigDatabase
   */
  public IJigDatabase db() {
    return jd;
  }

  /**
   * Returns the printer.
   *
   * @returns IPrinter
   */
  public IPrinter printer() {
    return print;
  }

  /**
   * This method executes the command within the cli options, using this object
   * itself as a context.
   *
   *
   * @param
   * @returns void
   */
  public void execute() throws JigException {
    if (opts.command() == null)
      throw new IllegalStateException("Can't execute context with no command");
    if (opts.commandName() != "init") {
      read();
    }
    opts.command().execute(this);
  }

  /**
   * Returns the command line options.
   *
   *
   * @param
   * @returns CliOptions
   */
  public CliOptions cliOptions() {
    return opts;
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
}
