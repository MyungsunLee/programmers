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

        //1단계
        String[] new_id_arr = new_id.toLowerCase().split("");
        String CAPITAL = "[a-z\\d\\_\\-\\.]";
        //2단계
        for (int i = 0; i< new_id_arr.length;i++){
            if (!Pattern.matches(CAPITAL,new_id_arr[i])){
                new_id_arr[i] = "";
            }
        }
        new_id = Arrays.stream(new_id_arr).collect(Collectors.joining());

        //3단계
        boolean flag = true;

        while(flag){

            if(new_id.indexOf("..")>-1) {
                new_id = new_id.replace("..",".");
                flag = true;
            }else{
                flag = false;
            }

        }
        System.out.println(new_id);
        //4단계
        flag = true;
        while(flag){

            if(new_id.length() < 2){
                if(".".equals(new_id)){
                    new_id = "";
                }
                flag = false;
            }else {
                // 첫번째 . 제거
                if (".".equals(new_id.substring(0, 1))) {
                    new_id = new_id.substring(1, new_id.length());
                } else {
                    flag = false;
                }

            }


            if(new_id.length() < 2){
                if(".".equals(new_id)){
                    new_id = "";
                }
                flag = false;
            }else{

                // 마지막 . 제거
                if(".".equals(new_id.substring(new_id.length()-1,new_id.length()))){
                    System.out.println("test");
                    new_id = new_id.substring(0,new_id.length()-1);
                    flag = true;
                }else{
                    flag = false;
                }
            }


        }
        //5단계
        if("".equals(new_id.trim())){
            new_id = "a";
        }
        //6단계
        if (new_id.length() > 15){
            new_id = new_id.substring(0,15);


            flag = true;
            while(flag){
                if(".".equals(new_id.substring(new_id.length()-1,new_id.length()))) {
                    new_id = new_id.substring(0,new_id.length()-1);
                }else {
                    flag = false;
                }
            }


        }else if(new_id.length() < 3){
            while(new_id.length() <3){
                new_id += new_id.substring(new_id.length()-1, new_id.length());
            }

        }else{
            flag = true;
            while(flag){
                if(".".equals(new_id.indexOf(new_id.length()))) {


                    new_id = new_id.substring(0,new_id.length()-1);
                }else {
                    if(new_id.length() < 3){
                        new_id += new_id.substring(new_id.length()-1, new_id.length());
                    }else{
                        flag = false;
                    }

                }
            }
        }
        String answer = new_id;

        return answer;
    }
}
