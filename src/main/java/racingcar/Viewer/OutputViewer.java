package racingcar.Viewer;

import racingcar.Controller.WinnerController;
import racingcar.Model.Car;
import racingcar.Util.Messages;
import racingcar.Util.ParseTo;

import java.util.ArrayList;

public class OutputViewer {
//    이름
    public void inputCarName(){
        Messages messages= new Messages();
        System.out.println(messages.INPUT_CAR_NAME);
    }
//    회수
    public void inputCount(){
        Messages messages= new Messages();
        System.out.println(messages.INPUT_COUNT);
    }
//    경기 시작 
    public void printRaceStart(){
        Messages messages= new Messages();
        System.out.println(messages.RACE_START);
    }
//    공백 
    public void printEmptyLine(){
        System.out.println();
    }
    //        전진 
    public void printRoundResult(Car car){
        ParseTo parseTo= new ParseTo();
        System.out.printf("%s : %s\n", car.getName(), parseTo.parseToHyphen(car.getOnGoing()));
    }
    //        우승자 
    public void printWinner(ArrayList<Car> cars){
        WinnerController winnerController= new WinnerController();
        System.out.println(winnerController.theWinner(cars));
    }
}
