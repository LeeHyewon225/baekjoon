#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int list[8];
bool check_list[8];

void N_AND_M5(int depth, int ans[8]) {
    if (depth == M) {
        for (int i = 0;i < M;i++)
            cout << ans[i] << " ";
        cout << "\n";
        return;
    }
    int ans_copy[8];
    for (int i = 0;i < depth;i++)
        ans_copy[i] = ans[i];
    for (int i = 0;i < N;i++) {
        if (!check_list[i]) {
            check_list[i] = true;
            ans_copy[depth] = list[i];
            N_AND_M5(depth + 1, ans_copy);
            check_list[i] = false;
        }
    }
}

int main() {
    cin >> N >> M;
    for (int i = 0;i < N;i++) {
        cin >> list[i];
        check_list[i] = false;
    }
    sort(list, list + N);
    int ans[8] = { 0 };
    N_AND_M5(0, ans);
    return 0;
}