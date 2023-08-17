public class CreditCard extends BankCard {
    public CreditCard(double balance) {
        super(balance);
    }

    private final double creditLimit = 10_000; // Кредитный лимит устанавливается банком
    private double creditBalance = creditLimit; // Кредитные средства
    private double balance; // Собственные средства

    @Override
    public void topUp(double sum) { // 5000 // 1
        if (creditBalance < creditLimit) { // 6000 < 10000 // 6999 < 10000
            double difference = creditLimit - creditBalance; // 10000-6000 = 4000 // 10000 - 6999 = 3001
            if (sum <= difference) {  // // 1 < 3001
                creditBalance = creditBalance + sum; // 6000 + 4000 = 10000 // 6999 + 1 = 7000
            }
            if (sum > difference) { // 5000 > 3001
                creditBalance = creditBalance + difference; // 6999 + 3001
                balance = balance + sum - difference; // 20000 + 5 - 4000 // 0 + 1 - 3001 = минус -3000
            }
            System.out.println("Баланс кредитной карты пополнен на: " + sum);
            System.out.println("П Е Р В Ы Й  else if \n" + getAllBalance());
        } else if (creditBalance >= creditLimit) { // 12 000 >= 10000
            balance = balance + sum;
            System.out.println("Баланс кредитной карты пополнен на: " + sum);
            System.out.println("ВТОРОЙ else if \n" + getAllBalance());
        }
    }

    @Override
    public boolean pay(double sum) {
        if (balance >= sum) { // 5000 >= 2000  // 5000 == 5000
            balance = balance - sum; // 5000 - 2000 = 3000 // 5000-5000=0
            System.out.println("Оплата на сумму " + sum + " рублей прошла успешно.");
            System.out.println(getAllBalance());
            return true;
        } else if (balance < sum && sum <= (balance + creditBalance)) { // 5000 < 7000 && 7000 <= 5000 + 10000
            double difference = sum - balance; // 7000 - 5000 = 2000
            balance = balance + difference - sum; // 5000 + 2000 - 7000 = 0
            creditBalance = creditBalance - difference; // 10000 - 2000 = 8000
            System.out.println("Оплата на сумму " + sum + " рублей прошла успешно.");
            System.out.println(getAllBalance());
            return true;
        } else if (balance + creditBalance < sum) { // 5000 + 10000 < 20 000
            System.out.println("ВНИМАНИЕ! Недостаточно средств");
            System.out.println(getAllBalance());
            System.out.println("Пополните баланс карты и повторите операцию");
            return false;
        } else {
            System.out.println("ВНИМАНИЕ! Недостаточно средств");
            System.out.println(getAllBalance());
            System.out.println("Пополните баланс карты и повторите операцию");
            return false;
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public double getCreditBalance() {
        return creditBalance;

    }

    @Override
    public String getAllBalance() {
        return "Основные средства кредитной карты:\n" +
                "Кредитные средства: " + creditBalance + "\nСобственные средства: " + balance;
    }
}