package testsas;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletebook extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void destroy() {
		super.destroy(); 
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "delete.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String title=request.getParameter("title");
		if(database.deleteInfo(title)){
			request.setAttribute("message","����Ϊ"+title+"ͼ����Ϣɾ���ɹ���");	
		}
		else{
			request.setAttribute("message", "ɾ��ͼ����Ϣ����");
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}
	
	public void init() throws ServletException {
	}
}
