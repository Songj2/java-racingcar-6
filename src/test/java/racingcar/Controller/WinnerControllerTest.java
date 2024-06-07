package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerControllerTest {
    private WinnerController winnerController = new WinnerController();
    private ArrayList<Car> cars = new ArrayList<>();
    private ArrayList<String> winners = new ArrayList<>();
    private Car carA = new Car("aa");
    private Car carB = new Car("bb");

    @BeforeEach
    void setData() {
        carA.setOnGoing(1);
        cars.add(carA);
        cars.add(carB);
        winners.add("aa");
    }

    @Test
    void farDistanceTest() {
        assertEquals(1, winnerController.farDistance(cars));
    }

    @Test
    void whoIsWinnerTest() {
        assertThat(winnerController.whoIsWinner(cars)).containsOnly("aa");
    }

    @Test
    void stringWinnerTest() {
        assertEquals("최종 우승자 : aa", winnerController.stringWinner(winners));
    }

    @Test
    void stringWInnersTest() {
        winners.add("bb");
        assertThat(winnerController.stringWinners(winners)).contains("aa", "bb");
    }

    @Test
    void theWinnerSoloTest() {
        assertEquals("최종 우승자 : aa", winnerController.theWinner(cars));
    }

    @Test
    void theWInnerPeopleTest() {
        carB.setOnGoing(1);
        cars.set(1, carB);
        assertEquals("최종 우승자 : aa, bb", winnerController.theWinner(cars));
    }

}
