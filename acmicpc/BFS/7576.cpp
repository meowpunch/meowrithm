// 토마토

#include <iostream>
#include <queue>
#include <vector>

using namespace std;

int M,N;

int mov[4][2] = {
    {-1,0},
    {1,0},
    {0,1},
    {0,-1},
};

int isValidPos(int y, int x) {
    if( (y < N && y >= 0) && (x < M && x >= 0) ) return 1;
    else return 0;
}

int main()
{

    // int M, N;
    scanf("%d %d", &M, &N);

    vector<vector<int>> tom;
    vector<vector<int>> visited;
    vector<vector<int>> count;
    tom.assign(N, vector<int>(M));
    count.assign(N, vector<int>(M, 2000000));
    visited.assign(N, vector<int>(M, 0));
    queue<pair<int, int>> q;

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < M; j++)
        {
            scanf("%d", &tom[i][j]);
            if (tom[i][j] == 1)
            {
                q.push(make_pair(i, j));
                count[i][j] = 0;
                visited[i][j] = 1;
            }
        }
    }

    /* for(vector<int> v: tom){
        for(int e: v) printf("%d ", e);
        cout<<endl;
    } */

    /* while(!q.empty()) {
        printf("%d %d",q.front().first, q.front().second);
        q.pop();
    } */

    while (!q.empty())
    {
        pair<int, int> curPos = q.front();
        q.pop();
        // visited[curPos.first][curPos.second] = 1;
        tom[curPos.first][curPos.second] = 1;

        for(int i=0; i<4; i++) {
            pair<int,int> nexPos = make_pair(curPos.first+mov[i][0], curPos.second+mov[i][1]);
            
            // cout << nexPos.first << nexPos.second << isValidPos(nexPos.first,nexPos.second) << endl;

            if(isValidPos(nexPos.first, nexPos.second)==1 && visited[nexPos.first][nexPos.second] != 1 && tom[nexPos.first][nexPos.second] != -1)
            {
                count[nexPos.first][nexPos.second] = count[curPos.first][curPos.second] + 1;
                q.push(nexPos);
                visited[nexPos.first][nexPos.second] = 1;
            }
        }

    }

    // cout<<endl;

    int zeroflag = 1; // at least zer
    int oneflag = 0; 
    for (vector<int> v : tom)
    {
        for (int e : v)
        {
            // printf("%d ", e);
            if (e == 0)
                zeroflag = 0;
            if (e == 1)
                oneflag = 1;
        }
        // cout<<endl;
    }

    if (zeroflag == 0 || oneflag == 0)
        printf("-1");
    else if(zeroflag == 1)
    {
        int solMax = 0;
        for (vector<int> v : count)
        {
            for (int e : v)
                if (e > solMax && e!=2000000)
                    solMax = e;
        }
        printf("%d", solMax);
    }

    return 0;
}