package com.ctse.user.controller.exception.handel;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String msg) {
    super(msg);
  }
}
