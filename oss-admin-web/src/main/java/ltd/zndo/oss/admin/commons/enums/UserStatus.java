package ltd.zndo.oss.admin.commons.enums;

/**
 * 用户状态枚举
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2017/8/30 9:00
 * @modified 2017/8/30 9:30
 * @since
 * @version 1.0.2
 *
 */
public enum UserStatus {

	DISABLED(-1, "DISABLED"), // 已禁用
	INACTIVE(0, "INACTIVE"), // 未激活
	ACTIVED(1, "ACTIVED") // 已激活
	;

	private Integer code;
	private String desc;

	UserStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static UserStatus getEnumByCode(Integer code) {

		for (UserStatus smsEnums : values()) {
			if (smsEnums.code == code) {
				return smsEnums;
			}
		}

		return null;
	}

	public Integer getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

}
