#include <iostream>
#include <vector>

using namespace std;



int calOverlap(vector<int> a, vector<int> b) {
    //printf("%d %d vs %d %d\n", a[0],a[1],b[0],b[1]);

    if((a[0]-10 <= b[0] && b[0] <= a[0]) && (a[1]-10 <= b[1] && b[1] <= a[1])) { // 3
        // printf("hi3");
        return (b[0]+10 - a[0]) * (b[1]+10 - a[1]); 
    } else if((a[0]-10 <= b[0] && b[0] <= a[0]) && (a[1]+10 >= b[1] && b[1] >= a[1])) { //2
        // printf("hi2");
        return (b[0]+10 - a[0]) * (a[1]+10 - b[1]);
    } else if((a[0]+10 >= b[0] && b[0] >= a[0]) && (a[1]-10 <= b[1] && b[1] <= a[1])) { // 4
        // printf("hi4");
        return (a[0]+10 - b[0]) * (b[1]+10 - a[1]);
    } else if((a[0]+10 >= b[0] && b[0] >= a[0]) && (a[1]+10 >= b[1] && b[1] >= a[1])) { // 1
        // printf("hi1");
        return (a[0]+10 - b[0]) * (a[1]+10 - b[1]);
    }
    
    return 0;
}

int main() {
    
    int N;
    vector<vector<int>> v;
    int subSol = 0;

    scanf("%d", &N);
    v.assign(N, vector<int>(2));

    for(int i=0; i<N; i++){
        scanf("%d %d", &v[i][0], &v[i][1]); // Bottom left corner, and The side length is all 10.
    }

    for(int i=0; i<N; i++){
        for(int j=i+1; j<N; j++){
            // printf("%d \n", calOverlap(v[i], v[j]));
            subSol += calOverlap(v[i], v[j]);
        }
    }

    printf("%d", N*100 - subSol);



    return 0;
}