package apps.calculator;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculationController {

    @Resource
    private CalculationService calculationService;

    final private static List<NumberObject> numberObjects = new ArrayList<>();

    @GetMapping("/new")
    public NumberObject addNumbers(@RequestParam int number1, @RequestParam int number2) {
        return calculationService.createNumberObject(number1, number2);
    }

    @GetMapping("/add")
    public List<NumberObject> addNumberObjectToList(@RequestParam int number1, @RequestParam int number2) {
        NumberObject numberObject = calculationService.createNumberObject(number1, number2);
        if (numberObject != null) {
            numberObjects.add(numberObject);
        }
        return numberObjects;
    }

    @GetMapping("/search")
    public List<NumberObject> searchNumber(@RequestParam int number, @RequestParam boolean isAscending) {
        return calculationService.searchNumber(number, isAscending, numberObjects);
    }


}
