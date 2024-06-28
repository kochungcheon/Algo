#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int N, M;
vector<int> arr;
stringstream ss;

void choose(int cur, int pre) {
    if (cur == M) {
        for (int a : arr) {
            ss << a << " ";
        }
        ss << "\n";
        return;
    }
    
    for (int i = pre; i <= N; i++) {
        arr.push_back(i);
        choose(cur + 1, i);
        arr.pop_back();
    }
}


int main() {
    cin >> N >> M;
    choose(0, 1);
    cout << ss.str();
    return 0;
}
