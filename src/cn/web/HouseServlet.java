package cn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import cn.pojo.House;
import cn.service.house.HouseService;
import cn.service.type.TypeService;
import cn.util.ApplicationContextUtil;
import cn.util.Pager;

public class HouseServlet extends HttpServlet {

	private ApplicationContext ctx = ApplicationContextUtil.getCtx();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out  = response.getWriter();
		HouseService houseService = ctx.getBean(HouseService.class);
		TypeService typeService = ctx.getBean(TypeService.class);
		String opr = request.getParameter("opr");
		
		if (opr.equals("select")) {
			int currentPage = request.getParameter("currentPage")==null?1:Integer.parseInt(request.getParameter("currentPage"));
			String title = request.getParameter("title");
			int type_id = request.getParameter("type_id")==null?-1:Integer.parseInt(request.getParameter("type_id"));
			int priceMax = request.getParameter("priceMax")==null||request.getParameter("priceMax")==""?-1:Integer.parseInt(request.getParameter("priceMax"));
			int priceMin = request.getParameter("priceMin")==null||request.getParameter("priceMin")==""?-1:Integer.parseInt(request.getParameter("priceMin"));
			int totalCount = houseService.getTotalCount(title, type_id, priceMax, priceMin);
			
			Pager pager = new Pager(1, currentPage,totalCount);
			List<House> houseList = houseService.findHouse(pager,title,type_id,priceMax,priceMin);
			
			
			request.setAttribute("type_id", type_id);
			request.setAttribute("priceMax", priceMax==-1?null:priceMax);
			request.setAttribute("priceMin", priceMin==-1?null:priceMin);
			request.setAttribute("title", title);
			
			request.setAttribute("houseList", houseList);
			request.setAttribute("pager", pager);
			request.getSession().setAttribute("types", typeService.getAllType());
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
			
		}else if (opr.equals("insert")) {
			String title = request.getParameter("title");
			String type_id = request.getParameter("type_id");
			String price = request.getParameter("price");
			String fdate = request.getParameter("fdate");
			String contact = request.getParameter("contact");
			String description = request.getParameter("description");
			
			House house = new House();
			house.setContact(contact);
			house.setTitle(title);
			house.setFdate(fdate);
			house.setPrice(Integer.parseInt(price));
			house.setType_id(Integer.parseInt(type_id));
			house.setDescriptio(description);
			
			int result = houseService.insertHouse(house);
			if (result>0) {
				out.print("<script>alert('新增成功');location.href='index.jsp'</script>");
			}else{
				out.print("<script>alert('新增失败');location.href='add.jsp'</script>");
			}
		}

	}

}
