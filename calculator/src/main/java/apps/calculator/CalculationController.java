package apps.calculator;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculationController {

    @Resource
    private CalculationService calculationService;

    @GetMapping("/new")
    public List<NumberObjectView> addNumberObjectToList(@RequestParam int number1, @RequestParam int number2) {
        return calculationService.addNumberObjectToList(number1, number2);
    }

    @GetMapping("/search")
    public List<NumberObjectView> searchNumber(@RequestParam(required = false) Integer number, @RequestParam boolean isAscending) {
        return calculationService.searchNumber(number, isAscending);
    }
}
