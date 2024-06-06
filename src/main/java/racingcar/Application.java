package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] carName= inputCarName();
        validate(!checkNameSize(carName));
        validate(!duplicatedName(carName));

        String userNumber= inputCount();
        validate(!checkInteger(userNumber));
        int count= parseToInteger(userNumber);
    }
//        사용자에게 자동차 이름 입력받기
    private static String[] inputCarName(){
        return Console.readLine().split(",");
    }
//        5자 이하
    private static boolean checkNameSize(String[] carName){
        for (String name: carName){
            if (name.length()>5){
                return false;
            }
        }
        return true;
    }
//        중복 확인
        private static boolean duplicatedName(String[] carName){
        Set<String> nameSet= new HashSet<>(List.of(carName));
        return nameSet.size()== carName.length;
    }
//    IllegalArgumentException
    private  static void validate(boolean status){
        if (status){
            throw new IllegalArgumentException();
        }
    }
//        사용자에게 시도 회수 입력받기 _IllegalArgumentException
    private static String inputCount(){
        return Console.readLine();
    }
//        숫자 확인
private static boolean checkInteger(String str){
        if (str.matches("^\\d$")){
            return true;
        }
        return false;
}
private static  int parseToInteger(String str){
        return Integer.parseInt(str);
}
//        게임시행
//        랜덤값 뽑기
//        전진 조건 확인 _>=4
//        출력 _이름:
//        경기 종료후 우승자 발표 (중복 가능)
}
