/**
 * Класс бонусной дебетовой карты "Потенциальный кэшбэк 5%"
 */
public class DebitCardCashBack extends DebitCard {
    public DebitCardCashBack(double balance) {

        super(balance);
    }

    private double balance;
    private double cashBack;

    @Override
    public void topUp(double sum) {
        balance = balance + sum;
        System.out.println("Баланс дебетовой карты пополнен на: " + sum);
        System.out.println(getAllBalance());
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) {
            if (sum > 5000) {
                cashBack = sum * 5 / 100; // Расчёт кешбэк 5% от суммы оплаты более 5000
            }
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
                "\nНакопленный кешбэк: " + cashBack;
    }
}