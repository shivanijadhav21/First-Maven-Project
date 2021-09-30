package in.techdenovo.MavenApp.controller;

import in.techdenovo.MavenApp.dto.CustomerDtoImpl;
import in.techdenovo.MavenApp.model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateCustomerServlet extends HttpServlet {
    CustomerDtoImpl customerDtoImpl=new CustomerDtoImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        Customer customer=new Customer();
        long id=Long.parseLong(req.getParameter("id"));
        customer=customerDtoImpl.getCustomer(id);
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("customer-update.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        Customer customer=new Customer();
        customer.setId(Long.parseLong(req.getParameter("id")));
        customer.setFname(req.getParameter("fName"));
        customer.setLname(req.getParameter("lName"));
        customer.setMob(req.getParameter("mob"));
        customer.setEmail(req.getParameter("email"));
        customerDtoImpl.updateCustomer(customer);
    }
}