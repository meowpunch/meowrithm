#include<stdio.h>
#include<string.h>
#include<memory.h>

int dp[1000001] = {0,};
int fibo(int n){
  if(n == 1){
    return 1;
  } else if(n==2){
      return 2;
  }else if(dp[n] != 0){ return dp[n]; }
  else {
      return dp[n] = (fibo(n - 1) + fibo(n - 2));
  }


}

int main(){
  int n;
  scanf("%d", &n);
  printf("%d\n", fibo(n)%15746);

  return 0;
}