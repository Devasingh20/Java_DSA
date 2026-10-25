package encapsulation;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.deposite(10000);
        bank.getBalance();
    //    bank.balance = 500;  //error

        BankAccount account = new BankAccount("ACC101", new BigDecimal("10000.00"));

        account.deposit(new BigDecimal("2000.00"));
        account.withdraw(new BigDecimal("1500.00"));

        System.out.println(account.getBalance());
    }
}
