package com.shiv.exceptionHandler;

public class DataNotFoundException extends  RuntimeException{

 public DataNotFoundException(String errorMessage) {
      super(errorMessage);
  }

}
