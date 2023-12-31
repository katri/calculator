package apps.calculator;

public class NumberObject {
    final int number1;
    final int number2;
    final int sum;

    public NumberObject(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.sum = number1 + number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getSum() {
        return sum;
    }
}
