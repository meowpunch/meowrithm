#include <stdio.h>



int travel() {


}


 int main()
 {
     int s,g,H,i,j, result=0;
     scanf("%d %d %d", &s, &g, &H);
     int gg[s+1][g], ss[s][g+1];
     for(i=0; i<s+1; i++){
        for(j=0; j<g; j++) scanf("%d ", &gg[i][j]);
    }
     for(i=0; i<g+1; i++){
        for(j=0; j<s; j++) scanf("%d ", &ss[i][j]);
    }

    for(i=0; i<g; i++)
    {
       if(gg[0][i]!=-1 && gg[1][i]!=-1){
          if(gg[0][i] <= gg[1][i])  result+=gg[0][i];
          else result+=gg[1][i];
       }
       else if(gg[0][i]==-1 && gg[1][i]!=-1)result+=gg[1][i];
       else if(gg[0][i]!=-1 && gg[1][i]==-1)result+=gg[0][i];
       else result+=H;


       //result+=gg[1][i];
       //else if(gg[0][i] < gg[1][i] && (gg[0][i]!=-1 && gg[1][i]!=-1)) result+=gg[0][i];
    }
    printf("%d", result);

     return 0;
}
