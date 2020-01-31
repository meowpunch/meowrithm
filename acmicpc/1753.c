#include <stdio.h>

int inf = 2000000;
int Vnum, Enum;

int Map[20001][20001];
int Distance[20001];
int visit[20001] = {0,};


void Dijkstra(int v) {
    int i, j;
    int min, to;

    visit[v] = 1;  // v정점을 방문한다.

    min = inf;
    for(i=0; i<Vnum; i++) {
        if(visit[i] == 0) {
            Distance[i] = Map[v][i];
            if(Distance[i] < min){  //아직 방문되지 않은 정점중에 가까운 정점을 찾는다.
                min = Distance[i];
                v = i;
            }
        }
    }
}


int main() {
    int start;
    int i, j;

    scanf("%d %d", &Vnum, &Enum); // 첫줄: 정점과 간선 수
    scanf("%d", &start);          // 시작 노드

    for(i=0; i<Enum; i++) {       // 정점들이 연결되지 않은 것으로 초기화 (inf => 연결안됨)
        for(j=0; j<Enum; j++) {
            if(i!=j) Map[i][j] = inf;
        }
    }

    for(i=0; i<Enum; i++) {
        int from, to, weight = 0;
        scanf("%d %d %d", &from, &to, &weight);  // from -> to 로 가는 가중치(weigt)

        Map[from][to] = weight;
    }

    for(i=1; i<=Vnum; i++) Distance[Vnum] = inf;    //start 부터 Vnum까지 거리는 아직 알수없음

    Dijkstra();

    return 0;
}
