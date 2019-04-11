#include <iostream>
#include <vector>
#include <stack>
#include <queue>
using namespace std;

vector<int> dfsD;
vector<int> bfsD;
int a[1002][1002]={0,};
int ch[1002]={0,};
int ch2[1002]={0,};
//int count=0;

void dfs(int S, int N, int M){

   stack<int> stc;

    stc.push(S);
    int tmp;

    while(!stc.empty()){
    //  if(count==N) break;
      int top = stc.top();
      if(ch[top]==0){

            dfsD.push_back(top);
            ch[top]=1;
            //printf("%d ",stc.top());
            stc.pop();

            for(int i=N; i>0; i--){
                if(a[top][i]==1  && ch[i]==0)
                stc.push(i);
            }
      } else {
         stc.pop();
      }
    }
}

void bfs(int S, int N){
   int i, here;
   //ch2[S]=1;
   queue<int> que;
   que.push(S);
   //int count[N+1]={0,};

   while(!que.empty())
   {
      int front = que.front();
      if(ch2[front]==0){
           ch2[front]=1;
           //("%d", que.front());
           bfsD.push_back(front);
           que.pop();

          for(i=1; i<=N; i++)
          {
             //printf("%d", que.front());
             if(a[i][front]==1 && ch2[i]==0){
                 que.push(i);
             }
           }

      } else {
         que.pop();
      }


   }

}

int main() {
   int N, M, S, i;
   scanf("%d %d %d", &N, &M, &S);

   for(i=0; i<M; i++)
   {int b, c;
      scanf("%d %d", &b, &c);
      a[b][c]=a[c][b]=1;
      //if(i>0) a[i][i]=1;
   }


    dfs(S, N, M);
    for(i=0; i<dfsD.size(); i++)
      printf("%d ", dfsD[i]);

   printf("\n");

    bfs(S, N);
   for(i=0; i<bfsD.size(); i++)
      printf("%d ", bfsD[i]);

   return 0;
}
