function main() {

    let lottos = [44, 1, 0, 0, 31, 25];
    let win_nums = [31, 10, 45, 1, 6, 19];

    const answer = solution(lottos, win_nums);

    console.log(answer);
}

function solution(lottos, win_nums) {

    lottos.sort();
    win_nums.sort();

    // 정답 갯수
    let winningNumberCount = 0;
    // 지워진 번호 갯수
    let unknownNumber = 0;
    for (let i = 0; i < lottos.length; i++) {

        // 지워진 수 체크
        if (lottos[i] === 0) {
            unknownNumber += 1;

        // 알아볼 수 있는 수만 비교
        } else {
            for (let j = 0; j < win_nums.length; j++) {

                if (lottos[i] === win_nums[j]) {
                    winningNumberCount += 1;
                }
            }
        }
    }

    // 갯수에 따라 당첨등수 확인
    const rank = [6,6,5,4,3,2,1];
    const maxRank = rank[winningNumberCount + unknownNumber];
    const minRank = rank[winningNumberCount];

    let answer = [maxRank,minRank];
    return answer;
}

main();
