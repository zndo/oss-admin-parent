package ltd.zndo.oss.admin.commons.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AdminBaseEntity implements Serializable {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -6714818680438665121L;

	/**
     * ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

	/**
     * 创建时间
     */
    @Column(name = "CREATED")
    protected Date created;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED")
    protected Date updated;

    /**
     * 是否删除：0-未删除/1-已删除
     */
    @Column(name = "DELETED")
    protected Boolean deleted;

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
     * @param id ID
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
     * @param created 创建时间
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
     * @param updated 更新时间
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * 获取是否删除：0-未删除/1-已删除
     *
     * @return DELETED - 是否删除：0-未删除/1-已删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置是否删除：0-未删除/1-已删除
     *
     * @param deleted 是否删除：0-未删除/1-已删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

}
