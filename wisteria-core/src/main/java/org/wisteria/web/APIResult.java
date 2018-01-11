package org.wisteria.web;

import java.io.Serializable;

/**
 * 调用接口的执行结果类
 * @author Lei.Liu
 *
 * @param <T>	输出数据的类型
 */
public class APIResult<T> implements Serializable {
	private static final long serialVersionUID = -8792785262618671597L;

	public APIResult() {}
	
	public APIResult(boolean success, T data) {
		this(success, null, null, data);
	}
	
	public APIResult(boolean success, String message) {
		this(success, null, message, null);
	}
	
	public APIResult(boolean success, String code, String message, T data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * 创建成功的执行结果
	 * @return	返回接口调用的执行结果类
	 */
	public static <T> APIResult<T> success() {
		return success(null);
	}
	
	/**
	 * 创建成功的执行结果，并输出数据
	 * @param data	输出的数据
	 * @return		返回接口调用的执行结果类
	 */
	public static <T> APIResult<T> success(T data) {
		return new APIResult<T>(true, data);
	}
	
	/**
	 * 创建失败的执行结构，并输出消息
	 * @param message	输出的消息
	 * @return			返回接口调用的执行结果类
	 */
	public static <T> APIResult<T> fail(String message) {
		return new APIResult<T>(false, message);
	}
	
	/**
	 * 接口执行结果状态
	 * true：成功；false：失败
	 */
	private boolean success;
	
	/**
	 * 接口执行结果输出的消息的代码
	 */
	private String code;
	
	/**
	 * 接口执行结果输出的消息的文本
	 */
	private String message;
	
	/**
	 * 接口执行结果输出的数据
	 */
	private T data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
