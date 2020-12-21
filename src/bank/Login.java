package bank;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dataBase.DataBase;
import model.Account;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase database = new DataBase();
		Account account = new Account();
		HttpSession session = request.getSession();
		
		if(((String)request.getParameter("userName")==null)||((String)request.getParameter("password")==null)){
			session.setAttribute("userLogin", false);
			session.setAttribute("userName", "");
			database.closeConnection();
			response.sendRedirect("login.jsp");
			return;
		}
		
		account.setUserName((String)request.getParameter("userName"));
		account.setPassword((String)request.getParameter("password"));
		
		if(database.passwordIsCorrect(account)){
			session.setAttribute("userLogin", true);
			session.setAttribute("userName", account.getUserName());
		} else {
			session.setAttribute("userLogin", false);
			session.setAttribute("userName", "");
		}
		database.closeConnection();
		response.sendRedirect("login.jsp");
		return;
	}

}
