package com.server.rest.java.server.rest.classRMD;

public class Error {
  private Long error_code;
  private String message;
  public Long getError_code() {
    return error_code;
  }
  public void setError_code(Long error_code) {
    this.error_code = error_code;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  @Override
  public String toString() {
    return "Error{" + "error_code=" + error_code + ", message='" + message + '\'' + '}';
  }
}
