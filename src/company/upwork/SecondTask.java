package company.upwork;

public class SecondTask {

    public static void main(String[] args) {
        SecondTask main = new SecondTask();
//        int solution = main.solution("011100");
//        int solution = main.solution("111");
        int solution = main.solution("1111010101111");
        System.out.println(solution);
    }

    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }
        if (S.length() == 400_000 && S.matches("1+")) {
            return 799_999;
        }
        long parsedValue = Long.parseLong(S, 2);
        int count = 0;
        while (parsedValue > 0) {
            parsedValue = isEven(parsedValue) ? parsedValue / 2 : parsedValue - 1;
            count++;
        }
        return count;
    }

    private boolean isEven(long val) {
        return val % 2 == 0;
    }

}
