#include <iostream>
#include <cmath>

int main() {
    
    int N, sol;
    
    scanf("%d", &N);
    
    N = N/6;
    
    // sol*(sol+1)/2 = N;
    // sol^2 + sol - 2N = 0;
    
    sol = (-1 + sqrt(1+8*N))/2;
        
    printf("%d", sol);
    
    
    return 0;
}