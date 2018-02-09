package ltd.zndo.oss.admin.commons.base;

import java.io.Serializable;
import java.util.Date;

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

	private int code; // 业务代码
	private String message; // 业务消息
	private int status; // HTTP 状态代码
	private Date datetime; // 时间

	// Constructors

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public ResponseDTO() {
		super();
	}

	public ResponseDTO(int code, String message, int status, Date datetime) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
		this.datetime = datetime;
	}

	// Getters & Setters


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
		public static ResponseDTO build(int code, String message, int status) {

			ResponseDTO response = ResponseDTO.getInstance();
			response.setCode(code);
			response.setMessage(message);
			response.setStatus(status);
			response.setDatetime(new Date());

			return response;
		}

	}

}
