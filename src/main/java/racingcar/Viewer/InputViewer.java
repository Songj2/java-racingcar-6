package racingcar.Viewer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Util.ParseTo;
import racingcar.Util.Validated;

public class InputViewer {
    //        사용자에게 자동차 이름 입력받기
    public String[] inputCarName() {
        String[] list = Console.readLine().split(",");
        Validated validated= new Validated();
        validated.validatedName(list);
        return list;
    }
    //        사용자에게 시도 회수 입력받기 _IllegalArgumentException
    public int inputCount() {
        String value = Console.readLine();
        Validated validated= new Validated();
        validated.validatedNumber(value);
        ParseTo parseTo= new ParseTo();
        return parseTo.parseToInteger(value);
    }
}
