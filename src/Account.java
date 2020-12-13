import edu.kit.informatik.*;

public class Account {
    int accountNumber;
    int bankCode;
    int balance;

    public Account(int theBankCode, int theBankNumber){
        this.bankCode = theBankCode;
        this.accountNumber = theBankNumber;
        this.balance = 0;
    }

    //public boolean withdraw(int amount) {}
    //public void deposit(int amount) {}
    //public boolean transfer(Account  account ,int amount)
}
