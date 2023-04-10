public class Q2_Fibonachi {
    public static void main(String[] args) {

        // 1번 방법
        int[] array = new int[10];
        array[0] = array[1] = 1;
        for (int i = 2; i < 10; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        for (int m = 0; m < 10; m++) {
            System.out.print(array[m] + " "); // 가로로 출력
        }

        // 2번 방법
        int num0 = 1;
        int num1 = 1;
        System.out.println();
        System.out.print(num0 + " " + num1 + " ");
        for (int i = 2; i < 10; i++) {
            int num = num0 + num1;
            System.out.print(num + " ");
            num0 = num1;
            num1 = num;
        }
    }
}