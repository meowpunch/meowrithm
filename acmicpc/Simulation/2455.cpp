#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<vector<int>> peo(4, vector<int>(2,0));
    for(int i=0; i<4; i++){
        scanf("%d %d", &peo[i][0], &peo[i][1]);
    }

    int max = 0;
    int total = 0;

    for(int i=0; i<4; i++){
        total -= peo[i][0];
        total += peo[i][1];
        if(total>max) max = total;
    }

    printf("%d", max);

    return 0;
}