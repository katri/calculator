package apps.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculationServiceTest {

    @Test
    void createNumberObject_correctInput() {
        int number1 = 2;
        int number2 = 3;
        CalculationService calculationService = new CalculationService();
        NumberObject expectedNumberObject = calculationService.createNumberObject(number1, number2);

        assertEquals(2, expectedNumberObject.getNumber1());
        assertEquals(3, expectedNumberObject.getNumber2());
        assertEquals(5, expectedNumberObject.getSum());
    }

    @Test
    void createNumberObject_tooHighInput() {
        int number1 = 2;
        int number2 = 202;
        CalculationService calculationService = new CalculationService();
        NumberObject expectedNumberObject = calculationService.createNumberObject(number1, number2);

        assertNull(expectedNumberObject);
    }

    @Test
    void createNumberObject_negativeInput() {
        int number1 = 2;
        int number2 = -4;
        CalculationService calculationService = new CalculationService();
        NumberObject expectedNumberObject = calculationService.createNumberObject(number1, number2);

        assertNull(expectedNumberObject);
    }
}