#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> v;


int main() {

    int N,M;

    int sol=-1;
    int minV = 10000000;

    scanf("%d %d", &N, &M);

    for(int i=0; i<N; i++) {
        int input;
        scanf("%d", &input);
        
        v.push_back(input);
    }

    for(int i=0;i<N;i++) {
        for(int j=i+1;j<N;j++) {    // i+1, j+1 for avoiding i,j,k have same value.
            for(int k=j+1;k<N;k++) {
                int sum = v[i]+v[j]+v[k];
                int sub = M-sum;
                if (sub >= 0 && sub < minV) {
                    minV = sub;
                    sol = sum;
                }
            }
        }
    }

    printf("%d", sol);

    return 0;
}