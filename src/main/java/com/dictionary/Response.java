package com.dictionary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

  String message;
  String code;
  Status status;
  T data;

  @JsonCreator
  public Response(@JsonProperty("message") String message, @JsonProperty("state") Status status,
      @JsonProperty("data") T data, @JsonProperty("code") String code) {
    this.message = message;
    this.status = status;
    this.data = data;
    this.code = code;
  }

  public Response(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static <T> Response<T> success(String message, T data) {
    return new Response<>(message, Status.SUCCESS, data, null);
  }

  public static <T> Response<T> success(T data) {
    return success(null, data);
  }

}
