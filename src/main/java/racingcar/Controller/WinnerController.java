package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.Util.Messages;

import java.util.ArrayList;

public class WinnerController {
    Messages messages= new Messages();

    public String theWinner(ArrayList<Car> cars){
        ArrayList<String> winner= whoIsWinner(cars);
        if (winner.size()>1){
            return stringWinners(winner);
        }else {
            return stringWinner(winner);
        }
    }
    //    우승자 선정
    public ArrayList<String> whoIsWinner(ArrayList<Car> cars){
        ArrayList<String> winner= new ArrayList<>();
        int farDistance= farDistance(cars);
        for (Car car: cars){
            if (car.getOnGoing()==farDistance){
                winner.add(car.getName());
            }
        }
        return winner;
    }
    //    가장 멀리간 거리
    public int farDistance(ArrayList<Car> cars){
        int maxNumber= -1;
        for (Car car: cars){
            if (car.getOnGoing()>maxNumber){
                maxNumber= car.getOnGoing();
            }
        }
        return maxNumber;
    }
    //    단독 우승자
    public String stringWinner(ArrayList<String> winner){
        return messages.FINAL_WINNER+ winner.get(0);

    }
    //    공동 우승자
    public String stringWinners(ArrayList<String> winner){
        String names="";
        for (int i=0; i<winner.size();i++){
            names+= winner.get(i);
            if (i<winner.size()-1){
                names+= ", ";
            }
        }
        return messages.FINAL_WINNER+names;
    }
}
