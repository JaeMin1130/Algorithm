import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer lengths = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(lengths.nextToken());
		int M = Integer.parseInt(lengths.nextToken());

		Iterator<Integer> A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).iterator();
		Iterator<Integer> B = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).iterator();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int valueA = A.next();
		int valueB = B.next();

		for (int i = 0; i < N + M; i++) {
			if (valueA >= valueB) {
				bw.write(valueB + " ");
				if(B.hasNext()) {
					valueB = B.next();
				}else {
					valueB = 999999999;
				}
			} else {
				bw.write(valueA + " ");
				if(A.hasNext()) {
					valueA = A.next();
				}else {
					valueA = 999999999;
				}
			}
		}

		bw.flush();
		bw.close();
	}
}