#include<iostream>
#include<queue>
using namespace std;

int maze[1000][1000];
bool visit[1000][1000];
int n, m;

typedef struct coor {
    int x;
    int y;
} C;

queue<C> q;
int dy[4] = { 0,0,-1,1 };
int dx[4] = { -1,1,0,0 };

bool canvisit(C node) {
    if (node.x < 0 || node.y < 0 || node.x >= n || node.y >= m) {
        return false;
    }
    if (maze[node.x][node.y] != 0) {
        return false;
    }
    if (visit[node.x][node.y]) {
        return false;
    }
    return true;
}


int bfs() {
    int last_day = 0;
    while (!q.empty()) {
        C cur = q.front();
        q.pop();
        for (int i = 0; i < 4; i++) {
            C next = { cur.x + dx[i], cur.y + dy[i] };
            if (canvisit(next)) {
                visit[next.x][next.y] = true;
                maze[next.x][next.y] = maze[cur.x][cur.y] + 1;
                last_day = max(last_day, maze[next.x][next.y]);
                q.push(next);
            }
        }
    }
    return last_day - 1; 
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cin >> m >> n;

    bool all_ripe = true;

    for (int x = 0; x < n; x++) {
        for (int y = 0; y < m; y++) {
            cin >> maze[x][y];
            if (maze[x][y] == 1) {
                q.push({ x, y });
                visit[x][y] = true;
            }
            if (maze[x][y] == 0) {
                all_ripe = false; 
            }
        }
    }

    if(all_ripe) {
        cout << 0;
        return 0;
    }

    int ans = bfs();

    for (int x = 0; x < n; x++) {
        for (int y = 0; y < m; y++) {
            if (maze[x][y] == 0) { 
                cout << -1;
                return 0;
            }
        }
    }

    cout << ans;
    return 0;
}
