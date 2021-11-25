//SORTING

/* 버블정렬 시간초과.
#include <stdio.h>
#include <vector>

using namespace std;

int main() {

    int N;
    scanf("%d", &N);

    vector<int> a;
    int i;
    for(i=0; i<N; i++){int m; scanf("%d", &m); a.push_back(m);}

    int j;
    for(i=0; i<N; i++){
        for(j=0; j<N; j++){
            if(a[i] < a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
    }

    for(i=0; i<N; i++)printf("%d\n", a[i]);

    return 0;
}
*/

// 합병정렬 굿
