/*
    달팽이는 올라가고 싶다
*/

#include <iostream>
#include <vector>

using namespace std;

int main() {
    
    long long A,B,V;

    scanf("%lld %lld %lld", &A, &B, &V);
    long long count = 0;

    // maybe time complexity O(logn),,, Why TLE?
    while(1){
        cout<< V << count << endl;
        if(V/A == 0 || (V/A == 1 && V%A == 0)) {
            count++;
            break;
        } 
        count += V/A;
        V = V%A + (V/A)*B;
    }

    /* count++;
    V -= A;

    int gap = A-B;

    count += V/gap;

    if(V%gap != 0) count ++; */
   

    printf("%lld", count);
    return 0;
}