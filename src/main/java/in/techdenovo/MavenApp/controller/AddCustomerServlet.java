package in.techdenovo.MavenApp.controller;

import in.techdenovo.MavenApp.dto.CustomerDtoImpl;
import in.techdenovo.MavenApp.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addcustomer")
public class AddCustomerServlet extends HttpServlet {
    CustomerDtoImpl customerDtoImpl=new CustomerDtoImpl();
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        res.sendRedirect("add-customer.jsp");
    }

    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws  ServletException,IOException{
        Customer customer=new Customer();
        customer.setFname(req.getParameter("fName"));
        customer.setLname(req.getParameter("lName"));
        customer.setMob(req.getParameter("mob"));
        customer.setEmail(req.getParameter("email"));
         if(customerDtoImpl.insertCustomer(customer)==1){
             req.setAttribute("message","customer added");
         }
         else{
             req.setAttribute("message","customer is not added");

         }
    }


}
