/*
    유기농 배추

    implement DFS using recursive function
*/

#include <iostream>
#include <vector>
#include <queue>
#include <stack>

using namespace std;

class Pos {
    public:
        int x;
        int y;
    
    Pos(int x, int y){
        this->x = x;
        this->y = y;
    }
};

int T;
int M, N, K;
vector<vector<int>> space;
vector<vector<int>> visited;

int mov[4][2] = {
    {-1,0},
    {1,0},
    {0,-1},
    {0,1}
};


int isValidPos(int x, int y) {
    if(0<=x&&x<M && 0<=y&&y<N) return 1;
    else return 0;
}

void DFS(int x, int y) {
    visited[x][y] = 1;

    for(int i=0; i<4; i++){
        int nx = x + mov[i][0];
        int ny = y + mov[i][1];

        if(isValidPos(nx,ny) == 1 && space[nx][ny] == 1 && visited[nx][ny] == 0) {
            DFS(nx, ny);
        }
    }
}

int main() {
    scanf("%d", &T);

    for(int i=0; i<T; i++){

        scanf("%d %d %d", &M, &N, &K);

        space.assign(M, vector<int>(N, 0));
        visited.assign(M, vector<int>(N, 0));

        queue<Pos> q;

        for(int j=0; j<K; j++){
            int x,y;
            scanf("%d %d", &x, &y);

            space[x][y] = 1;
            
            q.push(Pos(x,y));
        }

        int count = 0;
        while(!q.empty()){
            Pos str = q.front();
            if(visited[str.x][str.y] == 0) {
                DFS(str.x, str.y);
                count++;
            }
            q.pop();
        }

        printf("%d\n", count);
    }



    return 0;

}