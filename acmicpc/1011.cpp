#include <iostream>
#include <stack>
#include <cmath>

using namespace std;

// DFS with recursive function. => time out

/* int flag = 0;
void calMinMove(int x, int y, int mov, int sol) {
    // printf("%d %d %d %d\n", x,y,mov,sol);
    if(x==y && mov==1) {
        // printf("%d %d %d %d\n", x,y,mov,sol);
        printf("%d\n", sol);
        flag = 1;
        return;
    }else if(flag == 1 || x>y || mov<=0) return;

    calMinMove(x+mov+1, y, mov+1, sol+1);
    calMinMove(x+mov, y, mov, sol+1);
    calMinMove(x+mov-1, y, mov-1, sol+1);
} */


// Advanced Algorithm 

void calMinMove(int strNode, int endNode) {

    int mov = 1;
    int count = 0;

    /* while(strNode + mov*(mov+1)/2 + mov*(mov-1)/2 <= endNode) {
        mov++;
    } */

    mov = sqrt(endNode - strNode);
    
    // mov -= 1;
    count += 2*mov-1;
    int curNode = strNode + mov*(mov+1)/2 + mov*(mov-1)/2;
    int gap = endNode - curNode;

    printf("%d %d %d %d\n", mov, curNode, gap, count);

    int i=0;
    while(mov*i<gap){
        i++;
    }
    count += i;

    printf("%d\n", count);
   
}


int main() {
    
    int T;
    scanf("%d", &T);

    for(int i=0; i<T; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        calMinMove(x, y);
        // flag = 0;
    }

    return 0;
}