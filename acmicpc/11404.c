// floyd warshall algorithm

#include <stdio.h>
int inf = 10000001;

int n,m;
int Map[101][101];
int Dist[101];

void input() {
    int i,j = 0;
    int from, to, weight = 0;

    scanf("%d", &n);
    scanf("%d", &m);

    for(i=1; i<=n; i++) {
        for(j=1; j<=n; j++) {
            if(i==j) Map[i][j] = 0;
            else Map[i][j] = inf;
        }
    }

    for(i=0; i<m; i++) {
        scanf("%d %d %d", &from, &to, &weight);
        Map[from][to] = (Map[from][to] > weight) ? weight : Map[from][to];
    }

    //for(i=1; i<=n; i++) Dist[i] = inf;
}

void algo(){

    int i,j,k;

    for(k=n; k>=1; k--) {
        for(i=1; i<=n; i++){
            for(j=1; j<=n; j++){
                //printf("%d->%d: %d  %d->%d->%d: %d\n", i,j,Map[i][j], i,k,j,Map[i][k] + Map[k][j]);
                if(Map[i][j] > Map[i][k] + Map[k][j]) Map[i][j] = Map[i][k] + Map[k][j];
            }
        }
    }
}

void print(){
    int i,j;

    for(i=1; i<=n; i++){
        for(j=1; j<=n; j++){
            if(Map[i][j] < inf) printf("%d ", Map[i][j]);
            else printf("0 ");
        }
        printf("\n");
    }
}

int main() {

    input();
    algo();
    print();

    return 0;
}
