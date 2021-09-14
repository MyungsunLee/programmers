import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class getNewId {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String newId = scan.next();
        String recommendId  = solution(newId);

        System.out.println(recommendId);
    }
    public static String solution(String  new_id){
        // 1. length >= 3 && length <= 15
        // 2. [a-z], '-','_','.' 사용 가능
        // 3. . : [0],[length] 사용 불가. 연속사용 불가

        final String CAPITAL = "[A-Z]";
        String[] new_id_arr = new_id.split("");
        // 1. uppercase->lowercase
        for (int i = 0; i < new_id_arr.length; i++){
            if(Pattern.matches(new_id_arr[i],CAPITAL)){
                new_id_arr[i] = new_id_arr[i].toLowerCase();
            }
        }
        // 치환 완료된 arr -> String
        new_id = Arrays.stream(new_id_arr).collect(Collectors.joining());

        // 2. [a-z],\d,'-','_','.' 제외 모든 문자 제거
        // 3. .. -> .
        // 4. ".".equals(new_id_arr[0]) || ".".equals(new_id_arr[new_id_arr.length]) -> replace(".","")
        // 5. 빈 문자열일 경우 a 대입
        // 6. new_id.length > 15 -> new_id = new_id.split("") -> 15
        // 7. new_id < 3 new_id[n+1] = new_id[n]



        return answer;
    }
}
