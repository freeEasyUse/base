package org.base.service.logicImpl;

import org.base.dao.StockInfoMapper;
import org.base.dao.entity.StockInfo;
import org.base.dao.entity_t.Person;
import org.base.dao_t.PersonMapper;
import org.base.service.logic.DealTwoDdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * <p>Title:DealTwoDbServiceImpl</p>
 * <p>description:</p>
 * <p>company:</p>
 * @author gel
 * @date 2016年5月17日
 *
 */
@Service
public class DealTwoDbServiceImpl implements DealTwoDdService {

	@Autowired
	private StockInfoMapper stockInfoMapper;
	
	@Autowired
	private PersonMapper personMapper;
	
	
	@Transactional(rollbackFor=Exception.class,value="distributed")
	@Override
	public void addTwoRecord(Person person, StockInfo stockInfo) throws Exception {
		personMapper.insert(person);
		stockInfoMapper.insert(stockInfo);
		throw new Exception();
	}

}
