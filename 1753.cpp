#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

vector< pair<int, int>> map[20001];  //도착정점과 간선 길이


vector<int> Dijkstra(int S, int V, int E) {

    vector<int> dist(V, INT_MAX);
    dist[S] = 0;

    priority_queue< pair<int, int>> pq; //간선 길이

    pq.push(make_pair(0, S));

    while(pq.empty)



}




int main() {

    int Vnum, Enum;
    scanf("%d %d", &Vnum, &Enum);

    int start;
    scanf("%d", &start);

    int i,j;


    for(i=0; i<Enum; i++) {
        int from, to, weight;
        scanf("%d %d %d", &from, &to, weight);

        map[from].push_back(make_pair(to,weight));
    }

    vector<int> ans = Dijkstra(start, Vnum, Enum);

    return 0;
}

