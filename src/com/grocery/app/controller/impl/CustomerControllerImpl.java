/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.grocery.app.controller.impl;

import com.grocery.app.controller.CustomerController;
import com.grocery.app.dbAccess.CustomerDBAccess;
import java.sql.SQLException;
import java.util.ArrayList;
import com.grocery.app.model.Customer;

/**
 *
 * @author HaShaN
 */
public class CustomerControllerImpl implements CustomerController {
    
    private final CustomerDBAccess custDBAccess = new CustomerDBAccess();
    
    public CustomerControllerImpl(){
    }
    
    @Override
    public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        return custDBAccess.addCustomer(customer);
    }
    
    @Override
    public boolean deleteCustomer(String id) throws ClassNotFoundException, SQLException {
        return custDBAccess.deleteCustomer(id);
    }
    
    @Override
    public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        return custDBAccess.updateCustomer(customer);
    }
    
    @Override
    public Customer searchCustomer(String id) throws ClassNotFoundException, SQLException {
        return custDBAccess.searchCustomer(id);
    }
    
    @Override
    public ArrayList<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
        return custDBAccess.getAllCustomers();
    }
}
