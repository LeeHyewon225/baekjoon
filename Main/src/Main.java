import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int A[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++)
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		for(int i=0;i<str.length();i++) {
			int max = A[i];
			int max_index = i;
			for(int j=i;j<str.length();j++) {
				if(max < A[j]) {
					max = A[j];
					max_index = j;
				}
			}
			int temp = A[i];
			A[i] = A[max_index];
			A[max_index] = temp;
		}
		for(int i=0;i<str.length();i++)
			System.out.print(A[i]);
	}
}
