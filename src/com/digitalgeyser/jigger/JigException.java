// Copyright 2014 Platycore

package com.digitalgeyser.jigger;

/**
 * Main exception used in Jigger.
 * 
 * Created on Oct 14, 2014
 * 
 * @author Timotej
 */
public class JigException extends Exception {

  private static final long serialVersionUID = -5762316996880458645L;

  public JigException() {
  }

  public JigException(final String message) {
    super(message);

  }

  public JigException(final Throwable cause) {
    super(cause);

  }

  public JigException(final String message, final Throwable cause) {
    super(message, cause);

  }
}
