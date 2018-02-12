package ltd.zndo.oss.admin.service.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.BaseMapper;

/**
 * 基础持久化 Service
 * 
 * @author admin
 *
 * @entity <T>
 */
public interface IBaseService<T extends Serializable> {//, Pabstract class

//	@Autowired
//	private BaseMapper<T> mapper;
//
//	/**
//	 * 按条件查询列表
//	 * 
//	 * @entity entity
//	 * @return
//	 */
//	public List<T> list(T entity) {
//		return mapper.select(entity);
//	}
//
//	/**
//	 * 查询所有，返回列表-不推荐
//	 * 
//	 * @entity entity
//	 * @return
//	 */
//	public List<T> all() {
//		return mapper.selectAll();
//	}
//
//	/**
//	 * 按条件查询一条
//	 * 
//	 * @entity entity
//	 * @return
//	 */
//	public T one(T entity) {
//		return mapper.selectOne(entity);
//	}
//
//	/**
//	 * 根据 ID 查询
//	 * 
//	 * @entity id-ID
//	 * @return
//	 */
//	public T selectById(Long id) {
//		return this.mapper.selectByPrimaryKey(id);
//	}
//
//	/**
//	 * 更新
//	 * 
//	 * @entity id-ID
//	 * @return
//	 */
//	public Integer update(T entity) {
//		return this.mapper.updateByPrimaryKeySelective(entity);
//	}
//
//	/**
//	 * 根据 ID 删除
//	 * 
//	 * @entity id-ID
//	 * @return
//	 */
//	public Integer deleteById(Long id) {
//		return this.mapper.deleteByPrimaryKey(id);
//	}
//
//	/**
//	 * 根据条件删除
//	 * 
//	 * @entity id-ID
//	 * @return
//	 */
//	public Integer delete(T entity) {
//		return this.mapper.delete(entity);
//	}
//
//	/**
//	 * 新增一条记录
//	 * 
//	 * @entity
//	 */
//	public void save(T entity) {
//
//		T existsEntity = mapper.selectOne(entity);
//
//		if (existsEntity != null) {
//			this.mapper.updateByPrimaryKey(entity);
//		} else {
//			this.mapper.insert(entity);
//		}
//	}

	// public List<T> getAll(P entitys) ;
	//
	// public T getById(Integer id) ;
	//
	//
	// public void save(P entitys) ;

	// public List<T> getAll(T UserInfo) {
	// if (UserInfo.getPage() != null && UserInfo.getRows() != null) {
	// PageHelper.startPage(UserInfo.getPage(), UserInfo.getRows());
	// }
	// return userInfoMapper.selectAll();
	// }
	//
	// public void deleteById(Integer id) {
	// userInfoMapper.deleteByPrimaryKey(id);
	// }
	//
	// public void save(UserInfo country) {
	// if (country.getId() != null) {
	// userInfoMapper.updateByPrimaryKey(country);
	// } else {
	// userInfoMapper.insert(country);
	// }
	// }

}
