package org.base.service;

import java.util.List;

/**
 * 
 * <p>
 * Title:BaseLogicService
 * </p>
 * <p>
 * description:逻辑层基础接口
 * </p>
 * <p>
 * company:
 * </p>
 * 
 * @author gel
 * @date 2016年5月17日
 * 
 */
public interface BaseLogicService<T> {

	/**
	 * 根据条件删除
	 * 
	 * @param record
	 * @return
	 */
	public int delete(T record);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Object id);

	/**
	 * 插入
	 * 
	 * @param record
	 * @return
	 */
	public int insert(T record);

	/**
	 * 选择插入
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(T record);

	/**
	 * 根据主键修改记录
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(T record);

	/**
	 * 根据主键 修改不为空的记录
	 * 
	 * @param record
	 * @return
	 */
	public int updaupdateByPrimaryKeySelectivete(T record);

	/**
	 * 根据主键查询
	 * 
	 * @param id
	 * @return
	 */
	public T selectByPrimaryKey(Object id);

	/**
	 * 查询全部记录
	 * 
	 * @return
	 */
	public List<T> selectAll();

	/**
	 * 根据条件查询记录总数
	 * 
	 * @param record
	 * @return
	 */
	public int selectCount(T record);
}
