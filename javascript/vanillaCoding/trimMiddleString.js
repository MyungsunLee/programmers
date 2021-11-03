function solution(s) {

    const middleLocation = Math.ceil(s.length/2);

    let answer = '';

    if(s.length%2 === 0){
        answer = s[middleLocation-1] + s[middleLocation];
    }else{
        answer = s[middleLocation-1];
    }

    return answer;
}
