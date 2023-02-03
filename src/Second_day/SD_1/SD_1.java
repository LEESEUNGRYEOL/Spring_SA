package Second_day.SD_1;

import java.util.Arrays;

public class SD_1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 3, m1 = 12;
        int n2 = 2, m2 = 5;
        System.out.println(Arrays.toString(sol.solution(n1, m1)));
        System.out.println(Arrays.toString(sol.solution(n2, m2)));

    }
}

// 최대공약수 n, m 을 나누는 값 중 제일 큰 값
// n, m 중 작은 값 -> min
// n, m 을 동시에 나누는 수인지 반복문으로 확인
// 1 ~ min --> gcd

// 최소공배수 = 최대공약수 * n/최대공약수 * m/최대공약수
// -> n * m / gcd

