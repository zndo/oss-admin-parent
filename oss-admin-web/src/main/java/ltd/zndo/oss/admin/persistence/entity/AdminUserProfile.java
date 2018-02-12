package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_user_profile")
public class AdminUserProfile extends BaseEntity implements Serializable {
	
    /**
     * 用户ID，外键
     */
    @Column(name = "USERID")
    private Long userid;

    /**
     * 真实姓名
     */
    @Column(name = "REALNAME")
    private String realname;

    /**
     * 身份证号
     */
    @Column(name = "IDENTITY")
    private String identity;

    /**
     * 住址
     */
    @Column(name = "ADDRESS")
    private String address;

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
     * 获取用户ID，外键
     *
     * @return USERID - 用户ID，外键
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户ID，外键
     *
     * @param userid 用户ID，外键
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取真实姓名
     *
     * @return REALNAME - 真实姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实姓名
     *
     * @param realname 真实姓名
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 获取身份证号
     *
     * @return IDENTITY - 身份证号
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 设置身份证号
     *
     * @param identity 身份证号
     */
    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    /**
     * 获取住址
     *
     * @return ADDRESS - 住址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置住址
     *
     * @param address 住址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

}