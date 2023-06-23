package apps.calculator;

public class NumberObjectComparator implements java.util.Comparator<NumberObject> {

    @Override
    public int compare(NumberObject a, NumberObject b) {
        return a.getSum() - b.getSum();
    }
}
