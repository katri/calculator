package apps.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void searchNumber_numberExistsAscending() {
        List<NumberObject> numberObjects = List.of(
                new NumberObject(1, 1),
                new NumberObject(2, 44),
                new NumberObject(7, 44),
                new NumberObject(3, 2));

        CalculationService calculationService = new CalculationService();
        List<NumberObject> expectedNumberObjects = calculationService.searchNumber(2, true, numberObjects);
        NumberObject element1 = expectedNumberObjects.get(0);
        NumberObject element2 = expectedNumberObjects.get(1);
        NumberObject element3 = expectedNumberObjects.get(2);

        assertEquals(3, expectedNumberObjects.size());

        assertEquals(1, element1.number1);
        assertEquals(1, element1.number2);
        assertEquals(2, element1.sum);

        assertEquals(3, element2.number1);
        assertEquals(2, element2.number2);
        assertEquals(5, element2.sum);

        assertEquals(2, element3.number1);
        assertEquals(44, element3.number2);
        assertEquals(46, element3.sum);
    }

    @Test
    void searchNumber_numberExistsDescending() {
        List<NumberObject> numberObjects = List.of(
                new NumberObject(1, 1),
                new NumberObject(2, 44),
                new NumberObject(7, 44),
                new NumberObject(3, 2));

        CalculationService calculationService = new CalculationService();
        List<NumberObject> expectedNumberObjects = calculationService.searchNumber(2, false, numberObjects);
        NumberObject element1 = expectedNumberObjects.get(0);
        NumberObject element2 = expectedNumberObjects.get(1);
        NumberObject element3 = expectedNumberObjects.get(2);

        assertEquals(3, expectedNumberObjects.size());

        assertEquals(2, element1.number1);
        assertEquals(44, element1.number2);
        assertEquals(46, element1.sum);

        assertEquals(3, element2.number1);
        assertEquals(2, element2.number2);
        assertEquals(5, element2.sum);

        assertEquals(1, element3.number1);
        assertEquals(1, element3.number2);
        assertEquals(2, element3.sum);
    }
}