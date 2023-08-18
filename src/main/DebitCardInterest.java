/**
 * Класс дебетовой карты "Накопление в размере 0.005% от суммы пополнений"
 */

public class DebitCardInterest extends DebitCard {
    public DebitCardInterest(double balance) {

        super(balance);
    }

    private double balance;
    private double interest;

    @Override
    public void topUp(double sum) {
        interest = sum * 0.005 / 100; // Расчёт накопления 0.005% от суммы пополнения
        balance = balance + sum;
        System.out.println("Баланс дебетовой карты пополнен на: " + sum);
        System.out.println(getAllBalance());
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

        return "Баланс на дебетовой карте: " + balance +
                "\nНакопление: " + interest;
    }
}
