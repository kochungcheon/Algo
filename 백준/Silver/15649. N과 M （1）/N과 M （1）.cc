#include <iostream>
#include <vector>
#include <cstdio>
using namespace std;

int N, M;
vector<int> arr;
vector<bool> visit;

void choose(int cur) {
    if (cur == M) {
        for (int i = 0; i < arr.size(); i++) {
            printf("%d ", arr[i]);
        }
        printf("\n");
        return;
    }
    for (int i = 1; i <= N; i++) {
        if (visit[i]) continue;
        visit[i] = true;
        arr.push_back(i);
        choose(cur + 1);
        visit[i] = false;
        arr.pop_back();
    }
}

int main() {
    scanf("%d %d", &N, &M);
    visit.resize(N + 1, false);
    choose(0);
    return 0;
}
