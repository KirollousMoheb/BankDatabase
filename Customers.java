package com.array;

import java.util.ArrayList;

public class Customers {
    private String customerName;
    private ArrayList<Double> transactions=new ArrayList<>();

    public Customers(String customerName,double initialTransaction) {
        this.customerName = customerName;
        this.transactions =  new ArrayList<>() ;
        addTransaction(initialTransaction);
    }

    public String getCustomerName() {
        return customerName;
    }
    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    public void addTransaction(double money){
        transactions.add(money);
    }


}