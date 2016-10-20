package testsas;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import information.book;

public class showbook extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "error.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		book book = new book();
		String title = request.getParameter("title");
		if(title!=null){
			book=database.QueryInfo(title);
			if(book.getTitle()!=null){
				url="showbook.jsp";
				request.setAttribute("isbn", book.getISBN());
				request.setAttribute("title", book.getTitle());
				request.setAttribute("authorid", book.getAuthorID());
				request.setAttribute("publisher", book.getPublisher());
				request.setAttribute("publishdate", book.getPublishDate());
				request.setAttribute("price", book.getPrice());
			}
			else{
			    request.setAttribute("message", "查询错误，输入正确的书号！");
			}
		}
		
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}
	public void init() throws ServletException {
	}

}
