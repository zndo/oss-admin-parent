package ltd.zndo.oss.admin.commons.enums;

/**
 * 记录删除状态枚举
 * 
 * @author tianxin<tianxin@weconex.com>
 * @created 2017/8/30 9:00
 * @modified 2017/8/30 9:30
 * @since
 * @version 1.0.2
 *
 */
public enum RecordStatus {

	UNDELETED(0, "UNDELETED"), // FALSE-未删除
	DELETED(1, "DELETED") // TRUE-未删除
	;

	private Integer code;
	private String desc;

	RecordStatus(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static RecordStatus getEnumByCode(Integer code) {

		for (RecordStatus smsEnums : values()) {
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
