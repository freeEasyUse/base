package org.base.service.logicImpl;

import java.util.HashMap;
import java.util.Map;

import org.base.dao.StockInfoMapper;
import org.base.dao.entity.StockInfo;
import org.base.service.AbastractLogicService;
import org.base.service.logic.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class StockInfoServiceImpl extends AbastractLogicService<StockInfo> implements StockInfoService {

	@Autowired
	private StockInfoMapper stockInfoMapper;
	
	@Autowired
	private void setMapper(){
		super.setBaseMapper(stockInfoMapper);
	}

	@Override
	public Map<String, Object> getListWithPage(int start, int length, StockInfo stockInfo) {
		PageHelper.startPage(start, length);
		Page<StockInfo> pageResult = (Page<StockInfo>) stockInfoMapper.select(stockInfo);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count",  pageResult.getTotal());
		result.put("list",pageResult.getResult());
		return result;
	}
	
	

}
