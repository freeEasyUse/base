package org.base.test.temp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Client {
	public static void main(String[] args) {
		//初始化数据
		Elem e1 = new Elem("1","2");
		Elem e2 = new Elem("2","3");
		Elem e3 = new Elem("3","4");
		Elem e4 = new Elem("5","6");
		Elem e5 = new Elem("4","5");
		Elem e6 = new Elem("7","8");
		Elem e7 = new Elem("6","7");
		List<Elem> list = new ArrayList<Elem>();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		
		//给数据中的元素设置id
		int i = 0;
		for(Elem e:list){
			e.setId(i);
			i++;
		}
		
		//循环元素 设置from 和 to
		for(Elem e:list){
			//查找当前元素的from值
			e.setFrom(getIndex(e.getA_value(),0,list));
			//查找当前元素的to值
			e.setEnd(getIndex(e.getZ_value(),1,list));
		}
		
		

		//查询首节点
		Elem first = new Elem();
		for(Elem e:list){
			if(e.getFrom()==-1){
				first = e;
			}
		}
		
		//根据from to 输入数据
		sysOut(list,first.getId());
	}
	
	/**
	 * 查询from 或者 to  对应的元素id
	 * @param value
	 * @param type
	 * @param list
	 * @return
	 */
	public static int getIndex(String value,int type,List<Elem> list){
		for(Elem e:list){
			//查询from
			if(type==0){
				if(StringUtils.equals(e.getZ_value(), value)){
					return e.getId();
				}
			}
			else{
				if(StringUtils.equals(e.getA_value(),value)){
					return e.getId();
				}
			}
		}
		//没有开始结点 设置-1
		if(type==0){
			return -1;
		}
		//没有结束节点 设置-2
		return -2;
	}
	
	
	/**
	 * 根据id查询elem元素
	 * @param id
	 * @param list
	 * @return
	 */
	public static Elem getElemById(int id,List<Elem> list){
		for(Elem e:list){
			if(e.getId()==id){
				return e;
			}
		}
		return null;
	}
	
	
	public static void sysOut(List<Elem> list,int id){
		Elem e = getElemById(id,list);
		System.out.println(e.toString());
		if(e.getEnd()!=-2){
			sysOut(list,e.getEnd());
		}
		else{
			return;
		}
	}
	
}
