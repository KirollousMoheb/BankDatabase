package com.array;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branches> branches =new ArrayList<Branches>();

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }
    public void addBranch(String name){
        if (findBranch(name) == null) {
            branches.add(new Branches(name));
            System.out.println("Branch "+name+" was added successfully");

        }
        else{
            System.out.println("Cannot add! Branch Already Exists");
        }
    }

    public String getName() {
        return name;
    }

    public void newCustomer(String branchName, String customerName, double initialTransactions){
        if (findBranch(branchName) != null) {
            findBranch(branchName).addNewCustomer(customerName,initialTransactions);
            System.out.println("Customer "+customerName+" was added Successfully to "+branchName+" Branch with Initial Transictions  "+initialTransactions+"$");
        }
        else {
            System.out.println("Branch Doesn't exist");
        }
    }
    public void printCustomers(String branch){
        if (findBranch(branch) != null) {

            int numberOfCustomers=findBranch(branch).getCustomers().size();

            for (int i = 0; i <numberOfCustomers; i++) {
                int counter=i+1;

                System.out.println("Customer "+counter+" name is===>"+findBranch(branch).getCustomers().get(i).getCustomerName()+"with Transictions ");
                int numberOfTransactions=findBranch(branch).getCustomers().get(i).getTransactions().size();
                ArrayList <Double> customerTransactions=findBranch(branch).getCustomers().get(i).getTransactions();

                for (int j = 0; j < numberOfTransactions; j++) {
                    System.out.println(customerTransactions.get(j).doubleValue());
                }
            }
        }
        else {
            System.out.println("Branch doesn't exist");
        }
    }
    public void customerTransactions(String branchName,String customerName,double additionalTransactions){
        if (findBranch(branchName) != null) {
            findBranch(branchName).additionalTransactions(customerName,additionalTransactions);
        }
        else{
            System.out.println("Branch"+branchName+"Doesn't exist");
        }
    }
    public void removeExistingCustomer(String branchName,String customerName){
        if ( findBranch(branchName)!= null) {
            findBranch(branchName).remove(findBranch(branchName).getCustomers().get(findBranch(branchName).searchCustomer(customerName)));
            System.out.println("Customer "+customerName +" was removed from branch "+branchName);
        }
        else {
            System.out.println("Branch Doesn't exist");
        }
    }

    public Branches findBranch(String name){
        for (int i = 0; i < branches.size(); i++) {
            Branches branch =branches.get(i);
            if (branch.getBranchName().equals(name)){
                return branch;
            }
        }
        return null;
    }


}
