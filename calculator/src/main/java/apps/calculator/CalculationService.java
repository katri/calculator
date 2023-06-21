package apps.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public NumberObject addNumbers(int number1, int number2) {

        if(number1 >= 0 && number1 <= 100 && number2 >= 0 && number2 <= 100) {
            return new NumberObject(number1, number2);
        }
        return null;
    }
}
