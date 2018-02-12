package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_user_roles")
public class AdminUserRole extends BaseEntity implements Serializable {
	
    /**
     * 用户ID
     */
    @Column(name = "USERID")
    private Long userid;

    /**
     * 角色ID
     */
    @Column(name = "ROLEID")
    private Long roleid;

    /**
     * 关系状态：0-FALSE-禁用/1-TRUE-正常
     */
    @Column(name = "RLAT_STATUS")
    private Boolean rlatStatus;

    /**
     * 创建时间
     */
    @Column(name = "CREATED")
    private Date created;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED")
    private Date updated;

    /**
     * 是否删除：0-FALSE-未删除/1-TRUE-已删除
     */
    @Column(name = "DELETED")
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户ID
     *
     * @return USERID - 用户ID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户ID
     *
     * @param userid 用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取角色ID
     *
     * @return ROLEID - 角色ID
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * 设置角色ID
     *
     * @param roleid 角色ID
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
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