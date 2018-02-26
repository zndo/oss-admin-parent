package ltd.zndo.oss.admin.service.base;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 基础 Service
 * 
 * @author admin
 *
 * @entity <T>
 */
public interface IBaseService<T extends Serializable> {

	/**
	 * 按条件查询列表
	 * 
	 * @entity entity
	 * @return
	 */
	List<T> list(T entity);

	/**
	 * 按 ID 列表查询列表
	 * 
	 * @entity entity
	 * @return
	 */
	List<T> listByIds(@Param("ids") List<Long> list);

	/**
	 * 查询所有，返回列表-不推荐
	 * 
	 * @entity entity
	 * @return
	 */
	List<T> all();

	/**
	 * 按条件查询一条
	 * 
	 * @entity entity
	 * @return
	 */
	T one(T entity) ;

	/**
	 * 根据 ID 查询
	 * 
	 * @entity id-ID
	 * @return
	 */
	T selectById(Long id);

	/**
	 * 更新
	 * 
	 * @entity id-ID
	 * @return
	 */
	Integer update(T entity) ;

	/**
	 * 根据 ID 删除
	 * 
	 * @entity id-ID
	 * @return
	 */
	Integer deleteById(Long id);

	/**
	 * 批量删除
	 * 
	 * @entity id-ID
	 * @return
	 */
	Integer batchRemove(List<Long> list);

	/**
	 * 根据条件删除
	 * 
	 * @entity id-ID
	 * @return
	 */
	Integer delete(T entity);

	/**
	 * 新增一条记录
	 * 
	 * @entity
	 */
	void save(T entity) ;

	/**
	 * 批量新增记录
	 * 
	 * @entity
	 */
	void batSave(List<T> list) ;

}
