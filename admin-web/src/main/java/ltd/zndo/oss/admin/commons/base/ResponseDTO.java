package ltd.zndo.oss.admin.commons.base;

import java.io.Serializable;

/**
 * 响应 DTO
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2017/8/30 9:00
 * @modified 2017/8/30 9:30
 * @since
 * @version 1.0.2
 * 
 */
public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = -3959669078252731873L;

	// Fields

	private String code; // 业务代码
	private String msg; // 业务消息
	private int status; // HTTP 状态代码
	private long timestamp; // 时间戳

	// Constructors

	public ResponseDTO() {
		super();
	}

	public ResponseDTO(String code, String msg, int status, long timestamp) {
		super();
		this.code = code;
		this.msg = msg;
		this.status = status;
		this.timestamp = timestamp;
	}

	// Getters & Setters

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// UDF

	public static ResponseDTO getInstance() {
		return new ResponseDTO();
	}

	/**
	 * 响应构建接口
	 * 
	 * @author tianxin<tianxin@weconex.com>
	 * @created 2017/8/30 9:00
	 * @modified 2017/8/30 9:30
	 * @since
	 * @version 1.0.2
	 *
	 */
	public interface ResponseBuilder {
	}

	/**
	 * 默认响应构建类
	 * 
	 * @author tianxin<tianxin@weconex.com>
	 * @created 2017/8/30 9:00
	 * @modified 2017/8/30 9:30
	 * @since
	 * @version 1.0.2
	 *
	 */
	public static class DefaultResponseBuilder implements ResponseBuilder {

		/**
		 * 构建
		 * 
		 * @param code
		 * @param msg
		 * @param status
		 * @return
		 */
		public static ResponseDTO build(String code, String msg, int status) {

			ResponseDTO response = ResponseDTO.getInstance();
			response.setCode(code);
			response.setMsg(msg);
			response.setStatus(status);
			response.setTimestamp(System.currentTimeMillis());

			return response;
		}

	}

}
