import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String[] input = br.readLine().split(" ");
			if (input[1].equals("enter")) {
				set.add(input[0]);
			} else {
				set.remove(input[0]);
			}
		}
		
		set.stream().sorted((s1, s2) -> s2.compareTo(s1)).forEach(System.out::println);
	}
}