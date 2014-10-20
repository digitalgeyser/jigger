// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db.fs;

import java.io.IOException;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.impl.SourceUtilities;
import com.digitalgeyser.jigger.model.AbsoluteDirectory;
import com.digitalgeyser.jigger.model.AbsoluteFile;
import com.digitalgeyser.jigger.model.ISource;
import com.digitalgeyser.jigger.model.ITarget;

/**
 * Implementation of the IJigDatabase that saves and reads it's content from the
 * .jig directory at the root of the project.
 *
 * Created on Oct 12, 2014
 *
 * @author Timotej
 */
public class DotJigDatabase implements IJigDatabase {
  private static final String DIR = ".jig";

  private AbsoluteDirectory dotJig;
  private AbsoluteDirectory sourceDir;
  private AbsoluteDirectory targetDir;

  private void initializeDirectories(final AbsoluteDirectory d) {
    this.dotJig = d;
    this.sourceDir = d.subdir("source");
    this.targetDir = d.subdir("target");
  }

  @Override
  public void createNew(final AbsoluteDirectory projectRoot)
      throws JigDbException {
    AbsoluteDirectory d = new AbsoluteDirectory(projectRoot, DIR);
    if (d.exists()) {
      throw new JigDbException(DIR + " already exists.");
    }
    d.mkdir();
    if (d.exists()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException("Could not create " + DIR + " directory.");
    }
  }

  @Override
  public void read(final AbsoluteDirectory projectRoot) throws JigDbException {
    AbsoluteDirectory d = projectRoot.subdir(DIR);
    if (d.exists()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException(DIR
          + " is missing. You need to run 'init' first.");
    }
  }

  @Override
  public ISource addSource(final AbsoluteFile source) throws JigDbException {
    if (!sourceDir.exists())
      sourceDir.mkdir();
    ISource s = SourceUtilities.createSource(source);
    try {
      sourceDir.touch(s.name());
      return s;
    } catch (IOException ioe) {
      throw new JigDbException(ioe);
    }
  }

  @Override
  public ITarget addTarget(final AbsoluteFile destination)
      throws JigDbException {
    return null;
  }
}
