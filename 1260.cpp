//DFS BFS

#include <iostream>
#include <stack>
#include <queue>

int map[1001][1001];


vector<int> DFS() {


}

int main() {

  int N, M, V;

  scnaf("%d %d %d", &N, &M, &V);

  int i;
  for(i=0; i<M; i++) {
    int from, to, weight;
    map[from][to] = weight; map[to][from] = weight;
  }

  DFS(V);


  return 0;
}
