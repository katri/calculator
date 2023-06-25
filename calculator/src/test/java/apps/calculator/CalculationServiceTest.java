package apps.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculationServiceTest {

    @Test
    void createNumberObject_correctInput() {
        int number1 = 2;
        int number2 = 3;
        CalculationService calculationService = new CalculationService();
        NumberObject expectedNumberObject = calculationService.createNumberObject(number1, number2);

        assertThat(expectedNumberObject.getNumber1()).isEqualTo(2);
        assertThat(expectedNumberObject.getNumber2()).isEqualTo(3);
        assertThat(expectedNumberObject.getSum()).isEqualTo(5);
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

        List<NumberObjectView> actualNumberObjects = calculationService.searchNumber(2, true);
        NumberObjectView element1 = actualNumberObjects.get(0);
        NumberObjectView element2 = actualNumberObjects.get(1);
        NumberObjectView element3 = actualNumberObjects.get(2);

        assertThat(actualNumberObjects.size()).isEqualTo(3);

        assertThat(element1.getNumber1()).isEqualTo(1);
        assertThat(element1.getNumber2()).isEqualTo(1);
        assertThat(element1.getSum()).isEqualTo(2);

        assertThat(element2.getNumber1()).isEqualTo(3);
        assertThat(element2.getNumber2()).isEqualTo(2);
        assertThat(element2.getSum()).isEqualTo(5);

        assertThat(element3.getNumber1()).isEqualTo(2);
        assertThat(element3.getNumber2()).isEqualTo(44);
        assertThat(element3.getSum()).isEqualTo(46);
    }

    @Test
    void searchNumber_numberExistsDescending() {
        CalculationService calculationService = new CalculationService();
        calculationService.addNumberObjectToList(1, 1);
        calculationService.addNumberObjectToList(2, 44);
        calculationService.addNumberObjectToList(7, 44);
        calculationService.addNumberObjectToList(3, 2);

        List<NumberObjectView> actualNumberObjects = calculationService.searchNumber(2, false);
        NumberObjectView element1 = actualNumberObjects.get(0);
        NumberObjectView element2 = actualNumberObjects.get(1);
        NumberObjectView element3 = actualNumberObjects.get(2);

        assertThat(actualNumberObjects.size()).isEqualTo(3);

        assertThat(element1.getNumber1()).isEqualTo(2);
        assertThat(element1.getNumber2()).isEqualTo(44);
        assertThat(element1.getSum()).isEqualTo(46);

        assertThat(element2.getNumber1()).isEqualTo(3);
        assertThat(element2.getNumber2()).isEqualTo(2);
        assertThat(element2.getSum()).isEqualTo(5);

        assertThat(element3.getNumber1()).isEqualTo(1);
        assertThat(element3.getNumber2()).isEqualTo(1);
        assertThat(element3.getSum()).isEqualTo(2);
    }
}