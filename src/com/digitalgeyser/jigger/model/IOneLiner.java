// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import com.digitalgeyser.jigger.JigContext;

/**
 * One-liner is an object that can persist itself into a single line of human
 * readable and editable text.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public interface IOneLiner {

  /**
   * Marshal this one-liner into it's one-line.
   *
   * @returns String
   */
  public String toLine(JigContext context);

  /**
   * Unmarshall the line into this object.
   *
   * @returns void
   */
  public void fromLine(JigContext context, String line);
}
