#include <iostream>
#include <algorithm>

using namespace std;

int maze[1002][1002];
int dp[1002][1002];

int main() {
	int N, M;
	cin >> N >> M;
	for (int i = 1;i <= N;i++)
		for (int j = 1;j <= M;j++) {
			cin >> maze[i][j];
			dp[i][j] = 0;
		}
	for (int i = 1;i <= N;i++) {
		for (int j = 1;j <= M;j++) {
			dp[i][j] = max(dp[i - 1][j] + maze[i][j], dp[i][j - 1] + maze[i][j]);
		}
	}
	cout << dp[N][M];
}