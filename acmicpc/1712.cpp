#include <iostream>
#include <cmath>

int main() {
    
    double A,B,C;
    double sol;
    
    scanf("%lf %lf %lf", &A, &B, &C);
    
    if(B>=C) {
        printf("-1");
        return 0;
    }
    
    sol = ceil(A/(C-B));
    
    if(sol*C <= A + B*sol) sol += 1;
    
    printf("%d", int(sol));
    
    
    
    return 0;
}