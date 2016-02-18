package com.demo.company.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.demo.company.vo.MessageType;
import com.demo.company.vo.MessageVo;

@ControllerAdvice
public class ControllerValidationHandler {
  @Autowired
  private MessageSource msgSource;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public MessageVo processValidationError(MethodArgumentNotValidException ex) {
    BindingResult result = ex.getBindingResult();
    FieldError error = result.getFieldError();

    return processFieldError(error);
  }

  private MessageVo processFieldError(FieldError error) {
	  MessageVo message = null;
    if (error != null) {
      Locale currentLocale = LocaleContextHolder.getLocale();
      String msg = msgSource.getMessage(error.getDefaultMessage(), null, currentLocale);
      message = new MessageVo(MessageType.ERROR, msg);
    }
    return message;
  }
}