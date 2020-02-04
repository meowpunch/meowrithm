/*
    색종이
    유형: 구현

    solve overlap problem by coloring
*/

#include <iostream>
#include <vector>

using namespace std;

int N;
vector<vector<int>> rec;
vector<vector<int>> space;

void coloring(int x, int y) {

    for(int i=0; i<10; i++) {
        for(int j=0; j<10; j++){
            space[x+i][y+j] = 1;
        }
    }
}

int main() {

    scanf("%d", &N);
    rec.assign(N, vector<int>(2, 0));
    space.assign(101, vector<int>(101,0));

    for(int i=0; i<N; i++){
        scanf("%d %d", &rec[i][0], &rec[i][1]); // Bottom left corner, and The side length is all 10.
    }

    for(int i=0; i<N; i++){
        coloring(rec[i][0], rec[i][1]);
    }

    int count = 0;
    for(vector<int> e: space)
    {   
        for(int l: e)if(l == 1) count++;
    }

    printf("%d", count);
    

    return 0;
}



/* int calOverlap(vector<int> a, vector<int> b) {
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
} */