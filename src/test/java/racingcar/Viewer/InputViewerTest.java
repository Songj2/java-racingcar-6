package racingcar.Viewer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewerTest {
    InputViewer inputViewer = new InputViewer();

    @Test
    void inputCarNameTest() {
        System.setIn(new ByteArrayInputStream("aa,bb".getBytes()));
        String[] list = inputViewer.inputCarName();
        assertThat(list).containsOnly("aa", "bb");
    }

    @Test
    void inputCarNameExceptionTest() {
        System.setIn(new ByteArrayInputStream("abxdefg".getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputViewer.inputCarName();
        });
    }

    @Test
    void inputCountTest() {
        System.setIn(new ByteArrayInputStream("5".getBytes()));
        assertEquals(5, inputViewer.inputCount());
    }

    @Test
    void inputCountExceptionTest() {
        System.setIn(new ByteArrayInputStream("a1".getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            inputViewer.inputCount();
        });
    }
}
