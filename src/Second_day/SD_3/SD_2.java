package Second_day.SD_3;

import java.util.Arrays;

// n을 x 로 나눈 나머지가 1이 되는 경우. x의 최소값
// 반복문 -> 1 ~ n (i)
// n % i == 1 -> 이 경우를 찾고 찾으면 break;
//  return i


class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n ; i++) {
            if(n%i == 1)
            {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

public class SD_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 10;
        int n2 = 12;

        System.out.println((sol.solution(n1)));
        System.out.println((sol.solution(n2)));

    }
}

테스트 1 〉	통과 (7.32ms, 82MB)
        테스트 2 〉	통과 (0.02ms, 72.3MB)
        테스트 3 〉	통과 (0.02ms, 72.3MB)
        테스트 4 〉	통과 (0.02ms, 79MB)
        테스트 5 〉	통과 (0.01ms, 78.7MB)
        테스트 6 〉	통과 (0.04ms, 67.1MB)
        테스트 7 〉	통과 (0.06ms, 75.6MB)
        테스트 8 〉	통과 (0.02ms, 78.6MB)
        테스트 9 〉	통과 (0.02ms, 76.2MB)
        테스트 10 〉	통과 (0.04ms, 71.4MB)
        테스트 11 〉	통과 (0.02ms, 80.7MB)