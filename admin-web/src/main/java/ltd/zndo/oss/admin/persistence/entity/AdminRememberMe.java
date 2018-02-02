package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.commons.base.AdminBaseEntity;

@Table(name = "admin_remember_me")
public class AdminRememberMe extends AdminBaseEntity implements Serializable {
	
    /**
     * 帐号
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * 序列
     */
    @Column(name = "SERIES")
    private String series;

    /**
     * 令牌
     */
    @Column(name = "TOKEN")
    private String token;

    /**
     * 记录状态：1-正常/2-禁用
     */
    @Column(name = "REC_STATUS")
    private Boolean recStatus;

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
     * 获取序列
     *
     * @return SERIES - 序列
     */
    public String getSeries() {
        return series;
    }

    /**
     * 设置序列
     *
     * @param series 序列
     */
    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    /**
     * 获取令牌
     *
     * @return TOKEN - 令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置令牌
     *
     * @param token 令牌
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取记录状态：1-正常/2-禁用
     *
     * @return REC_STATUS - 记录状态：1-正常/2-禁用
     */
    public Boolean getRecStatus() {
        return recStatus;
    }

    /**
     * 设置记录状态：1-正常/2-禁用
     *
     * @param recStatus 记录状态：1-正常/2-禁用
     */
    public void setRecStatus(Boolean recStatus) {
        this.recStatus = recStatus;
    }

}