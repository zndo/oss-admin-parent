package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_authority_resources")
public class AdminAuthorityResource extends BaseEntity implements Serializable {
	
    /**
     * 角色ID
     */
    @Column(name = "AUTHORITYID")
    private Long authorityid;

    /**
     * 权限ID
     */
    @Column(name = "RESOURCEID")
    private Long resourceid;

    /**
     * 关系状态：0-FALSE-禁用/1-TRUE-正常
     */
    @Column(name = "RLAT_STATUS")
    private Boolean rlatStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色ID
     *
     * @return AUTHORITYID - 角色ID
     */
    public Long getAuthorityid() {
        return authorityid;
    }

    /**
     * 设置角色ID
     *
     * @param authorityid 角色ID
     */
    public void setAuthorityid(Long authorityid) {
        this.authorityid = authorityid;
    }

    /**
     * 获取权限ID
     *
     * @return RESOURCEID - 权限ID
     */
    public Long getResourceid() {
        return resourceid;
    }

    /**
     * 设置权限ID
     *
     * @param resourceid 权限ID
     */
    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    /**
     * 获取关系状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @return RLAT_STATUS - 关系状态：0-FALSE-禁用/1-TRUE-正常
     */
    public Boolean getRlatStatus() {
        return rlatStatus;
    }

    /**
     * 设置关系状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @param rlatStatus 关系状态：0-FALSE-禁用/1-TRUE-正常
     */
    public void setRlatStatus(Boolean rlatStatus) {
        this.rlatStatus = rlatStatus;
    }

}