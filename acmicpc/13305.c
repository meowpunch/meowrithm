#include <stdio.h>

int main() {

    int n;
    long long total=0;
    scanf("%d", &n);

    int edge[n-1];
    for(int i=0; i<n-1; i++) scanf("%d", &edge[i]);

    int lowCost = 1000000000;
    int curCost;
    for(int i=0; i<n-1; i++)
    {
        scanf("%d ", &curCost);
        if(lowCost>curCost)lowCost = curCost;

        total += (long long)lowCost*(long long)edge[i];
    }

    printf("%lld", total);
    return 0;
}
