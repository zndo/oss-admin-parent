package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_role_modules")
public class AdminRoleModule extends BaseEntity implements Serializable {
	
    /**
     * 角色ID
     */
    @Column(name = "ROLEID")
    private Long roleid;

    /**
     * 模块ID
     */
    @Column(name = "MODULEID")
    private Long moduleid;

    /**
     * 关系状态：0-FALSE-禁用/1-TRUE-正常
     */
    @Column(name = "RLAT_STATUS")
    private Boolean rlatStatus;

    private static final long serialVersionUID = 1L;

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
     * 获取模块ID
     *
     * @return MODULEID - 模块ID
     */
    public Long getModuleid() {
        return moduleid;
    }

    /**
     * 设置模块ID
     *
     * @param moduleid 模块ID
     */
    public void setModuleid(Long moduleid) {
        this.moduleid = moduleid;
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