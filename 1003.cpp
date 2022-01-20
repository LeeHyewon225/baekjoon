#include <iostream>
using namespace std;


int main() {
	int T;
	cin >> T;

	int dp[41][2];
	dp[0][0] = 1;
	dp[0][1] = 0;
	dp[1][0] = 0;
	dp[1][1] = 1;

	for (int i = 0;i < T;i++) {
		int N;
		cin >> N;
		for (int j = 2;j <= N;j++) {
			dp[j][0] = dp[j - 1][0] + dp[j - 2][0];
			dp[j][1] = dp[j - 1][1] + dp[j - 2][1];
		}
		cout << dp[N][0] << " " << dp[N][1] << "\n";
	}
}