package org.wisteria.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.wisteria.core.exception.BusinessException;

/**
 * 统一异常处理类
 * @author Lei.Liu
 */
@ControllerAdvice
public class ControllerExceptionHandler {
    
    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    
    private static final String ERROR_MESSAGE = "系统异常，请联系管理员";
    
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus
    @ResponseBody
    public APIResult<Object> runtimeExceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        
        BusinessException businessException = null;
        
        if (e instanceof BusinessException) {
            businessException = (BusinessException)e;
        } else {
            businessException = new BusinessException(ERROR_MESSAGE);
        }
        
        return APIResult.fail(businessException.getMessage());
    }
    
}
