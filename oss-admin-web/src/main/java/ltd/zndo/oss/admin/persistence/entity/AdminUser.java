package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_user")
public class AdminUser extends BaseEntity implements Serializable {
	
    /**
     * 用户唯一身份识别 ID
     */
    @Column(name = "OPENID")
    private String openid;

    /**
     * 帐号
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 登录类型：DEFAULT/DEFAULT/WEIXIN/WEIBO/GITHUB
     */
    @Column(name = "SIGNIN_TYPE")
    private String signinType;

    /**
     * 昵称
     */
    @Column(name = "NICKNAME")
    private String nickname;

    /**
     * 头像地址
     */
    @Column(name = "AVATAR_URL")
    private String avatarUrl;

    /**
     * 性别
     */
    @Column(name = "GENDER")
    private String gender;

    /**
     * 邮箱
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * 手机号
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * 用户状态：-1-已禁用/0-未激活/1-已激活
     */
    @Column(name = "USER_STATUS")
    private Integer userStatus;

    /**
     * 其他信息
     */
    @Column(name = "META")
    private String meta;

    /**
     * 个人信息MD5
     */
    @Column(name = "MD5")
    private String md5;

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
     * 获取用户唯一身份识别 ID
     *
     * @return OPENID - 用户唯一身份识别 ID
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置用户唯一身份识别 ID
     *
     * @param openid 用户唯一身份识别 ID
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 获取帐号
     *
     * @return USERNAME - 帐号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置帐号
     *
     * @param username 帐号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取登录类型：DEFAULT/DEFAULT/WEIXIN/WEIBO/GITHUB
     *
     * @return SIGNIN_TYPE - 登录类型：DEFAULT/DEFAULT/WEIXIN/WEIBO/GITHUB
     */
    public String getSigninType() {
        return signinType;
    }

    /**
     * 设置登录类型：DEFAULT/DEFAULT/WEIXIN/WEIBO/GITHUB
     *
     * @param signinType 登录类型：DEFAULT/DEFAULT/WEIXIN/WEIBO/GITHUB
     */
    public void setSigninType(String signinType) {
        this.signinType = signinType == null ? null : signinType.trim();
    }

    /**
     * 获取昵称
     *
     * @return NICKNAME - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取头像地址
     *
     * @return AVATAR_URL - 头像地址
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置头像地址
     *
     * @param avatarUrl 头像地址
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * 获取性别
     *
     * @return GENDER - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 获取邮箱
     *
     * @return EMAIL - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取手机号
     *
     * @return PHONE - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取用户状态：-1-已禁用/0-未激活/1-已激活
     *
     * @return USER_STATUS - 用户状态：-1-已禁用/0-未激活/1-已激活
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * 设置用户状态：-1-已禁用/0-未激活/1-已激活
     *
     * @param userStatus 用户状态：-1-已禁用/0-未激活/1-已激活
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * 设置是否删除：0-未删除/1-已删除
     *
     * @param deleted 是否删除：0-未删除/1-已删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 获取其他信息
     *
     * @return META - 其他信息
     */
    public String getMeta() {
        return meta;
    }

    /**
     * 设置其他信息
     *
     * @param meta 其他信息
     */
    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
    }

    /**
     * 获取个人信息MD5
     *
     * @return MD5 - 个人信息MD5
     */
    public String getMd5() {
        return md5;
    }

    /**
     * 设置个人信息MD5
     *
     * @param md5 个人信息MD5
     */
    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }
    
}