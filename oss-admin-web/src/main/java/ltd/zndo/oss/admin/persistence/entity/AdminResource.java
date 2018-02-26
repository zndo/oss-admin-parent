package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_resource")
public class AdminResource extends BaseEntity implements Serializable {
	
    /**
     * 资源类型
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 资源名
     */
    @Column(name = "RESOURCE_NAME")
    private String resourceName;

    /**
     * 资源描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 资源地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 优先级
     */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * 资源状态：0-FALSE-禁用/1-TRUE-正常
     */
    @Column(name = "RESOURCE_STATUS")
    private Boolean resourceStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取资源类型
     *
     * @return TYPE - 资源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置资源类型
     *
     * @param type 资源类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取资源名
     *
     * @return RESOURCE_NAME - 资源名
     */
    public String getResourceName() {
        return resourceName;
    }

    /**
     * 设置资源名
     *
     * @param resourceName 资源名
     */
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    /**
     * 获取资源描述
     *
     * @return DESCRIPTION - 资源描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置资源描述
     *
     * @param description 资源描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取资源地址
     *
     * @return URL - 资源地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置资源地址
     *
     * @param url 资源地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取优先级
     *
     * @return PRIORITY - 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置优先级
     *
     * @param priority 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取资源状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @return RESOURCE_STATUS - 资源状态：0-FALSE-禁用/1-TRUE-正常
     */
    public Boolean getResourceStatus() {
        return resourceStatus;
    }

    /**
     * 设置资源状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @param resourceStatus 资源状态：0-FALSE-禁用/1-TRUE-正常
     */
    public void setResourceStatus(Boolean resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

}