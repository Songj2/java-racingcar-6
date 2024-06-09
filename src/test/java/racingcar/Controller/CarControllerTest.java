package racingcar.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.util.ArrayList;


import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {
    private final CarController carController = new CarController();
    private static String[] names;

    @BeforeEach
    void setData() {
        names = "aa,bb".split(",");
    }

    @Test
    void makeCarListTest() {
        ArrayList<Car> list = carController.makeCarList(names);
        Car carA = new Car("aa");
        Car carB = new Car("bb");
        assertThat(list).containsOnly(carA, carB);
    }
}
