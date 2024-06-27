#include <iostream>
#include <vector>
#include <sstream>
using namespace std;

int N, M;
vector<int> arr;
vector<bool> visit;
stringstream ss;

void choose(int cur, int pre) {
    if (cur == M) {
        for (int a : arr) {
            ss << a << " ";
        }
        ss << '\n';
        return;
    }
    for (int i = pre + 1; i <= N; i++) {
        if (visit[i]) continue;
        visit[i] = true;
        arr.push_back(i);
        choose(cur + 1, i);
        arr.pop_back();
        visit[i] = false;
    }
}

int main() {
    cin >> N >> M;
    visit.resize(N + 1, false);
    choose(0, 0);
    cout << ss.str();
    return 0;
}
