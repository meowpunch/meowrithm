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
        for(int j=i;j<N;j++) {
            for(int k=j;k<N;k++) {
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