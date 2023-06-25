package apps.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
        CalculationService calculationService = new CalculationService();
        calculationService.addNumberObjectToList(1, 1);
        calculationService.addNumberObjectToList(2, 44);
        calculationService.addNumberObjectToList(7, 44);
        calculationService.addNumberObjectToList(3, 2);

        List<NumberObject> actualNumberObjects = calculationService.searchNumber(2, true);
        NumberObject element1 = actualNumberObjects.get(0);
        NumberObject element2 = actualNumberObjects.get(1);
        NumberObject element3 = actualNumberObjects.get(2);

        assertThat(actualNumberObjects.size()).isEqualTo(3);

        assertThat(element1.number1).isEqualTo(1);
        assertThat(element1.number2).isEqualTo(1);
        assertThat(element1.sum).isEqualTo(2);

        assertThat(element2.number1).isEqualTo(3);
        assertThat(element2.number2).isEqualTo(2);
        assertThat(element2.sum).isEqualTo(5);

        assertThat(element3.number1).isEqualTo(2);
        assertThat(element3.number2).isEqualTo(44);
        assertThat(element3.sum).isEqualTo(46);
    }

    @Test
    void searchNumber_numberExistsDescending() {
        CalculationService calculationService = new CalculationService();
        calculationService.addNumberObjectToList(1, 1);
        calculationService.addNumberObjectToList(2, 44);
        calculationService.addNumberObjectToList(7, 44);
        calculationService.addNumberObjectToList(3, 2);

        List<NumberObject> actualNumberObjects = calculationService.searchNumber(2, false);
        NumberObject element1 = actualNumberObjects.get(0);
        NumberObject element2 = actualNumberObjects.get(1);
        NumberObject element3 = actualNumberObjects.get(2);

        assertThat(actualNumberObjects.size()).isEqualTo(3);

        assertThat(element1.number1).isEqualTo(2);
        assertThat(element1.number2).isEqualTo(44);
        assertThat(element1.sum).isEqualTo(46);

        assertThat(element2.number1).isEqualTo(3);
        assertThat(element2.number2).isEqualTo(2);
        assertThat(element2.sum).isEqualTo(5);

        assertThat(element3.number1).isEqualTo(1);
        assertThat(element3.number2).isEqualTo(1);
        assertThat(element3.sum).isEqualTo(2);
    }
}