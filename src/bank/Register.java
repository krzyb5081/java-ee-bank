package bank;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import dataBase.DataBase;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataBase db = new DataBase();
		Account account = new Account();
		HttpSession session = request.getSession();
		
		Enumeration<String> parameters = request.getParameterNames();
		while(parameters.hasMoreElements()) {
			if(request.getParameter(parameters.nextElement()) == null) {
				session.setAttribute("accountCreated", false);
				response.sendRedirect("register.jsp");
				return;
			}
		}
				
		account.setUserName(request.getParameter("userName"));
		account.setPassword(request.getParameter("password"));
		account.setName(request.getParameter("name"));
		account.setSurname(request.getParameter("surname"));
		account.setBirthDate(request.getParameter("birthDate"));
		account.setCurrentMoney(0);
		
		boolean accountCreated = db.registerNewAccount(account);
		
		if(accountCreated) {
			session.setAttribute("accountCreated", true);
		} else {
			session.setAttribute("accountCreated", false);
		}
		response.sendRedirect("register.jsp");
		return;
	}

}
