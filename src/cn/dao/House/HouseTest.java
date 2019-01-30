package cn.dao.House;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.pojo.House;
import cn.service.house.HouseService;
import cn.util.Pager;

public class HouseTest {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HouseService houseService = (HouseService) context.getBean("houseService");
		Pager pager = new Pager(1, 1,3);
		List<House> findHouse = houseService.findHouse(pager,null,-1,-1,-1);
		for (House house : findHouse) {
			System.out.println(house);
		}
	}

}
