package in.techdenovo.MavenApp.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import in.techdenovo.MavenApp.utility.DbUtility;
import in.techdenovo.MavenApp.model.Customer;
import org.mariadb.jdbc.MariaDbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class CustomerDtoImpl implements CustomerIDto {
        DbUtility utility=new DbUtility();

        @Override
        public List<Customer> getCustomers() {
            List<Customer> customers=new ArrayList<>();
            try{
                Connection conn=utility.getConnection();
                if(conn!=null){
                    PreparedStatement stmt=conn.prepareStatement("select * from customer");
                    ResultSet resultset=stmt.executeQuery();
                    while(resultset.next()){
                        Customer customer=new Customer();
                        customer.setId(resultset.getLong("id"));
                        customer.setFname(resultset.getString("fName"));
                        customer.setLname(resultset.getString("lName"));
                        customer.setMob(resultset.getString("mob"));
                        customer.setEmail(resultset.getString("email"));
                        customers.add(customer);

                    }
                }

                conn.close();
            }

            catch (SQLException throwables){
                throwables.printStackTrace();
            }
            return customers;
        }

        @Override
        public Customer getCustomer(long id) {
            Customer customer=new Customer();
            Connection conn=utility.getConnection();
            try{
                PreparedStatement stmt=conn.prepareStatement("select * from customer where id=?");
                stmt.setLong(1,id);
                ResultSet resultSet=stmt.executeQuery();
                if(resultSet.next()){
                    customer.setId(resultSet.getLong("id"));
                    customer.setFname(resultSet.getString("fName"));
                    customer.setLname(resultSet.getString("lName"));
                    customer.setMob(resultSet.getString("mob"));
                    customer.setEmail(resultSet.getString("email"));
                }
                else{
                    System.out.println("no data found");
                }
                conn.close();
            }
            catch (SQLException throwables){
                throwables.printStackTrace();
            }
            return customer;
        }

        @Override
        public int insertCustomer(Customer customer) {

            int flag=0;
            if (customer!=null){

                String sql="INSERT INTO customer(fName,lName,mob,email) VALUES(?,?,?,?)";
                try{
                    Connection conn=utility.getConnection();
                    if (conn!=null){
                        PreparedStatement stmt=conn.prepareStatement(sql);
                        stmt.setString(1,customer.getFname());
                        stmt.setString(2,customer.getLname());
                        stmt.setString(3,customer.getMob());
                        stmt.setString(4,customer.getEmail());
                        int i=stmt.executeUpdate();
                        if(i==1){
                            flag=1;
                        }
                    }
                    conn.close();

                }

                catch (Exception e){
                    System.out.println(e);
                }
            }
            return flag;
        }



        @Override
        public Customer updateCustomer(Customer existingCustomer) {
            String sql="update customer set fName=?,lName=?,mob=?,email=? where id=?";
            Connection conn=utility.getConnection();
            Customer updatedCustomer =new Customer();
            try{
                if(conn!=null){
                    PreparedStatement prst= conn.prepareStatement(sql);
                    prst.setString(1,existingCustomer.getFname());
                    prst.setString(2,existingCustomer.getLname());
                    prst.setString(3,existingCustomer.getMob());
                    prst.setString(4,existingCustomer.getEmail());
                    prst.setLong(5,existingCustomer.getId());







                    int i=prst.executeUpdate();
                    if(i==1){
                        updatedCustomer.setFname(existingCustomer.getFname());
                        updatedCustomer.setLname(existingCustomer.getLname());
                        updatedCustomer.setMob(existingCustomer.getMob());
                        updatedCustomer.setEmail(existingCustomer.getEmail());
                        System.out.println("Customer data updated to database");
                    }
                    else{
                        System.out.println("customer data updation failed");
                    }
                }
                conn.close();

            }

            catch (SQLException e){
                e.printStackTrace();
            }

            return updatedCustomer;

        }

        @Override
        public void deleteCustomer(long id) {
            try{
                Connection conn=utility.getConnection();
                String sql="delete from customer where id=?";
                PreparedStatement pr=conn.prepareStatement(sql);
                pr.setLong(1,id);
                int i=pr.executeUpdate();
                if(i==1){
                    System.out.println("the customer deleted");
                }
                else{
                    System.out.println("customer not found");
                }
                conn.close();

            }
            catch (SQLException e){
                System.out.println(e);
            }


        }


}
