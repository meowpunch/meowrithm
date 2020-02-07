/* 
    알파벳 

    DFS
    
    - Counting depth in DFS.

    - Solve 'Time over' problem by changing vector from local to global.
    
    - Passing the vector as parameter: call by value
*/

#include <iostream>
#include <vector>

using namespace std;


vector<int> alp(26,0);
int mov[4][2] = {
    {-1,0},
    {1,0},
    {0,-1},
    {0,1}
};

int R, C;
int maxSol = 0;
vector<vector<char>> board;
vector<vector<bool>> visit;

bool isValidPos(int col, int row) {
    if(0<=row&&row<R && 0<=col&&col<C) return true;
    else return false;
}

void DFS(int col, int row, int depth) {
    if(maxSol < depth) maxSol = depth;

    visit[col][row] = true;
    alp[board[col][row] - 65] = 1;

    for(int i=0; i<4; i++) {
        int nc = col + mov[i][0];
        int nr = row + mov[i][1];

        if(isValidPos(nc,nr) && alp[board[nc][nr] - 65] == 0 && visit[nc][nr] == false){
            DFS(nc,nr,depth+1);
        }
    }

    // Before adding this part, pass a vector as parameter. This causeed 'Time over'. So i put the vector as global variable and add this part.
    // 벡터 '카피' 말고 선언하는데만 시간이 오래걸리는 줄 몰랐음. pass by reference 임에도 불구하고... ㄷㄷ
    visit[col][row] = false;
    alp[board[col][row] - 65] = 0;
}

int main() {
    
    cin>> C >> R;

    // Row * Col
    board.assign(C, vector<char>(R, 'x'));
    visit.assign(C, vector<bool>(R, false));

    for(int i=0; i<C; i++){
        for(int j=0; j<R; j++){
            cin>> board[i][j];
        }
    }

    /* for(vector<char> c: board) {
        for(char ch: c){
            printf("%c", ch);
        }
        cout<<endl;
    } */

    
    // printf("%d %d",'A','Z');
    // cout << 'A';

    DFS(0,0,1);
    cout << maxSol;
    return 0;
}


/*
    TEST CASE

    5 5
    IEFCJ
    FHFKC
    FFALF
    HFGCF
    HMCHH


*/