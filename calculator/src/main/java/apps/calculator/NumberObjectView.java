package apps.calculator;

import java.io.Serializable;

public class NumberObjectView implements Serializable {
    int number1;
    int number2;
    int sum;

    public NumberObjectView(int number1, int number2, int sum) {
        this.number1 = number1;
        this.number2 = number2;
        this.sum = sum;
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