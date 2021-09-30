package in.techdenovo.MavenApp.controller;

import in.techdenovo.MavenApp.dto.CustomerDtoImpl;
import in.techdenovo.MavenApp.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getcustomer")
public class GetCustomerServlet extends HttpServlet {
    CustomerDtoImpl customerDtoImpl=new CustomerDtoImpl();
    protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException {
       Long id=Long.parseLong(req.getParameter("id"));
        customerDtoImpl.getCustomer(id);
        RequestDispatcher requestDispatcher= req.getRequestDispatcher("/details.jsp");

    }

}
