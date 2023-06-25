package apps.calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberObjectMapperTest {
    @Test
    void toNumberObjectViews_mapNumberObject() {
        NumberObjectMapper numberObjectMapper = new NumberObjectMapper();
        List<NumberObject> numberObjects = List.of(new NumberObject(2, 4), new NumberObject(11, 7));

        List<NumberObjectView> expectedList = numberObjectMapper.toNumberObjectViews(numberObjects);
        NumberObjectView element1 = expectedList.get(0);
        NumberObjectView element2 = expectedList.get(1);

        assertThat(expectedList.size()).isEqualTo(2);

        assertThat(element1.getNumber1()).isEqualTo(2);
        assertThat(element1.getNumber2()).isEqualTo(4);
        assertThat(element1.getSum()).isEqualTo(6);

        assertThat(element2.getNumber1()).isEqualTo(11);
        assertThat(element2.getNumber2()).isEqualTo(7);
        assertThat(element2.getSum()).isEqualTo(18);
    }
}