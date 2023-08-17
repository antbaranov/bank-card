public class DebitCard extends BankCard {
    public DebitCard(double balance) {

        super(balance);
    }

    private double balance;

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
        System.out.println("Баланс дебетовой карты пополнен на: " + sum);
        System.out.println("Остаток на дебетовой карте: " + balance);
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            balance = balance - sum;
            System.out.println("Оплата на сумму " + sum + " рублей прошла успешно.");
            System.out.println(getAllBalance());
            return true;
        } else {
            System.out.println("Недостаточно средств");
            System.out.println(getAllBalance());
            System.out.println("Пополните баланс карты и повторите операцию");
            return false;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getAllBalance() {
        return "Баланс на дебетовой карты: " + balance;
    }
}
