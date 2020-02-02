/* 
    설탕 배달
    알고리즘 분류: 구현, 수학 
*/

#include <iostream>

int main() {
    
    int N, sol, rem;
    sol = 0;
    
    int M[5000];
    
    scanf("%d", &N);
    
    if( N==1 || N==2 || N==4 || N==7) {
        printf("-1");
        return 0;
    }
    
    sol += N/5;
    rem = N%5;
    
    sol += rem/3;
    
    if(rem%3 == 1){
        sol += 1;
    } else if(rem%3 == 2){
        sol += 2;
    }
    
    printf("%d", sol);
    
    return 0;
}