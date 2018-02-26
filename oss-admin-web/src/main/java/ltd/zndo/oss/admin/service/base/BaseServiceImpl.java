package ltd.zndo.oss.admin.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ltd.zndo.oss.admin.persistence.base.IBaseMapper;

/**
 * 基础 Service 实现类
 * 
 * @author admin
 *
 * @entity <T>
 */
public class BaseServiceImpl<T extends Serializable> implements IBaseService<T> {

	@Autowired
	private IBaseMapper<T> mapper;

	/**
	 * 按条件查询列表
	 * 
	 * @entity entity
	 * @return
	 */
	public List<T> list(T entity) {
		return mapper.select(entity);
	}

	/**
	 * 查询所有，返回列表-不推荐
	 * 
	 * @entity entity
	 * @return
	 */
	public List<T> all() {
		return mapper.selectAll();
	}

	/**
	 * 按条件查询一条
	 * 
	 * @entity entity
	 * @return
	 */
	public T one(T entity) {
		return mapper.selectOne(entity);
	}

	/**
	 * 根据 ID 查询一条
	 * 
	 * @entity id-ID
	 * @return
	 */
	public T selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新
	 * 
	 * @entity id-ID
	 * @return
	 */
	public Integer update(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	/**
	 * 根据 ID 删除
	 * 
	 * @entity id-ID
	 * @return
	 */
	public Integer deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public Integer batchRemove(List<Long> list) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据条件删除
	 * 
	 * @entity id-ID
	 * @return
	 */
	public Integer delete(T entity) {
		return mapper.delete(entity);
	}

	/**
	 * 新增一条记录
	 * 
	 * @entity
	 */
	public void save(T entity) {

		T existsEntity = mapper.selectOne(entity);

		if (existsEntity != null) {
			mapper.updateByPrimaryKey(entity);
		} else {
			mapper.insert(entity);
		}
	}

	/**
	 * 批量新增记录
	 * 
	 * @entity
	 */
	public void batSave(List<T> list) {
		mapper.insertList(list);
	}

	@Override
	public List<T> listByIds(List<Long> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
