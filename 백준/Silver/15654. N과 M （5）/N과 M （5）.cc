#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

int N, M;
vector<int> arr;
vector<bool> visit;
vector<int> chooses;
stringstream ss;

void choose(int cur) {
    if (cur == M) {
        for (int i : chooses) {
            ss << i << " ";
        }
        ss << "\n";
        return;
    }
    for (int i = 0; i < N; i++) {
        if (visit[i]) continue;
        visit[i] = true;
        chooses.push_back(arr[i]);
        choose(cur + 1);
        chooses.pop_back();
        visit[i] = false;
    }
}


int main() {
    cin >> N >> M;
    arr.resize(N);
    visit.resize(N, false);

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());
    choose(0);

    cout << ss.str();
    return 0;
}
