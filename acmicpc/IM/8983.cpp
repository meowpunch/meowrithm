#include <iostream>
#include <algorithm>

using namespace std;

int M;

int find(int X, int *M_loc){

  int start = 0;
  int end = M-1;
  int mid;
  //for(int i=0; i<M; i++) printf("%d ", M_loc[i]);
  while(start < end){
    mid = (start + end)/2;

    if(M_loc[mid] == X) return mid;
    else if(M_loc[mid] < X) {start = mid+1;}
    else {end = mid-1;}
  }

  return start;
}

int main() {
  int N, L;

  scanf("%d %d %d", &M, &N, &L);

  int M_loc[M];
  for(int i=0; i<M; i++) scanf("%d", &M_loc[i]);
  sort(M_loc, M_loc+M);

  int point = 0;

  for(int i=0; i<N; i++) {
    int x,y;
    scanf("%d %d", &x, &y);

    //find cloest M
    int closet = find(x, M_loc);

  //  printf("closet: %d", closet);
    if(abs(x-M_loc[closet]) + y <= L) { point++; continue; }
    if(closet+1<M && abs(x-M_loc[closet+1]) + y <= L) { point++; continue; }
    if(closet-1>-1 && abs(x-M_loc[closet-1]) + y <= L) { point++; continue; }
  //if(closet+2<M && abs(x-M_loc[closet+2]) + y <= L) { point++; continue; }
  //if(closet-2>-1 && abs(x-M_loc[closet-2]) + y <= L) { point++; continue; }
  //  printf("pass");

    // for(int j=0; j<M; j++) {
    //   if(abs(x-M_loc[j]) + y <= L) { point++; break; }
    // }
  }

  printf("%d", point);
  return 0;
}
