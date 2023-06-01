import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		int sum = 1;
		int count = 1;
		int start_index = 1;
		int end_index = 1;
		while(start_index < (N+1)/2){
			if(sum < N) {
				end_index++;
				sum += end_index;
			}
			else if(sum > N) {
				sum -= start_index;
				start_index++;
			}
			else {
				count++;
				end_index++;
				sum += end_index;
			}
		}
		System.out.println(count);
	}
}
