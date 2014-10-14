// Copyright 2014 Platycore

package com.digitalgeyser.jigger.model;

import com.digitalgeyser.jigger.JigException;

/**
 * Translation is a mechanism of translating source into a target. Translation,
 * is for example compiling a.c into a.o. Translation, is compiling X.java into
 * X.class You get the point.
 * 
 * Created on Oct 14, 2014
 * 
 * @author Timotej
 */
public interface ITranslation {

  /**
   * Perform a translation.
   * 
   * 
   * @param ISource source
   * @returns ITarget
   */
  public ITarget translate(ISource source) throws JigException;
}
