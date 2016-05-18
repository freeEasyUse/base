package org.base.service.logic;

import org.base.dao.entity.StockInfo;
import org.base.dao.entity_t.Person;

/**
 * 
 * <p>Title:DealTwoDdService</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
public interface DealTwoDdService {

	public void addTwoRecord(Person person,StockInfo stockInfo) throws Exception; 
	
}
