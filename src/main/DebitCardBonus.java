/**
 * Класс бонусной дебетовой карты "Бонусные баллы в размере 1% от покупок"
 */

public class DebitCardBonus extends DebitCard {
    public DebitCardBonus(double balance) {

        super(balance);
    }

    private double balance;
    private double bonus;

    DebitCard debitCard = new DebitCard(balance);

    @Override
    public void topUp(double sum) {
        debitCard.topUp(sum);
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            bonus = sum * 1 / 100; // Расчёт бонус 1% от суммы оплаты
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
                "\nБонусных баллов: " + bonus;
    }
}
