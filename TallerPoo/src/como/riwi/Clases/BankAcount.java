package como.riwi.Clases;

public class BankAcount {
    private int accountNumber = 14285172;
  private  String accountHolder;
  private double balance;

  // Constructor

    public BankAcount(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    // to deposit
    public void toDeposit(double money){
        this.balance += money;
        System.out.println("Desposito exitoso");
    }
    public void towithDraw(double money){
        if(this.balance > money){
            this.balance -= money;
            System.out.println("retiro exitoso");
        }else {
            System.out.println("saldos insuficientes");
        }
    }

    @Override
    public String toString() {
        return "BankAcount {" +
                "accountNumber=" + accountNumber +
                ", accountHolder='" + accountHolder + '\'' +
                ", balance=" + balance +
                '}';
    }


}
