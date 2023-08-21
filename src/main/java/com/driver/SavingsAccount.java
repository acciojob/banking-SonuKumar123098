package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(this.getBalance()<amount) throw new Exception("Insufficient Balance");
        if(amount>maxWithdrawalLimit)throw new Exception("Maximum Withdraw Limit Exceed");
        this.setBalance(this.getBalance()-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest= (this.getBalance()*rate*years)/100.0;
        return this.getBalance()+interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double finalamount=0.0;// this.getBalance()*((100.0+rate)/100.0)^(times*years);
        finalamount=Math.pow(((100.0+rate)/100.0),(times*years))*this.getBalance();
        return finalamount;
    }

}
