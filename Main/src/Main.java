import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static int check_list[] = new int[4];
	static int window[] = new int[4];
	static int count = 0;

	private static void add(char c) {
		switch (c) {
		case 'A':
			window[0]++;
			break;
		case 'C':
			window[1]++;
			break;
		case 'G':
			window[2]++;
			break;
		case 'T':
			window[3]++;
			break;
		}
	}
	
	private static void remove(char c) {
		switch (c) {
		case 'A':
			window[0]--;
			break;
		case 'C':
			window[1]--;
			break;
		case 'G':
			window[2]--;
			break;
		case 'T':
			window[3]--;
			break;
		}
	}
	
	private static void check() {
		count++;
		for(int j=0;j<4;j++) {
			if(window[j]<check_list[j]) {
				count--;
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char A[] = bf.readLine().toCharArray();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < 4; i++)
			check_list[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < P; i++) 
			add(A[i]);
		check();		
		for (int i = 0; i < S - P; i++) {
			remove(A[i]);
			add(A[i+P]);
			check();
		}
		System.out.println(count);
		bf.close();
	}
}
