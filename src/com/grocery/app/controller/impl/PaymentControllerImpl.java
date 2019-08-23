/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grocery.app.controller.impl;

import com.grocery.app.controller.PaymentController;
import com.grocery.app.dbAccess.PaymentDBAccess;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import com.grocery.app.model.Payment;
import java.util.ArrayList;

/**
 *
 * @author HaShaN
 */
public class PaymentControllerImpl implements PaymentController{
    private final PaymentDBAccess paymentDBAccess=new PaymentDBAccess();
    public PaymentControllerImpl(){}
    
    @Override
    public boolean addPayment(Payment payment) throws ClassNotFoundException, SQLException {
        return paymentDBAccess.addPayment(payment);
    }

    @Override
    public Payment searchPayment(String payId) throws ClassNotFoundException, SQLException {
        return paymentDBAccess.searchPayment(payId);
    }

    @Override
    public boolean deletePayment(String payId) throws ClassNotFoundException, SQLException {
        return paymentDBAccess.deletePayment(payId);
    }

    @Override
    public boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException {
        return paymentDBAccess.updatePayment(payment);
    }

    @Override
    public ArrayList<Payment> getAllPayments() throws ClassNotFoundException, SQLException {
        return paymentDBAccess.getAllPayments();
    }
    
}
