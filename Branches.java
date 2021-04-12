package com.array;

import java.util.ArrayList;

public class Branches {
    private String branchName;
    private ArrayList<Customers> customers = new ArrayList<Customers>();

    public Branches(String branchName) {
        this.branchName=branchName;
        this.customers = new ArrayList<Customers>();
    }

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customers> getCustomers() {
        return customers;
    }

    public void addNewCustomer(String name, double initialTransaction){
        if (findCustomer(name) == null) {
            customers.add(new Customers(name,initialTransaction));

        }
        else{
            System.out.println("Customer already exists");
        }

    }

    public Customers findCustomer(String name){
        for (int i = 0; i < customers.size(); i++) {
            Customers customer=customers.get(i);
            if (customer.getCustomerName().equals(name)){
                return customer;
            }
        }
        return null;
    }
    public int searchCustomer(String customerName){

        for (int i = 0; i < customers.size(); i++) {
            Customers removedCustomer=this.customers.get(i);
            if (removedCustomer.getCustomerName().equals(customerName)){
                return i;
            }
        }

        return -1;
    }
    public void remove(Customers removed){
        int indexToBeRemoved=searchCustomer(removed.getCustomerName());
        if ( indexToBeRemoved >=0 ) {
            customers.remove(indexToBeRemoved);
            System.out.println("Contact"+removed.getCustomerName()+" is removed");
        }
    }
    public void additionalTransactions(String name,double money){
        if (findCustomer(name)!=null) {
            findCustomer(name).addTransaction(money);
        }else{
            System.out.println("Customer Doesn't exist");
        }
    }
}
