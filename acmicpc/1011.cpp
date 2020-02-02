#include <iostream>

int flag = 0;

// DFS with recursive function.
void calMinMove(int x, int y, int mov, int sol) {
    if(x==y && mov==1) {
        printf("%d\n", sol);
        flag = 1;
        return;
    }else if(flag == 1 || x>y || mov<0) return;

    calMinMove(x+mov+1, y, mov+1, sol+1);
    calMinMove(x+mov, y, mov, sol+1);
    calMinMove(x+mov-1, y, mov-1, sol+1);
}

int main() {
    
    int T;
    scanf("%d", &T);

    for(int i=0; i<T; i++) {
        int x, y;
        scanf("%d %d", &x, &y);
        calMinMove(x+1, y, 1, 1);
        flag = 0;
    }

    return 0;
}