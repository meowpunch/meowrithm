//Knuth–Morris–Pratt(KMP) 알고리즘

#include <iostream>
#include <string.h>
#include <cstdio>
#include <vector>
using namespace std;

vector<int> result;
char T[1000000];
char P[1000000];
int j=0, i, k=0;


void failure(int pi[]){

    i=1, j=0;

    pi[0] = 0;
    while(i<strlen(P)){
        if(P[i] == P[j]){
            pi[i] = j+1;
            j++;
            i++;
        } else if(j>0) {
            j = pi[j - 1];
        } else {
            pi[i] = 0;
            i++;
        }
    }
}

void kmp(int pi[]){

    i=0; j=0;

    while(i<strlen(T)){
        if(T[i]==P[j]){
            if(j==strlen(P)-1) {result.push_back(i-j+1); j = pi[j]; i++;}
            else i++, j++;
        } else {
            if(j>0) j = pi[j-1];
            else i++;
        }
    }
}


int main() {

   scanf("%s", T);
   scanf("%s", P);

   //printf("%s %s   %d %d \n", T, P, strlen(T), strlen(P));

   int pi[strlen(P)];
   failure(pi);

   // for(i=0; i<P.size(); i++) cout << pi[i] << " ";
   // cout << "\n";

   kmp(pi);

   cout << result.size() << "\n";
   for(i=0; i<result.size(); i++)
   {
      cout << result[i] << "\n";
   }

   return 0;
}



/*
#include <iostream>
#include <string>
#include <cstdio>
#include <vector>
using namespace std;

vector<int> result;
int res=0;
string T;
string P;
int j=0, i, k=0;


void failure(int pi[]){

    i=1, j=0;

    pi[0] = 0;
    while(i<P.size()){
        if(P[i] == P[j]){
            pi[i] = j+1;
            j++;
            i++;
        } else if(j>0) {
            j = pi[j - 1];
        } else {
            pi[i] = 0;
            i++;
        }
    }
}

void kmp(int pi[]){

    i=0; j=0;

    while(i<T.size()){\
        if(T[i]==P[j]){
            if(j==P.size()-1) {res++; result.push_back(i-j+1); j = pi[j]; i++;}
            else i++, j++;
        } else {
            if(j>0) j = pi[j-1];
            else i++;
        }
    }
}


int main() {

   getline(cin, T);
   getline(cin, P);

   // cout << T << endl;
   // cout << P << endl;

   int pi[P.size()];
   failure(pi);

   // for(i=0; i<P.size(); i++) cout << pi[i] << " ";
   // cout << "\n";

   kmp(pi);

   cout << res << "\n";
   for(i=0; i<res; i++)
   {
      cout << result[i] << "\n";
   }

   return 0;
}
*/
