// bfs
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int level[100001] = {0, };  //방문을 체크하기도 하고 몇번째 움직임인지 체크해주기도 한다.

int bfs(int C, int D){  // C: Current location  D: Destination

    queue<int> que;
    que.push(C);
    level[C] = 1;

    while(!que.empty())
    {
        int node = que.front();
        //printf("%d level: %d check: %d\n", que.front(), level[que.front()], check[que.front()]);
        if(node == D) return level[node] - 1;

        que.pop();

        //printf("%d", que.front());
        // 조건문 이부분 순서 바꾸면 런타임 에러남 <= short circuit evaluation 정책을 취하기 때문
        if(node*2<100001 && level[node*2]==0) {
            level[node*2] = level[node] + 1;
            que.push(node*2);
        }
        if(-1<node-1 && level[node-1]==0) {
            level[node-1] = level[node] + 1;
            que.push(node-1);
        }
        if(node+1<100001 && level[node+1]==0 ) {
            level[node+1] = level[node] + 1;
            que.push(node+1);
        }
    }
}

int main() {

    int N, K;   //  N: 수빈이 위치, K: 동생의 위치
    scanf("%d %d", &N, &K);

    // N는 시작점, K는 목적지라고 생각할 수 있다.
    printf("%d", bfs(N, K));
    return 0;
}
