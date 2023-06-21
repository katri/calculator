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

    private static List<NumberObject> numberObjects = new ArrayList<>();

    @GetMapping("/new")
    public NumberObject addNumbers(@RequestParam int number1, @RequestParam int number2) {
        return calculationService.addNumbers(number1, number2);
    }
}
