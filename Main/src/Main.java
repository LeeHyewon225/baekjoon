import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int LCS[][] = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 1; i < str1.length() + 1; i++)
			for (int j = 1; j < str2.length() + 1; j++)
				if (str1.charAt(i - 1) != str2.charAt(j - 1))
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				else
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
		System.out.println(LCS[str1.length()][str2.length()]);
		if (LCS[str1.length()][str2.length()] == 0)
			return;
		int i = str1.length();
		int j = str2.length();
		StringBuffer sb = new StringBuffer();
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
				sb.append(str1.charAt(i - 1));
				i--;
				j--;
			} else {
				if (LCS[i - 1][j] < LCS[i][j - 1])
					j--;
				else
					i--;
			}
		}
		System.out.println(sb.reverse());
	}
}
