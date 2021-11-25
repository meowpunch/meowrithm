/*
    벽 부수고 이동하기
*/

#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

class Pos {
    public:
        int col;
        int row;
        int flag;

    Pos(int col, int row, int flag) {
        this->col = col;
        this->row = row;
        this->flag = flag;
    }
};

int M,N;

int mov[4][2] = {
    {-1,0},
    {1,0},
    {0,1},
    {0,-1},
};

int isValidPos(int col, int row) {
    if( (col < N && col >= 0) && (row < M && row >= 0) ) return 1;
    else return 0;
}

int main()
{

    // int M, N;
    scanf("%d %d", &N, &M);

    vector<vector<int>> space;
    vector<vector<vector<int>>> visited;
    vector<vector<vector<int>>> count;
    space.assign(N, vector<int>(M, 0));
    visited.assign(N, vector<vector<int>>(M, vector<int>(2,0)));
    count.assign(N, vector<vector<int>>(M, vector<int>(2,-1)));
   

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {   
            scanf("%1d", &space[i][j]);
        }
       
    }
  
    queue<Pos> q;
    q.push(Pos(0,0,0));

    visited[0][0][0] = 1;
    count[0][0][0] = 1;
    
    
    while (!q.empty() && !(q.front().col==N-1 && q.front().row==M-1))
    {
        Pos curPos = q.front();
        // cout<< curPos.col << curPos.row << curPos.flag <<endl; 
        // cout<< count[curPos.col][curPos.row][0] << count[curPos.col][curPos.row][1] << endl;

        q.pop();
        // visited[curPos.first][curPos.second] = 1;
        // space[curPos.col][curPos.row] = 1;

        for(int i=0; i<4; i++) {
            int nexCol = curPos.col+mov[i][0];
            int nexRow = curPos.row+mov[i][1];

            if(isValidPos(nexCol, nexRow)==1)
            {   
                if(space[nexCol][nexRow] != 1 && visited[nexCol][nexRow][curPos.flag] != 1) {
                    count[nexCol][nexRow][curPos.flag] = count[curPos.col][curPos.row][curPos.flag] + 1;
                    q.push(Pos(nexCol,nexRow,curPos.flag));
                    visited[nexCol][nexRow][curPos.flag] = 1;
                } else if(curPos.flag==0 && visited[nexCol][nexRow][1] != 1){
                    count[nexCol][nexRow][1] = count[curPos.col][curPos.row][curPos.flag] + 1;
                    q.push(Pos(nexCol,nexRow,1));
                    visited[nexCol][nexRow][1] = 1;
                }
            }
        }

    }

    printf("%d", max(count[N-1][M-1][0], count[N-1][M-1][1]));
    return 0;
}