import java.util.ArrayList;
import java.util.Scanner;

public class Q01_Main {
    public static void main(String[] args) {

        Q01_Student no1 = new Q01_Student("김재민", "2016");
        Q01_Student no2 = new Q01_Student("정지헌", "2017");
        Q01_Student no3 = new Q01_Student("정찬혁", "2018");

        ArrayList<Q01_Student> list = new ArrayList<Q01_Student>();
        list.add(no1);
        list.add(no2);
        list.add(no3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("계속 검색을 원하시면 y, 종료하려면 n");
            String input1 = scanner.nextLine();
            if (input1.equals("y")) {
                System.out.println("찾으시는 학생의 이름을 입력하세요.");
                String input2 = scanner.next();
                boolean flag = false;
                for (Q01_Student stu : list) {
                    if (stu.getName().equals(input2)) {
                        System.out.println("해당하는 학생의 학번은 " + stu.getNo() + "입니다.");
                        flag = true;
                    }
                }
                if (!flag) {
                    System.out.println("일치하는 학생이 없습니다.");
                }
            } else if (input1.equals("n")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}