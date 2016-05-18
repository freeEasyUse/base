package org.base.service.logic;

import java.util.Map;

import org.base.dao.entity.StockInfo;

public interface StockInfoService {

	Map<String, Object> getListWithPage(int start,int length,StockInfo stockInfo);
}
