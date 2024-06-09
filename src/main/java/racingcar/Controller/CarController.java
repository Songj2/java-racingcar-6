package racingcar.Controller;

import racingcar.Model.Car;

import java.util.ArrayList;

public class CarController {
    //    결과를 저장할 객체 생성
    public static ArrayList<Car> makeCarList(String[] carName){
        ArrayList<Car> list= new ArrayList<>();
        for (String name: carName){
            Car car= new Car(name);
            list.add(car);
        }
        return list;
    }
}
