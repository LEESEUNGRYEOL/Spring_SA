package LEESEUNGRYEOL.Number2;
//두 정수 left와 right가 매개변수로 주어집니다.
// left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.


public class prac_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int answer;
        int n= 25;


        answer = sol.solution(n);
        System.out.println(answer);
    }
}

class Solution {
    int solution(int n) {
        // n = 12 일 경우
        int i = 1, j = 0, flag = 0;
        int sum = 0;
        while (true) {
            if (n % i == 0) {
                // i 이전꺼의 순서쌍 친구인 j
                if (i == j) {
                    break;
                }
                // J값 업데이트
                j = n / i;  // 1. (1,12) (2,6) (3,4) (4,3
                sum += i+j;
            }

            // 업데이트된 j (i의 순서쌍 친구)
            if (i == j) {
                flag = 1;// 제곱수인 경우
                sum -=i;
                break;
            }
            i++;
        }
        return sum;

    }
}