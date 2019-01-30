package cn.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext("app*.xml");
	}

	public static ApplicationContext getCtx() {
		return ctx;
	}

}
