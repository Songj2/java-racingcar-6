package racingcar.Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatedTest {
    private final Validated validated= new Validated();
    private final String[] listT = "aa,bb".split(",");
    private final String[] listF = "aaaaaaaaaa,aa,aa".split(",");

    @Test
    void validateTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validated.validate(true);
        });
    }
    @Test
    void checkNameSizeTest(){
        assertTrue(validated.checkNameSize(listT));
    }
    @Test
    void checkNameSizeFalseTest(){
        assertFalse(validated.checkNameSize(listF));
    }
    @Test
    void duplicatedNameTest(){
        assertFalse(validated.duplicatedName(listF));
    }
    @Test
    void duplicatedNameTrueTest(){
        assertTrue(validated.duplicatedName(listT));
    }
    @Test
    void validatedNameExceptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validated.validatedName(listF);
        });
    }
    @Test
    void  checkIntegerTest(){
        assertTrue(validated.checkInteger("1"));
    }
    @Test
    void checkIntegerFalseTest(){
        assertFalse(validated.checkInteger("a"));
    }
    @Test
    void validateNumberExceptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            validated.validatedNumber("1q");
        });
    }
}
