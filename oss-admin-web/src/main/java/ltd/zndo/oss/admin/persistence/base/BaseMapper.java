package ltd.zndo.oss.admin.persistence.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 自定义 Mapper，拓展 MySql 的接口方法
 * 
 * @author admin
 *
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
