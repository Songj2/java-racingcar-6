package racingcar.Util;

public class ParseTo {
    //숫자로 변환
    public int parseToInteger(String str) {
        return Integer.parseInt(str);
    }
    //    전진 횟수 변환
    public String parseToHyphen(int count){
        Messages messages= new Messages();
        String dash="";
        for (int i= 0; i<count;i++){
            dash+=messages.GO;
        }
        return dash;
    }
}
