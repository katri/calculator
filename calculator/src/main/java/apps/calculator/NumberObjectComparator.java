package apps.calculator;

public class NumberObjectComparator implements java.util.Comparator<NumberObject> {
    private boolean isAscending;

    public NumberObjectComparator(boolean isAscending) {
        this.isAscending = isAscending;
    }

    @Override
    public int compare(NumberObject a, NumberObject b) {
        if (isAscending) {
            return a.getSum() - b.getSum();

        } else {
            return b.getSum() - a.getSum();
        }
    }
}
