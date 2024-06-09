package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.Viewer.OutputViewer;

import java.util.ArrayList;

public class GameController {
    //        게임시행
    public ArrayList<Car> runRace(String[] carName, int count){
        CarController controller= new CarController();
        ArrayList<Car> list= controller.makeCarList(carName);
        while (count>0){
            list= roundResult(list);
            count--;
            OutputViewer outputViewer= new OutputViewer();
            outputViewer.printEmptyLine();
        }
        return list;
    }
    //    전진 판정
    public ArrayList<Car> roundResult(ArrayList<Car> cars){
        OutputViewer outputViewer= new OutputViewer();
        outputViewer.printRaceStart();
        for (Car car: cars){
            if (checkGoOption(pickRandomNumber())){
                car.setOnGoing(car.getOnGoing()+1);
            }
            outputViewer.printRoundResult(car);
        }
        return cars;
    }
    //        랜덤값 뽑기
    public int pickRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
    //        전진 조건 확인
    public boolean checkGoOption(int randomNumber){
        if (randomNumber>=4){
            return true;
        }
        return false;
    }
}
