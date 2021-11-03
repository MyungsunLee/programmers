
function solution(n) {

    const oddString = "박";
    const evenString = "수";

    let answer = '';

    for (let i = 0; i < n; i++) {

        if(i%2 === 1){
            answer += oddString;
        }else{
            answer += evenString;
        }
    }

    return answer;
}

