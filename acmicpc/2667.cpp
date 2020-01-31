// flood fill, dfs
#include <iostream>
#include <queue>

using namespace std;

int map[25][25] = {0, };
priority_queue<int, vector<int>, greater<int>> pq;
int count;
int N;

void FF(int x, int y){
    //printf("x:%d y:%d map:%d \n", x,y,map[x][y]);
    if(map[x][y] == 1) {
        count++;
        map[x][y] = 0;
        if(x+1<N)FF(x+1, y);
        if(x-1>-1)FF(x-1, y);
        if(y+1<N)FF(x, y+1);
        if(y-1>-1)FF(x, y-1);
    }
}
int main() {

    scanf("%d", &N);

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            scanf("%1d", &map[i][j]);
        }
    }
    // 배열 인덱스 접근 연습
    // int a[3] = {0,};
    // a[3] =1;
    // printf("%d %d %d", a[-1], a[2], a[3]);

    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            if(map[i][j] == 1) {
                count = 0;
                FF(i,j);
                //printf("count: %d\n", count);
                pq.push(count);
            }
        }
    }

    printf("%d\n", pq.size());
    while(!pq.empty()){
        printf("%d\n", pq.top());
        pq.pop();
    }

    return 0;
}
