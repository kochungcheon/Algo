#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;

int N, M;
vector<int> arr;
vector<int> lst;
bool* visit;
ostringstream os;

void choose(int cur, int pre) {
    if (cur == M) {
        for (int i : lst) {
            os << i << " ";
        }
        os << "\n";
        return;
    }
    for (int i = pre + 1; i < N; i++) {
        visit[i] = true;
        lst.push_back(arr[i]);
        choose(cur + 1, i);
        lst.pop_back();
        visit[i] = false;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;
    arr.resize(N);
    visit = new bool[N]();

    for (int i = 0; i < N; i++) {
        cin >> arr[i];
    }

    sort(arr.begin(), arr.end());
    choose(0, -1);
    cout << os.str();

    delete[] visit;
    return 0;
}
