package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public BankAccount(String name, double balance, double minBalance) {
        if(balance<minBalance)throw new RuntimeException("Insufficient Balance");
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(digits*9<sum)throw new RuntimeException("Account Number can not be generated");
        StringBuilder ans = new StringBuilder();
        for(int i=1;i<=digits;i++){
            if(sum>=9){
                ans.append("9");
                sum-=9;
            }
            else{
                ans.append(sum);
                sum = 0;
            }
        }
//        System.out.println(ans);
        return ans.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance)
            throw new RuntimeException("Insufficient Balance");
        else
            balance-=amount;
    }

}