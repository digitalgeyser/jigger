// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db.fs;

import com.digitalgeyser.jigger.db.IJigDatabase;
import com.digitalgeyser.jigger.db.JigDbException;
import com.digitalgeyser.jigger.impl.SourceUtilities;
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

  private AbsoluteFile dotJig;
  private AbsoluteFile sourceDir;
  private AbsoluteFile destinationDir;

  private void initializeDirectories(final AbsoluteFile d) {
    this.dotJig = d;
    this.sourceDir = new AbsoluteFile(d, "source");
    this.destinationDir = new AbsoluteFile(d, "destination");
  }

  @Override
  public void createNew(final AbsoluteFile projectRoot) throws JigDbException {
    AbsoluteFile d = new AbsoluteFile(projectRoot, DIR);
    if (d.exists()) {
      throw new JigDbException(DIR + " already exists.");
    }
    d.mkdirs();
    if (d.exists() && d.isDirectory()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException("Could not create " + DIR + " directory.");
    }
  }

  @Override
  public void read(final AbsoluteFile projectRoot) throws JigDbException {
    AbsoluteFile d = new AbsoluteFile(projectRoot, DIR);
    if (d.exists() && d.isDirectory()) {
      initializeDirectories(d);
    } else {
      throw new JigDbException(DIR
          + " is missing. You need to run 'init' first.");
    }
  }

  @Override
  public ISource addSource(final AbsoluteFile source) throws JigDbException {
    if (!sourceDir.exists())
      sourceDir.mkdirs();
    ISource s = SourceUtilities.createSource(source);
    // TODO: Add physical saving
    return s;
  }

  @Override
  public ITarget addTarget(final AbsoluteFile destination)
      throws JigDbException {
    return null;
  }
}
