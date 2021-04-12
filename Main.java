package com.array;

import java.util.Scanner;

public class Main {
    private static Scanner input=new Scanner(System.in);
    private static Bank masr=new Bank("Masr");

    public static void displayMenu(){
        System.out.println("Welcome to  Bank" + masr.getName() +"Database");
        System.out.println("Enter the Number of the Option You Want to perform");
        System.out.println("1)Add new Branch");
        System.out.println("2)Add new Customer to an Existing Branch");
        System.out.println("3)Show Customers of a Specific Branch");
        System.out.println("4)Add Transactions for an Existing Customer");
        System.out.println("5)Display Menu");
        System.out.println("6)Remove Customer from an Existing Branch");
        System.out.println("7)EXIT");
    }
    public static void addBranch(){
        System.out.println("Enter the name of the branch");
        String name=input.next();
        masr.addBranch(name);

    }
    public static void addCustomer(){
        System.out.println("Enter the name of the branch you want to add the customer to");
        String branchName=input.next();
        System.out.println("Enter the name of the Customer");
        String customerName=input.next();
        System.out.println("Enter the initial Transactions for the customer");
        double initialTransactions=input.nextDouble();
        masr.newCustomer(branchName,customerName,initialTransactions);
    }
    public static void printCustomers(){
        System.out.println("Enter the name of the branch you want to print the Customers List");
        String branchName=input.next();
        masr.printCustomers(branchName);

    }
    public static void addTransactions(){
        System.out.println("Enter the name of the branch the customer is in");
        String branchName=input.next();
        System.out.println("Enter the name of the Customer");
        String customerName=input.next();
        System.out.println("Enter the additional Transactions for the customer");
        double additionalTransactions=input.nextDouble();
        masr.customerTransactions(branchName,customerName,additionalTransactions);
    }
    public static void removeCustomer(){
        System.out.println("Enter the name of the branch the customer is in");
        String branchName=input.next();
        System.out.println("Enter the name of the Customer");
        String customerName=input.next();
        masr.removeExistingCustomer(branchName,customerName);

    }

    public static void main(String[] args) {
        displayMenu();
        boolean quit=false;
        while (!quit){
            int option=input.nextInt()-1;
            switch (option){
                case 0:
                    addBranch();
                    break;
                case 1:
                    addCustomer();
                    break;
                case 2:
                    printCustomers();
                    break;
                case 3:
                    addTransactions();
                    break;
                case 4:
                    displayMenu();
                    break;
                case 5:
                    removeCustomer();
                    break;
                case 6:
                    quit=true;
                    System.out.println("Shut Down");
                    break;
            }
        }



    }
}
