package pl.kwi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.kwi.entities.UserEntity;
import pl.kwi.services.UserService;

@WebServlet("/edit.do")
public class EditServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public EditServlet(){
		userService = new UserService();
	}
	

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		try {
			
			String submit = request.getParameter("submit");
			
			if("Display".equals(submit)){
				displayPage(request, response);
				return;
			}else if("OK".equals(submit)){
				handleOkButton(request, response);
				return;
			}else if("Back".equals(submit)){
				handleBackButton(request, response);
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.do?submit=Display&errorMessage=" + e.getMessage());
			return;
		}		
		
	}
	
	private void displayPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		try {
			
			String id = request.getParameter("id");
			UserEntity entity = null;
			entity = userService.read(Long.valueOf(id));
			
			request.setAttribute("name", entity.getName());
			request.setAttribute("id", entity.getId());
			
		} catch (Exception e) {
			throw e;
		}		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/editJsp.jsp");
		requestDispatcher.forward(request, response);
		
	}
	
	private void handleOkButton(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		try {
			
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			
			UserEntity entity = new UserEntity(Long.valueOf(id), name);
			userService.update(entity);
			
		} catch (Exception e) {
			throw e;
		}
		
		response.sendRedirect("table.do?submit=Display");
		
	}
	
	private void handleBackButton(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.sendRedirect("table.do?submit=Display");
		
	}

}
