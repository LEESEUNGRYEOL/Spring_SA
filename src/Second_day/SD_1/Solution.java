package Second_day.SD_1;

public class Solution {

    int getGcd(int a, int b) {
        if (a % b == 0)
            return b;
        return getGcd(b, a % b);
    }

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int min;
        int gcd = 0, lcm, tmp;
        min = Math.min(n, m);
        System.out.println("min = " + min);


//        while(m != 0)
//        {
//            tmp = n;
//           n = m;
//           m = tmp % m;
//        }

        gcd = getGcd(m, n);

        lcm = n * m / gcd;

        System.out.println("gcd = " + gcd);
        answer[0] = gcd;
        answer[1] = lcm;
        return answer;
    }
}
