/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Luzza
 */
public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            // st.executeUpdate("Create table appuser(appuser_pk int AUTO_INCREMENT primary key,userRole varchar(50),name varchar(200),mobileNumber varchar(50),email varchar(200),password varchar(50),address varchar(200),status varchar(50))");
            //st.executeUpdate("insert into appuser(userRole,name,mobileNumber,email,password,address,status) values('SuperAdmin','Super Admin','9841172907','superadmin@testemail.com','admin','Nepal','Active')");
            // st.executeUpdate("Create table category(category_pk int AUTO_INCREMENT primary key,name varchar(200))");
            //  st.executeUpdate("Create table product(product_pk int AUTO_INCREMENT primary key,name varchar(200),quantity int,price int,description varchar(500),category_fk int)");
            // st.executeUpdate("Create table customer(customer_pk int AUTO_INCREMENT primary key,name varchar(200),mobileNumber varchar(50),email varchar(200))");
            st.executeUpdate("Create table orderDetail(order_pk int AUTO_INCREMENT primary key,orderId varchar(200),customer_fk int,orderDate varchar(200),totalPaid int)");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }

}
