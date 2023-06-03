import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		char A[] = s.next().toCharArray();
		Arrays.sort(A);
		for (int i = A.length - 1; i >= 0; i--)
			System.out.print(A[i] - '0');

	}
}
