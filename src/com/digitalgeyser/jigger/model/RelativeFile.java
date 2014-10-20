// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import com.digitalgeyser.jigger.JigContext;

/**
 * Default implementation of IRelativeFile
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public class RelativeFile implements IReadable, IWritable {

  private AbsoluteFile f;
  private FileRelativity relativity;

  public RelativeFile() {
    f = null;
    relativity = FileRelativity.ABSOLUTE;
  }

  public RelativeFile(final AbsoluteFile f) {
    this.f = f;
    this.relativity = FileRelativity.ABSOLUTE;
  }

  public String name() {
    return f.name();
  }

  @Override
  public void fromLine(final JigContext context, final String line) {
    f = new AbsoluteFile(line);
    relativity = FileRelativity.ABSOLUTE;
  }

  @Override
  public String toLine(final JigContext context) {
    return f.toString();
  }
}
