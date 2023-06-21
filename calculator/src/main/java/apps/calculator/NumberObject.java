package apps.calculator;

import lombok.Data;

import java.io.Serializable;

@Data
public class NumberObject implements Serializable {
    int number1;
    int number2;
    int sum;

    public NumberObject(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.sum = number1 + number2;
    }
}
