package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        사용자에게 자동차 이름 입력받기 _IllegalArgumentException
        String[] carName= Console.readLine().split(",");
        Set<String> nameSet = new HashSet<>();
//        5자 이하
        for(String name: carName){
            if (name.length()>5){
                throw new IllegalArgumentException("이름의 길이를 초과하였습니다.");
            }else {
                nameSet.add(name);
            }
        }
//        중복 확인
        if(nameSet.size()!= carName.length){
            throw new IllegalArgumentException("이름이 중복되었습니다.");
        }
//        사용자에게 시도 회수 입력받기 _IllegalArgumentException
//        숫자 확인

//        게임시행
//        랜덤값 뽑기
//        전진 조건 확인 _>=4
//        출력 _이름:
//        경기 종료후 우승자 발표 (중복 가능)
    }
}
