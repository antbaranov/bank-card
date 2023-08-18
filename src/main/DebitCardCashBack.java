/**
 * Класс бонусной дебетовой карты "Потенциальный кэшбэк 5%"
 * Потенциальный кешбэк 5% начисляется при условии покупки больше 5 000 (Пять тысяч) у.е.
 */

public class DebitCardCashBack extends DebitCard {
    public DebitCardCashBack(double balance) {

        super(balance);
    }

    private double balance;
    private double cashBack;

    DebitCard debitCard = new DebitCard(balance);

    @Override
    public void topUp(double sum) {
        debitCard.topUp(sum);
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            if (sum > 5000) {
                cashBack = sum * 5 / 100; // Расчёт кешбэк 5% от суммы оплаты более 5000
            }
            balance = balance - sum;
            System.out.printf("Оплата на сумму %s рублей прошла успешно.%n", sum);
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
                "\nНакопленный кешбэк: " + cashBack;
    }
}