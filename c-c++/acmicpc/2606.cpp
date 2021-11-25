#include <iostream>
#include <queue>

using namespace std;

int connected[201][201] = {
    0,
}; // 1 ~ max 200
int visited[201] = {
    0,
};

queue<int> q;

void bfs(int cur, int n)
{
    q.push(cur);
     // 시작

    while (!q.empty())
    {   
        int curNode = q.front();
        visited[curNode] = 1;
        q.pop();
        for (int i = 1; i <= n; i++)
        {
            if (connected[curNode][i] == 1 && visited[i] == 0) // connected && not visited
            {
                q.push(i);
            }
        }
    }
}

int main()
{

    int N, M;
    int sol = 0;

    scanf("%d %d", &N, &M);

    for (int i = 0; i < M; i++)
    {
        int x, y;

        scanf("%d %d", &x, &y);

        //bidirection
        connected[x][y] = 1;        
        connected[y][x] = 1;
    }

    // printf("getInput Done");

    bfs(1, N);

    for (int i = 2; i <= N; i++) // visited == contagious, except for the first node.
    {
        if (visited[i] == 1)
            sol++;
    }

    printf("%d", sol);

    return 0;
}