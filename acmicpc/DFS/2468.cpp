#include <iostream>
#include <vector>

using namespace std;

int N;
int mov[4][2] = {
    {-1,0},
    {1,0},
    {0,-1},
    {0,1}
};
vector<vector<int>> space;
vector<vector<int>> visited;

int isValidPos(int x, int y) {
    if(0<=x&&x<N && 0<=y&&y<N) return 1;
    else return 0;
}

void DFS(int x, int y, int h){
    visited[x][y] = 1;

    for(int i=0; i<4; i++) {
        int nx = x + mov[i][0];
        int ny = y + mov[i][1];

        if(isValidPos(nx,ny) && space[nx][ny] > h && visited[nx][ny] == 0){
            // cout<< nx<< ny<< endl;
            DFS(nx,ny,h);
        }
    }
}

int main() {

    scanf("%d", &N);
    space.assign(N, vector<int>(N,0));
    

    int maxH = 0;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            scanf("%d", &space[i][j]);
            if(maxH<space[i][j]) maxH = space[i][j];
        }
    }
    // cout<< maxH <<endl;
    int sol = 0;
    for(int i=0; i<=maxH; i++){
        visited.assign(N, vector<int>(N,0));
        int count = 0;
        for(int x=0; x<N; x++){
            for(int y=0; y<N; y++){
                if(space[x][y]>i && visited[x][y]==0){ 
                    DFS(x,y,i);
                    count++;
                }
            }
        }
        // cout<< count <<endl;
        if(sol < count) sol = count;
    }

    printf("%d", sol);

    return 0;
}