package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carName = inputCarName();
        validate(!checkNameSize(carName));
        validate(!duplicatedName(carName));

        String userNumber = inputCount();
        validate(!checkInteger(userNumber));
        int count = parseToInteger(userNumber);
        ArrayList<Car> result= runRace(carName, count);
    }

    //        사용자에게 자동차 이름 입력받기
    private static String[] inputCarName() {
        return Console.readLine().split(",");
    }

    //        5자 이하
    private static boolean checkNameSize(String[] carName) {
        for (String name : carName) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    //        중복 확인
    private static boolean duplicatedName(String[] carName) {
        Set<String> nameSet = new HashSet<>(List.of(carName));
        return nameSet.size() == carName.length;
    }

    //    IllegalArgumentException
    private static void validate(boolean status) {
        if (status) {
            throw new IllegalArgumentException();
        }
    }

    //        사용자에게 시도 회수 입력받기 _IllegalArgumentException
    private static String inputCount() {
        return Console.readLine();
    }

    //        숫자 확인
    private static boolean checkInteger(String str) {
        if (str.matches("^\\d$")) {
            return true;
        }
        return false;
    }
//숫자로 변환
    private static int parseToInteger(String str) {
        return Integer.parseInt(str);
    }
//    결과를 저장할 객체 생성
    private static ArrayList<Car> makeCarList(String[] carName){
        ArrayList<Car> list= new ArrayList<>();
        for (String name: carName){
            Car car= new Car(name);
            list.add(car);
        }
        return list;
    }
//        게임시행
    private static ArrayList<Car> runRace(String[] carName, int count){
        ArrayList<Car> list= makeCarList(carName);
        while (count>0){
            list= roundResult(list);
            count--;
            System.out.println();
        }
        return list;
    }
//    전진 판정
    private static ArrayList<Car> roundResult(ArrayList<Car> cars){
        for (Car car: cars){
            if (checkGoOption(pickRandomNumber())){
                car.setOnGoing(car.getOnGoing()+1);
            }
            printRoundResult(car);
        }
        return cars;
    }
//        랜덤값 뽑기
    private static int pickRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }
//        전진 조건 확인 _>=4
    private static boolean checkGoOption(int randomNumber){
        if (randomNumber>=4){
            return true;
        }
        return false;
    }
//        출력 _이름:
    private static void printRoundResult(Car car){
        System.out.printf("%s: %s\n", car.getName(), parseToHyphen(car.getOnGoing()));
    }
//    전진 횟수 변환
    private static String parseToHyphen(int count){
        String dash="";
        for (int i= 0; i<count;i++){
            dash+="-";
        }
        return dash;
    }
//        경기 종료후 우승자 발표 (중복 가능)
}
