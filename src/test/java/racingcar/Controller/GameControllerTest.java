package racingcar.Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
    private final GameController gameController = new GameController();
    ArrayList<Car> list = new ArrayList<>();
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setData() {
        Car carA = new Car("aa");
        Car carB = new Car("bb");
        list.add(carA);
        list.add(carB);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void closeStream() {
        System.setOut(System.out);
    }

    @Test
    void pickRandomNumberTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    gameController.pickRandomNumber();
                }, 1
        );
    }

    @Test
    void checkGoOptionTest() {
        assertTrue(gameController.checkGoOption(4));
    }

    @Test
    void checkGoOptionFalseTest() {
        assertFalse(gameController.checkGoOption(3));
    }

    @Test
    void roundResultTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    gameController.roundResult(list);
                    assertEquals(0, list.get(0).getOnGoing());
                    assertEquals(1, list.get(1).getOnGoing());
                    assertThat(outputStream.toString()).contains("실행 결과", "aa : ", "bb : -");
                }, 1, 5
        );
    }

    @Test
    void runRaceTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    gameController.runRace("aa,bb".split(","), 2);
                    assertThat(outputStream.toString()).contains("실행 결과", "aa : ", "bb : -", "aa : -");
                }, 1, 5, 6, 2
        );
    }
}
