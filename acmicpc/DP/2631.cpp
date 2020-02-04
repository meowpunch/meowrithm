/* 
    줄세우기 
*/

#include <iostream>
#include <vector>

using namespace std;

int N;
vector<int> seq;
vector<int> mem;
// OPT(i) is the lenght of the longest increasing subsquence ending at i

// find the lenght of the longest increasing subsquence
int findLIS()
{
    int length = 0;

    mem[0] = 1;

    for (int i = 1; i < N; i++)
    {   
        int max = -1;
        for (int j = i - 1; j < i; j++)
        {   
            if (seq[j] < mem[i] && mem[j] > max)
            {
                max = mem[j];
            }
        }

        if(max == -1) {
            mem[i] = 1;
        } else mem[i] = max + 1;
    }

    for(int i=0;i<N;i++) {
        if(length<mem[i])length = mem[i];
    }

    return length;
}

int main()
{
    scanf("%d", &N);

    for (int i = 0; i < N; i++)
    {
        int x;
        scanf("%d", &x);
        seq.push_back(x);
    }

    mem.assign(N, -1);

    printf("%d\n", findLIS());
    return 0;
}