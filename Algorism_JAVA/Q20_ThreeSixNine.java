public class Q20_ThreeSixNine {
    private static int count(int i) {
        int times = 0;
        do {
            if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                times++;
            }
            i = i / 10;
        } while (i > 0);
        return times;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (count(i) == 0) {
                System.out.print(i + " ");
            } else if (count(i) == 1) {
                System.out.print("짝" + " ");
            } else {
                System.out.print("짝짝" + " ");
            }
        }
    }
}