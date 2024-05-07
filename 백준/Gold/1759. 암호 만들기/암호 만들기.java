import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static String[] input;
    static PriorityQueue<String> answers = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();
		int c = sc.nextInt();
		sc.nextLine();
		input = sc.nextLine().split(" ");

		sc.close();

        combination(0, l, 0, 0, new StringBuilder(""));
        while(!answers.isEmpty()){
            System.out.println(answers.poll());
        }
    }

    static void combination(int idx, int len, int vowelCount, int consonantCount, StringBuilder st){
        if(st.length() == len){
            if(vowelCount >= 1 && consonantCount >= 2){
                String answer = Arrays.stream(st.toString().split(""))
                                 .sorted()
                                 .collect(Collectors.joining());
                answers.add(answer);
            }
            return;
        }

        for (int i = idx; i < input.length; i++) {
            String letter = input[i];
            StringBuilder nextSt = new StringBuilder(st.toString());
            nextSt.append(letter);

            if("aeiou".contains(letter)) combination(i + 1, len, vowelCount + 1, consonantCount, nextSt);
            else combination(i + 1, len, vowelCount, consonantCount + 1, nextSt);

        }
    }
}