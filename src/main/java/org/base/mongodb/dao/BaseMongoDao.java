package org.base.mongodb.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.base.util.common.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.CommandResult;

/**
 * 
 * <p>Title:BaseMongoDao</p>
 * <p>description:mongodb基础dao</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月10日
 *
 */
public class BaseMongoDao<T> {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	/**
	 * 批量插入
	 * @param batchToSave
	 * @param collection
	 */
	public void insertBacth(List<T> batchToSave,String collection){
		mongoTemplate.insert(batchToSave, collection);
	}
	
	
	/**
	 * 单个插入
	 * @param t
	 */
	public void insert(T t){
		mongoTemplate.insert(t);
	}
	
	
	/**
	 * 根据出入对象的属性值 查找 and
	 * 适用简单属性 不适合复杂属性的查询
	 * @param t
	 * @return
	 */
	@SuppressWarnings("all")
	public <T> List<T> queryEntity(T t,String collection) {
		Query query = createQuery(t);
		return (List<T>) mongoTemplate.find(query, t.getClass(),collection);
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
		return mongoTemplate.find(query, c,colletion);
	}
	
	/**
	 * 删除record
	 * @param t
	 * @param collection
	 */
	public void removeEntity(T t,String collection){
		mongoTemplate.remove(t, collection);
	}
	
	/**
	 * 自定义删除条件
	 * @param query
	 * @param collection
	 */
	public void removeEntity(Query query,String collection){
		mongoTemplate.remove(query, collection);
	}
	
	
	/**
	 * 在原始entity进行更新
	 * 若查询不到 则直接插入记录
	 * @param oldObj
	 * @param newObj
	 * @param collection
	 */
	public void updateEntity(T oldObj,T newObj,String collection){
		mongoTemplate.upsert(createQuery(oldObj), createUpdate(newObj), collection);
	}
	
	/**
	 * 自定义查询条件和更新内容
	 * @param query
	 * @param update
	 * @param collection
	 */
	public void updateEntity(Query query,Update update,String collection){
		mongoTemplate.upsert(query,update,collection);
	}
	
	/**
	 * 执行json命令
	 * @param jsonCommand
	 * @return
	 */
	public CommandResult execCommand(String jsonCommand){
		return mongoTemplate.executeCommand(jsonCommand);
	}
	
	@SuppressWarnings("hiding")
	private <T> Update createUpdate(T t){
		Update update = new Update();
		Field[] fields = t.getClass().getDeclaredFields();
		for(Field f:fields){
			String fieldName = f.getName();
			Object value = null;
			try {
				value = BeanUtils.getProperty(t, fieldName);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (value != null) {
				update.set(fieldName, value);
			}
		}
		return update;
	}
	
	/**
	 * 根据entity设置 query条件
	 * @param t
	 * @return
	 */
	@SuppressWarnings("hiding")
	private <T> Query createQuery(T t) {
		Query query = new Query();
		// 获取所有的属性
		Field[] fields = t.getClass().getDeclaredFields();
		// 将不为空的属性 设置查询值
		for (Field f : fields) {
			String fieldName = f.getName();
			Object value = null;
			try {
				value = BeanUtils.getProperty(t, fieldName);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (value != null) {
				value = CommonUtil.changeStrByType((String) value, f.getType().getName());
				Criteria c = new Criteria(fieldName).is(value);
				query.addCriteria(c);
			}
		}
		return query;
	}
	
	
}
