package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.commons.base.AdminBaseEntity;

@Table(name = "persistent_logins")
public class PersistentLogins extends AdminBaseEntity implements Serializable {
    /**
     * 序列
     */
    @Id
    private String series;

    /**
     * 帐号
     */
    private String username;

    /**
     * TOKEN
     */
    private String token;

    /**
     * 最后使用
     */
    @Column(name = "last_used")
    private Date lastUsed;

    private static final long serialVersionUID = 1L;

    /**
     * 获取序列
     *
     * @return series - 序列
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
     * 获取帐号
     *
     * @return username - 帐号
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
     * 获取TOKEN
     *
     * @return token - TOKEN
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置TOKEN
     *
     * @param token TOKEN
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * 获取最后使用
     *
     * @return last_used - 最后使用
     */
    public Date getLastUsed() {
        return lastUsed;
    }

    /**
     * 设置最后使用
     *
     * @param lastUsed 最后使用
     */
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
}