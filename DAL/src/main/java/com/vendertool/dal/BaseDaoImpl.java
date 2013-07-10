package com.vendertool.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class BaseDaoImpl  extends HibernateDaoSupport {
	static ApplicationContext appContext;
	static{
		appContext = new ClassPathXmlApplicationContext(
				"BeanLocations.xml");
	}
	public static ApplicationContext getAppContext(){
		return appContext;
	}
}
