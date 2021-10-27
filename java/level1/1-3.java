import java.util.*;

public class replaceSToNum {
    public static void main(String[] args) {
	// 영문자 숫자로 변환
        int answer = solution("one4seveneight");
    }

    public static int solution(String s) {
        HashMap<String, String> numArr = new HashMap();
        String[] valArr = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            numArr.put(valArr[i], String.valueOf(i));
        }

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(valArr[i], numArr.get(valArr[i]));
        }

        return Integer.parseInt(s);
    }

}

