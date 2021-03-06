package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_authority")
public class AdminAuthority extends BaseEntity implements Serializable {
	
    /**
     * 权限标识
     */
    @Column(name = "AUTHORITY")
    private String authority;

    /**
     * 权限名
     */
    @Column(name = "AUTHORITY_NAME")
    private String authorityName;

    /**
     * 权限描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 权限状态：0-FALSE-禁用/1-TRUE-正常
     */
    @Column(name = "AUTHORITY_STATUS")
    private Boolean authorityStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取权限标识
     *
     * @return AUTHORITY - 权限标识
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 设置权限标识
     *
     * @param authority 权限标识
     */
    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }

    /**
     * 获取权限名
     *
     * @return AUTHORITY_NAME - 权限名
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 设置权限名
     *
     * @param authorityName 权限名
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }

    /**
     * 获取权限描述
     *
     * @return DESCRIPTION - 权限描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置权限描述
     *
     * @param description 权限描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取权限状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @return AUTHORITY_STATUS - 权限状态：0-FALSE-禁用/1-TRUE-正常
     */
    public Boolean getAuthorityStatus() {
        return authorityStatus;
    }

    /**
     * 设置权限状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @param authorityStatus 权限状态：0-FALSE-禁用/1-TRUE-正常
     */
    public void setAuthorityStatus(Boolean authorityStatus) {
        this.authorityStatus = authorityStatus;
    }

}