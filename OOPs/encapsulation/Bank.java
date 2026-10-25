package encapsulation;

public class Bank {
    private int balance;

    void deposite(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("enter a valid amount!");
        }
    }
    //getter method
    void getBalance() {
        System.out.println("Available balance is : " + balance);
    }
}
