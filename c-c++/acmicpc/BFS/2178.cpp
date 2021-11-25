/*
    미로 탐색
*/

#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> space;
vector<vector<bool>> visit;
vector<vector<int>> count;

int mov[4][2] = {
    {-1,0},
    {1,0},
    {0,1},
    {0,-1}
};

bool isValidPos(int col, int row) {
    if(0<=col&&col<N && 0<=row&&row<M) return true;
    else return false;
}

int BFS(int col, int row) {
    
    queue<pair<int,int>> q;

    q.push(make_pair(col, row));
    visit[col][row] = true;

    while(!q.empty()) {
        int cc = q.front().first;
        int cr = q.front().second;

        q.pop();

        if(cc == N-1 && cr == M-1) return count[cc][cr];

        for(int i=0; i<4; i++) {
            int nc = cc + mov[i][0];
            int nr = cr + mov[i][1];

            if(isValidPos(nc,nr) && space[nc][nr]==1 && !visit[nc][nr]) {
                
                q.push(make_pair(nc,nr));
                visit[nc][nr] = true;
                count[nc][nr] = count[cc][cr] + 1;
            }
        }
    }
}

int main() {
    cin>> N >> M;
    space.assign(N, vector<int>(M, 0));
    visit.assign(N, vector<bool>(M, false));
    count.assign(N, vector<int>(M, 1));

    for(int i=0; i<N; i++) {
        for(int j=0; j<M; j++) {
            scanf("%1d", &space[i][j]);
        }
    }
  
    cout<< BFS(0, 0);
    return 0;
}
