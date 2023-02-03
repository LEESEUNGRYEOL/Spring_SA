package Number_2;

public class prac_1 {
    public static void main(String[] args) {

        Solution sol = new Solution();
        int[] d = {1,3,2,5,4};
        int budget = 9;

        System.out.println(sol.solution(d, budget));
    }
}

class Solution {
    public int solution(int[] d, int budget) {

        int answer = 0;

        for (int i = 0; i < d.length; i++) {

            budget -= d[i];

            if(budget - d[i] < 0) {
                break;
            }
            answer++;

        }
        return answer;
    }
}
