package ltd.zndo.oss.admin.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import ltd.zndo.oss.admin.persistence.base.BaseEntity;

@Table(name = "admin_module")
public class AdminModule extends BaseEntity implements Serializable {
	
    /**
     * 模块类型
     */
    @Column(name = "TYPE")
    private String type;

    /**
     * 模块名
     */
    @Column(name = "MODULE_NAME")
    private String moduleName;

    /**
     * 模块描述
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * 父模块
     */
    @Column(name = "PARENT_MODULE")
    private String parentModule;

    /**
     * 模块地址
     */
    @Column(name = "URL")
    private String url;

    /**
     * 菜单级别
     */
    @Column(name = "MENU_LEVEL")
    private Integer menuLevel;

    /**
     * 最下级
     */
    @Column(name = "BUTTOM_LEVEL")
    private Integer buttomLevel;

    /**
     * 应用名
     */
    @Column(name = "APP_NAME")
    private String appName;

    /**
     * 控制器名
     */
    @Column(name = "CONTROLLER_NAME")
    private String controllerName;

    /**
     * 优先级
     */
    @Column(name = "PRIORITY")
    private Integer priority;

    /**
     * 模块状态：0-FALSE-禁用/1-TRUE-正常
     */
    @Column(name = "MODULE_STATUS")
    private Boolean moduleStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取模块类型
     *
     * @return TYPE - 模块类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置模块类型
     *
     * @param type 模块类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取模块名
     *
     * @return MODULE_NAME - 模块名
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * 设置模块名
     *
     * @param moduleName 模块名
     */
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    /**
     * 获取模块描述
     *
     * @return DESCRIPTION - 模块描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置模块描述
     *
     * @param description 模块描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取父模块
     *
     * @return PARENT_MODULE - 父模块
     */
    public String getParentModule() {
        return parentModule;
    }

    /**
     * 设置父模块
     *
     * @param parentModule 父模块
     */
    public void setParentModule(String parentModule) {
        this.parentModule = parentModule == null ? null : parentModule.trim();
    }

    /**
     * 获取模块地址
     *
     * @return URL - 模块地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置模块地址
     *
     * @param url 模块地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取菜单级别
     *
     * @return MENU_LEVEL - 菜单级别
     */
    public Integer getMenuLevel() {
        return menuLevel;
    }

    /**
     * 设置菜单级别
     *
     * @param menuLevel 菜单级别
     */
    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    /**
     * 获取最下级
     *
     * @return BUTTOM_LEVEL - 最下级
     */
    public Integer getButtomLevel() {
        return buttomLevel;
    }

    /**
     * 设置最下级
     *
     * @param buttomLevel 最下级
     */
    public void setButtomLevel(Integer buttomLevel) {
        this.buttomLevel = buttomLevel;
    }

    /**
     * 获取应用名
     *
     * @return APP_NAME - 应用名
     */
    public String getAppName() {
        return appName;
    }

    /**
     * 设置应用名
     *
     * @param appName 应用名
     */
    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    /**
     * 获取控制器名
     *
     * @return CONTROLLER_NAME - 控制器名
     */
    public String getControllerName() {
        return controllerName;
    }

    /**
     * 设置控制器名
     *
     * @param controllerName 控制器名
     */
    public void setControllerName(String controllerName) {
        this.controllerName = controllerName == null ? null : controllerName.trim();
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
     * 获取模块状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @return MODULE_STATUS - 模块状态：0-FALSE-禁用/1-TRUE-正常
     */
    public Boolean getModuleStatus() {
        return moduleStatus;
    }

    /**
     * 设置模块状态：0-FALSE-禁用/1-TRUE-正常
     *
     * @param moduleStatus 模块状态：0-FALSE-禁用/1-TRUE-正常
     */
    public void setModuleStatus(Boolean moduleStatus) {
        this.moduleStatus = moduleStatus;
    }

}