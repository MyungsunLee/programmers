function solution(seoul) {

    let location = 0;
    const name = 'Kim';

    for (let i = 0; i < seoul.length; i++) {
        if (seoul[i] === name) {
            location = i;
        }
    }

    const answer = "김서방은 " + location + "에 있다";
    return answer;

}
