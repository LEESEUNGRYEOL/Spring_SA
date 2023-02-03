package Number1;//두 정수 left와 right가 매개변수로 주어집니다.
// left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
// 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.


public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int answer;
        int n1 = 13;
        int n2 = 17;

        answer = sol.solution(n1,n2);
        System.out.println(answer);
    }
}

class Solution {

    static int count (int n)
    {
        int i = 1, j = 0, flag = 0;
        while (true) {
            if (n % i == 0) {
                // i 이전꺼의 순서쌍 친구인 j
                if (i == j) {
                    break;
                }
                // J값 업데이트
                j = n / i;  // 1. (1,12) (2,6) (3,4) (4,3

            }

            // 업데이트된 j (i의 순서쌍 친구)
            if (i == j) {
                flag = 1;// 제곱수인 경우
                break;
            }
            i++;
        }
        return flag;
    }

    public int solution(int n1, int n2) {
        // n = 12 일 경우
        int result = 0;
        for (int i = n1; i <= n2 ; i++) {
            if(count(i) == 1){
                result -= i;
            }
            else{
                result+= i;
            }
        }
        return result;

    }
}