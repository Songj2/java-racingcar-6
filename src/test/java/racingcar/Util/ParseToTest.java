package racingcar.Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseToTest {
    private final ParseTo parseTo = new ParseTo();

    @Test
    void parseToInteger() {
        assertEquals(1, parseTo.parseToInteger("1"));
    }

    @Test
    void parseToHyphen() {
        assertEquals("---", parseTo.parseToHyphen(3));
    }
}
