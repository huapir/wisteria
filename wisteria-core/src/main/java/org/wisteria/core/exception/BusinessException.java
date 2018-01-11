package org.wisteria.core.exception;

/**
 * 系统业务处理异常类
 * @author Lei.Liu
 *
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1720283557480368402L;

	public BusinessException() {
        super();
    }
    
    public BusinessException(String message) {
        super(message);
    }
    
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
