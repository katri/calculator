package apps.calculator;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {
    private final List<NumberObject> numberObjects = new ArrayList<>();
    NumberObjectMapper numberObjectMapper = new NumberObjectMapper();

    public List<NumberObjectView> addNumberObjectToList(int number1, int number2) {
        NumberObject numberObject = createNumberObject(number1, number2);
        if (numberObject != null) {
            numberObjects.add(numberObject);
        }
        return numberObjectMapper.toNumberObjectViews(numberObjects);
    }

    public NumberObject createNumberObject(int number1, int number2) {
        if (number1 >= 0 && number1 <= 100 && number2 >= 0 && number2 <= 100) {
            return new NumberObject(number1, number2);
        }
        return null;
    }

    public List<NumberObject> searchNumber(int number, boolean isAscending) {
        List<NumberObject> newNumberObjects = new ArrayList<>();
        for (NumberObject numberObject : numberObjects) {
            if (number == numberObject.getNumber1() || number == numberObject.getNumber2() || number == numberObject.getSum()) {
                newNumberObjects.add(numberObject);
            }
        }
        newNumberObjects.sort(new NumberObjectComparator(isAscending));
        return newNumberObjects;
    }

    public List<NumberObject> getNumberObjects() {
        return numberObjects;
    }
}
