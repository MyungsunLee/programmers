import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String, Integer> leftPointer = new HashMap<String, Integer>();
    Map<String, Integer> rightPointer = new HashMap<String, Integer>();
    List<String> resultHandList = new ArrayList<String>();

    public String solution(int[] numArr, String hand) {

        List<Integer> numList = Arrays.asList(Arrays.stream(numArr).boxed().toArray(Integer[]::new));
        
        List<Integer> leftList = Arrays.asList(new Integer[]{1,4,7});
        List<Integer> rightList = Arrays.asList(new Integer[]{3,6,9});

        // leftStatus init
        leftPointer.put("x", 3);
        leftPointer.put("y", 0);

        // rightStatus init
        rightPointer.put("x", 3);
        rightPointer.put("y", 2);

        int[][] arr2d = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 12}
        };

        numList.stream().forEach(
                e -> {
                    // 왼손/오른손 배열인지 한번 확인 후 for문 돌림

                    int leftRange = leftList.indexOf(e);
                    int rightRange = rightList.indexOf(e);

                    if(leftRange > -1) {
                        changeCommonHandPointer(leftRange,0,"L");
                    } else if(rightRange > -1) {
                        changeCommonHandPointer(rightRange,0,"R");
                    } else {
                        // arr2d[n][1] 일 경우 거리/손 위치 계산
                        for (int i = 0; i < arr2d.length; i++) {
                            if (e.equals(arr2d[i][1])) {
                                int leftLength = Math.abs(leftPointer.get("x") - i) + Math.abs(leftPointer.get("y") - 1);
                                int rightLength = Math.abs(rightPointer.get("x") - i) + Math.abs(rightPointer.get("y") - 1);

                                // 여기 아래 중복코드 제거
                                String resultHand = "";
                                if (leftLength < rightLength) {
                                    resultHand = "L";
                                } else if (leftLength > rightLength) {
                                    resultHand = "R";
                                } else {
                                    if (hand.equals("right")) {
                                        resultHand = "R";
                                    } else {
                                        resultHand = "L";
                                    }
                                }
                                changeCommonHandPointer(i,1, resultHand);
                            }
                        }
                    }
                }
        );


        String answer = resultHandList.stream().collect(Collectors.joining());
        return answer;
    }

    // 왼손의 좌표값을 세팅하는 메서드
    public void changeCommonHandPointer(int x, int y, String hand) {
        if(hand.equals("R")){
            changeRightHandPointer(x,y);
        }else{
            changeLeftHandPointer(x,y);
        }
    }

    public void changeRightHandPointer(int x, int y) {
        rightPointer.put("x", x);
        rightPointer.put("y", y);
        resultHandList.add("R");
    }

   public void changeLeftHandPointer(int x, int y) {
        leftPointer.put("x", x);
        leftPointer.put("y", y);
        resultHandList.add("L");
    }
}
