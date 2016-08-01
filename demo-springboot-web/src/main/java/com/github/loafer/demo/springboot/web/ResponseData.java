package com.github.loafer.demo.springboot.web;

/**
 * @author zhaojh.
 */
public class ResponseData {
  private static final String OK = "ok";
  private static final String ERROR = "error";

  private Meta meta;
  private Object data;

  public ResponseData success(){
    this.success(null);
    return this;
  }

  public ResponseData success(Object data){
    this.meta = new Meta(true, OK);
    this.data = data;
    return this;
  }

  public ResponseData failure(){
    this.failure(ERROR);
    return this;
  }

  public ResponseData failure(String message){
    this.meta = new Meta(false, message);
    return this;
  }

  public Meta getMeta() {
    return meta;
  }

  public Object getData() {
    return data;
  }

  @Override
  public String toString() {
    return "ResponseData{" +
           "meta=" + meta +
           ", data=" + data +
           '}';
  }

  public static class Meta {

    private boolean success;
    private String message;

    public Meta(boolean success, String message) {
      this.success = success;
      this.message = message;
    }

    public boolean isSuccess() {
      return success;
    }

    public String getMessage() {
      return message;
    }

    @Override
    public String toString() {
      return "Meta{" +
             "success=" + success +
             ", message='" + message + '\'' +
             '}';
    }
  }
}
