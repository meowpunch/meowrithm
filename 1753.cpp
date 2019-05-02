//다익스트라

#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

vector< pair<int, int>> map[20001];  //도착정점과 간선 길이

vector<int> Dijkstra(int S, int V, int E) {

    vector<int> dist(V+1, INT_MAX);
    vector<int> visit(V+1, 0);
    dist[S] = 0;

    priority_queue<pair<int, int>> pq; //간선 길이, 도착 정점

    pq.push(make_pair(0, S));

    while(!(pq.empty())) {
        int weight = pq.top().first; //가장 짧은 길이 선택
        int top = pq.top().second;

        if(visit[top] == 0){  //방문안했다면 방문.
            //printf("visit %d\n", top);
            pq.pop();
            visit[top] = 1;
            //printf("hi");
            for(int i=0; i<map[top].size(); i++) {
                int to = map[top][i].first;
                //printf("connected: %d \n", to);
                int edge = map[top][i].second;

                if(dist[to] > dist[top] + edge) dist[to] = dist[top] + edge;

                pq.push(make_pair(-edge, to));
                //printf("push %d \n", to);
            }
        } else {
            pq.pop();
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
