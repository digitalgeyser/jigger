// Copyright 2014 Platycore

package com.digitalgeyser.jigger.db;

/**
 * This exception is used to signify any kind of problems with reading to or
 * writing from the database.
 * 
 * Created on Oct 12, 2014
 * 
 * @author Timotej
 */
public class JigDbException extends Exception {

  private static final long serialVersionUID = -1969966409803718947L;

  public JigDbException() {
    super();
  }

  public JigDbException(final String message, final Throwable cause) {
    super(message, cause);

  }

  public JigDbException(final String message) {
    super(message);

  }

  public JigDbException(final Throwable cause) {
    super(cause);
  }

}
