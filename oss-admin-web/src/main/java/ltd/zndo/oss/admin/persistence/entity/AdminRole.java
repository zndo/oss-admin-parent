package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.commons.base.AdminBaseEntity;

@Table(name = "admin_role")
public class AdminRole extends AdminBaseEntity implements Serializable {
	
    /**
     * 角色名
     */
    @Column(name = "ROLE_NAME")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * F_ID
     */
    @Column(name = "F_ID")
    private Long fId;

    /**
     * 角色状态：1-正常/2-禁用
     */
    @Column(name = "ROLE_STATUS")
    private Boolean roleStatus;

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
     * 是否删除：0-未删除/1-已删除
     */
    @Column(name = "DELETED")
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    /**
     * 获取角色名
     *
     * @return ROLE_NAME - 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名
     *
     * @param roleName 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 获取角色描述
     *
     * @return DESCRIPTION - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取F_ID
     *
     * @return F_ID - F_ID
     */
    public Long getfId() {
        return fId;
    }

    /**
     * 设置F_ID
     *
     * @param fId F_ID
     */
    public void setfId(Long fId) {
        this.fId = fId;
    }

    /**
     * 获取角色状态：1-正常/2-禁用
     *
     * @return ROLE_STATUS - 角色状态：1-正常/2-禁用
     */
    public Boolean getRoleStatus() {
        return roleStatus;
    }

    /**
     * 设置角色状态：1-正常/2-禁用
     *
     * @param roleStatus 角色状态：1-正常/2-禁用
     */
    public void setRoleStatus(Boolean roleStatus) {
        this.roleStatus = roleStatus;
    }

}