package racingcar;

import racingcar.Controller.GameController;
import racingcar.Model.Car;
import racingcar.Viewer.InputViewer;
import racingcar.Viewer.OutputViewer;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputViewer inputViewer= new InputViewer();
        OutputViewer outputViewer= new OutputViewer();
        GameController gameController= new GameController();

        outputViewer.inputCarName();
        String[] carNames= inputViewer.inputCarName();

        outputViewer.inputCount();
        int count= inputViewer.inputCount();

        ArrayList<Car> result= gameController.runRace(carNames, count);

        outputViewer.printWinner(result);


    }

}
