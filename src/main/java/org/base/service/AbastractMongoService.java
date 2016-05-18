package org.base.service;

import java.util.List;

import org.base.mongodb.dao.BaseMongoDao;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.CommandResult;

/**
 * 
 * <p>Title:AbatractMongoService</p>
 * <p>description:mongoService抽象服务类</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
public abstract class AbastractMongoService<T> implements BaseMongoService<T> {
	
	private BaseMongoDao<T> baseMongoDao;
	
	public void setBaseMongoDao(BaseMongoDao<T> baseMongoDao) {
		this.baseMongoDao = baseMongoDao;
	}


	/**
	 * 批量插入
	 * @param batchToSave
	 * @param collection
	 */
	public void insertBacth(List<T> batchToSave,String collection){
		baseMongoDao.insertBacth(batchToSave, collection);
	}
	
	
	/**
	 * 单个插入
	 * @param t
	 */
	public void insert(T t){
		baseMongoDao.insert(t);
	}
	
	
	/**
	 * 根据出入对象的属性值 查找 and
	 * 适用简单属性 不适合复杂属性的查询
	 * @param t
	 * @return
	 */
	@SuppressWarnings("all")
	public <T> List<T> queryEntity(T t,String collection) {
		return baseMongoDao.queryEntity(t, collection);
	}
	
	
	/**
	 * 通过自定义的query条件查询
	 * @param query
	 * @param c
	 * @param colletion
	 * @return
	 */
	@SuppressWarnings("all")
	public <T> List<T> queryEntity(Query query,Class c,String colletion){
		return baseMongoDao.queryEntity(query, c,colletion);
	}
	
	/**
	 * 删除record
	 * @param t
	 * @param collection
	 */
	public void removeEntity(T t,String collection){
		baseMongoDao.removeEntity(t, collection);
	}
	
	/**
	 * 自定义删除条件
	 * @param query
	 * @param collection
	 */
	public void removeEntity(Query query,String collection){
		baseMongoDao.removeEntity(query, collection);
	}
	
	
	/**
	 * 在原始entity进行更新
	 * 若查询不到 则直接插入记录
	 * @param oldObj
	 * @param newObj
	 * @param collection
	 */
	public void updateEntity(T oldObj,T newObj,String collection){
		baseMongoDao.updateEntity(oldObj,newObj,collection);
	}
	
	/**
	 * 自定义查询条件和更新内容
	 * @param query
	 * @param update
	 * @param collection
	 */
	public void updateEntity(Query query,Update update,String collection){
		baseMongoDao.updateEntity(query,update,collection);
	}
	
	/**
	 * 执行json命令
	 * @param jsonCommand
	 * @return
	 */
	public CommandResult execCommand(String jsonCommand){
		return baseMongoDao.execCommand(jsonCommand);
	}
	
	
}
