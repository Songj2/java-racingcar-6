package racingcar.Viewer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Model.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewerTest {
    Car car = new Car("aa");
    ArrayList<Car> list = new ArrayList<>();
    OutputViewer outputViewer = new OutputViewer();

    private ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void closeStream() {
        System.setOut(System.out);
    }

    @Test
    void printRoundResult() {
        outputViewer.printRoundResult(car);
        assertEquals("aa : \n", outputMessage.toString());
    }

    @Test
    void printWinner() {
        car.setOnGoing(1);
        list.add(car);
        outputViewer.printWinner(list);
        assertEquals("최종 우승자 : aa\r\n", outputMessage.toString());
    }
}
