package apps.calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberObjectMapper {

    public List<NumberObjectView> toNumberObjectViews(List<NumberObject> numberObjects) {
        List<NumberObjectView> numberObjectViews = new ArrayList<>();
        for (NumberObject numberObject : numberObjects) {
            NumberObjectView numberObjectView = new NumberObjectView(
                    numberObject.getNumber1(),
                    numberObject.getNumber2(),
                    numberObject.getSum());
            numberObjectViews.add(numberObjectView);
        }
        return numberObjectViews;
    }
}