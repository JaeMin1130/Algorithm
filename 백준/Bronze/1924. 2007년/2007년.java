import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String arr[] = input.split(" ");
        int month = Integer.parseInt(arr[0]);
        int day = Integer.parseInt(arr[1]);

        int[] endDate = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] week = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        String[][] calendar = new String[month][32];
        int countWeek = 0;
        int countEnd = 0;

        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < endDate[countEnd]; j++) {
                calendar[i][j] = week[countWeek];
                countWeek++;
                if (countWeek == 7) {
                    countWeek = 0;
                }
            }
            countEnd++;
        }
        System.out.println(calendar[month - 1][day - 1]);
    }
}