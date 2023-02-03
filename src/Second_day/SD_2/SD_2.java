package Second_day.SD_2;

import java.util.Arrays;

// 0. commands 먼저 for 문을 돌리면서 ( 0,1,2... n)  라고 할때 i번째의 0,1 인덱스(fixed))
// 1. array 를 자른 새로운 배열 new_arr 만든다 (copyOfrange) (i,j).
// 2. 만든 배열을 sort 한다. Arrays.sort (new_arr);
// 3. commands에 있는


class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            int tmp = 0;
            for (int idx = 0; idx < command.length; idx++) {
                int i = command[0];
                int j = command[1];
                int k = command[2];
                int[] new_arr = Arrays.copyOfRange(array, (i-1), j);
                System.out.println(Arrays.toString(new_arr));
                Arrays.sort(new_arr);
                tmp = new_arr[k-1];
                System.out.println(tmp);
            }
            answer[index++] = tmp;
        }
        return answer;
    }
}



public class SD_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] array = {1,5,2,6,3,7,4};
        int[][] coomands = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.println(Arrays.toString(sol.solution(array,coomands)));

    }
}
