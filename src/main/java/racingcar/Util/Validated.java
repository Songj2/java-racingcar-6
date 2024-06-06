package racingcar.Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validated {
    //    IllegalArgumentException
    public void validate(boolean status) {
        if (status) {
            throw new IllegalArgumentException();
        }
    }
    //    사용자에게 입력받은 이름 유효성 검사
    public void validatedName(String[] list) {
        validate(!checkNameSize(list));
        validate(!duplicatedName(list));
    }
    //        5자 이하
    public boolean checkNameSize(String[] carName) {
        for (String name : carName) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }
    //        중복 확인
    public boolean duplicatedName(String[] carName) {
        Set<String> nameSet = new HashSet<>(List.of(carName));
        return nameSet.size() == carName.length;
    }

    public void validatedNumber(String value) {
        validate(!checkInteger(value));
    }

    //        숫자 확인
    public boolean checkInteger(String str) {
        if (str.matches("^\\d$")) {
            return true;
        }
        return false;
    }
}
