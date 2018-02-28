package ltd.zndo.oss.admin.persistence.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class BaseEntity implements Serializable {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -6714818680438665121L;

	@Transient
	private String order; // 排序

	@Transient
	private String orderBy; // 排序字段

	@Transient
	private String orderType; // 排序类型

	@Transient
	private Integer pageNum; // 默认页码

	@Transient
	private Integer pageSize; // 默认条数

	// public Long creator; // 创建者

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ID
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATED")
	public Date created;

	/**
	 * 更新时间
	 */
	@Column(name = "UPDATED")
	public Date updated;

	/**
	 * 是否删除：0-false-未删除/1-true-已删除
	 */
	@Column(name = "DELETED")
	public Boolean deleted;

	/**
	 * 获取ID
	 * 
	 * @return ID - ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID
	 * 
	 * @param id
	 *            ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取创建时间
	 *
	 * @return CREATED - 创建时间
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * 设置创建时间
	 *
	 * @param created
	 *            创建时间
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * 获取更新时间
	 *
	 * @return UPDATED - 更新时间
	 */
	public Date getUpdated() {
		return updated;
	}

	/**
	 * 设置更新时间
	 *
	 * @param updated
	 *            更新时间
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	/**
	 * 获取是否删除：0-FALSE-未删除/1-TRUE-已删除
	 *
	 * @return DELETED - 是否删除：0-FALSE-未删除/1-TRUE-已删除
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * 设置是否删除：0-FALSE-未删除/1-TRUE-已删除
	 *
	 * @param deleted
	 *            是否删除：0-FALSE-未删除/1-TRUE-已删除
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		Field[] fields = this.getClass().getDeclaredFields();
		try {
			for (Field f : fields) {
				f.setAccessible(true);
				builder.append(f.getName(), f.get(this));
			}
		} catch (Exception e) {
			builder.append("toString 构造器发生了一个错误");
		}
		return builder.toString();
	}

}
