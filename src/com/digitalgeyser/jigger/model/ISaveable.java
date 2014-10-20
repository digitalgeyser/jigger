// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import java.util.List;

import com.digitalgeyser.jigger.JigContext;
import com.digitalgeyser.jigger.JigException;

/**
 * Anything that is ISaveable can be saved into a text file.
 *
 * Created on Oct 19, 2014
 *
 * @author Timotej
 */
public interface ISaveable {

  /**
   * Create a text representation of this saveable.
   *
   * @returns List<String>
   */
  public List<String> marshall(JigContext context);

  /**
   * Restore the object from a text representation.
   *
   * @returns void
   */
  public void unmarshall(JigContext context, List<String> list)
      throws JigException;
}
