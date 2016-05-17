package org.base.service;

import java.util.List;

import tk.mybatis.mapper.common.Mapper;

/**
 * 
 * <p>Title:AbastractLogicService</p>
 * <p>description:抽象基础逻辑实现类 逻辑服务可以继承这个类</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
public abstract class AbastractLogicService<T> implements BaseLogicService<T> {

	private Mapper<T> baseMapper;

	public void setBaseMapper(Mapper<T> mapper) {
		this.baseMapper = mapper;
	}

	/**
	 * 根据条件删除
	 * 
	 * @param record
	 * @return
	 */
	public int delete(T record) {
		return baseMapper.delete(record);
	}

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Object id) {
		return baseMapper.deleteByPrimaryKey(id);
	}

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	public int insert(T record) {
		return baseMapper.insert(record);
	}

	/**
	 * 选择插入
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(T record) {
		return baseMapper.insertSelective(record);
	}

	/**
	 * 根据主键修改记录
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(T record) {
		return baseMapper.updateByPrimaryKey(record);
	}

	/**
	 * 根据主键 修改不为空的记录
	 * 
	 * @param record
	 * @return
	 */
	public int updaupdateByPrimaryKeySelectivete(T record) {
		return baseMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(Object id) {
		return baseMapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询全部记录
	 * 
	 * @return
	 */
	public List<T> selectAll() {
		return baseMapper.selectAll();
	}

	/**
	 * 根据条件查询记录总数
	 * 
	 * @param record
	 * @return
	 */
	public int selectCount(T record) {
		return baseMapper.selectCount(record);
	}
	
	
}
