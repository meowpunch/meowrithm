//다익스트라

#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

vector< pair<int, int>> map[20001];  //도착정점과 간선 길이

vector<int> Dijkstra(int S, int V, int E) {

    vector<int> dist(V+1, INT_MAX);
    //vector<int> visit(V+1, 0);
    dist[S] = 0;

    priority_queue<pair<int, int>> pq; //간선 길이, 도착 정점

    pq.push(make_pair(0, S));

    while(!(pq.empty())) {
        int hereDis = -pq.top().first;  //갈수있는 정점중 시작점으로부터 가장 짧은 길이를 택함.
        int here = pq.top().second;     //현재 정점

        pq.pop();
        if(hereDis > dist[here]) continue;

        for(int i=0; i<map[here].size(); i++) { //현재 정점에 edge 모두 확인
            int next = map[here][i].first;
            int nextDis = dist[here] + map[here][i].second;

            if(dist[next] > nextDis) {
                dist[next] = nextDis; //최단거리 갱신
                pq.push(make_pair(-nextDis, next));
                }
            }
    }
    return dist;
}

int main() {

    int Vnum, Enum;
    scanf("%d %d", &Vnum, &Enum);

    int start;
    scanf("%d", &start);

    for(int i=0; i<Enum; i++) {
        int from, to, weight;
        scanf("%d %d %d", &from, &to, &weight);

        map[from].push_back(make_pair(to,weight));
    }

    vector<int> ans = Dijkstra(start, Vnum, Enum);

    for(int i=1; i<ans.size(); i++){
        if(ans[i]<INT_MAX) printf("%d\n", ans[i]);
        else printf("INF\n");
    }
    return 0;
}
