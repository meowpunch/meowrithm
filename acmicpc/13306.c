//UNION FIND
#include <stdio.h>

int Find(int x);
void Union(int x, int y);
void Answer(int answer[], int size);
int parent[200001]; // The prospective parent
int connect[200001];

int main(){
   int nods, ques;
   int i, j;
   scanf("%d %d", &nods, &ques);


   parent[1] = 1;
   for(i=2; i<=nods; i++)
   {
      scanf("%d", &parent[i]);
      connect[i] = i;            //Once, connect the node with itself.
   }

   int Qsize = nods-1+ques;
   int query[Qsize][3];
   int answer[ques];

   for(i=0; i<Qsize; i++)       //Receive all questions before output
   {
      scanf("%d", &query[i][0]);
      if(query[i][0])
      {
         scanf("%d %d", &query[i][1], &query[i][2]);
      }
      else
      {
         scanf("%d", &query[i][1]);
      }
   }

    j = 1;
	for(i=Qsize-1; i>=0; i--)  //reverse
	{
		if(query[i][0])
		{
			if(Find(query[i][1]) == Find(query[i][2])) answer[ques-j] = 1;
			else answer[ques-j] = 0;
            j++;
		} else {
			Union(query[i][1],parent[(query[i][1])]); 	// Union the node with its parent.
		}
	}

    Answer(answer, ques);

    return 0;
}

int Find(int x){
    if(x == connect[x]){
        return x;
    }
    else {
        int temp = Find(connect[x]);
        connect[x] = temp;
        return temp;
    }
}

void Union(int x, int y){
    int x_parent = Find(x);
    int y_parent = Find(y);
    if(x_parent<y_parent) connect[y_parent] = x_parent;
    else connect[x_parent] = y_parent;
}

void Answer(int answer[], int size)
{
    for(int i=0; i<size; i++)
    {
        if(answer[i] == 1)printf("YES\n");
        else printf("NO\n");
    }
}
