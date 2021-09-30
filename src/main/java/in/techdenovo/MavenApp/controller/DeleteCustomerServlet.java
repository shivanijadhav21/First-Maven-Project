package in.techdenovo.MavenApp.controller;

import in.techdenovo.MavenApp.dto.CustomerDtoImpl;
import in.techdenovo.MavenApp.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deletecustomer")
public class DeleteCustomerServlet extends HttpServlet {
    CustomerDtoImpl impl=new CustomerDtoImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        long id=Long.parseLong(req.getParameter("id"));
        impl.deleteCustomer(id);
        res.sendRedirect("list.jsp");

    }
}
