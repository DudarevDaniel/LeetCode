package company.upwork;

public class BoundedSlice {

    public static void main(String[] args) {
        BoundedSlice main = new BoundedSlice();
        int[] a = new int[]{3, 5, 7, 6, 3};
        int solution = main.solution(2, a);
        System.out.println(solution);
    }

    public int solution(int K, int[] A) {
        if (A == null) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int max = A[i];
            int rightPointer = i;
            while (max - min <= K) {
                System.out.println("(" + i + ", " + rightPointer + ")");
                count++;
                if (count == 1_000_000_000) {
                    return count;
                }
                rightPointer++;
                if (rightPointer == A.length) {
                    break;
                }
                min = Math.min(min, A[rightPointer]);
                max = Math.max(max, A[rightPointer]);
            }


        }
        return count;
    }
}
