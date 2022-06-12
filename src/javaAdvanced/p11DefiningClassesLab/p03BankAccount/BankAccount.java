package javaAdvanced.p11DefiningClassesLab.p03BankAccount;

public class BankAccount {
    static int accountCurrentId = 0;
  private   static double interestRate = 0.02;

  private   int id = 0;
   private double balance;

    public BankAccount() {
        accountCurrentId++;
        this.id = accountCurrentId;
        this.balance = 0.00;
    }

    public double getInterest(double years) {
        return years * BankAccount.interestRate * this.balance;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public void Deposit(Double amount){
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
