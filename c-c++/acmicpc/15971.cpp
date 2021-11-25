/*
    두 로봇
    초등 정올
    Read the question carefully.
    It does't need 2D arr.
*/

#include <iostream>
#include <vector>
#include <list>

using namespace std;

/* int edge[5001][5001] = {0 }; //연결 여부와 길이
int visit[5001] = {0 }; //방문 여부 */

int n;
vector<vector<pair<int, int>>> connectWith;
vector<int> visited;

int result = 0;

void DFS(int a, int b, int sum, int checkMax)
{   
	visited[a] = 1;

    if(a==b) {
        result = sum - checkMax;
        // cout<< "goal" << endl;
    }
	// if(a==b) {    //base case
	// 	result = sum - checkMax;
	//
	// 	return;
	// }

    for(pair<int, int> n: connectWith[a]){
        if(visited[n.first]==0){
            int tempMax = checkMax;
            
            DFS(n.first, b, sum+n.second, checkMax<n.second ? n.second: checkMax);
        }
    }
	int tempSum = sum;

	/* for(int i=1; i<=n; i++){
		if(edge[a][i] != 0 && visit[i] == 0){

			int tempMax = checkMax;
			tempSum = sum + edge[a][i];
			if(checkMax < edge[a][i]) tempMax = edge[a][i];

            // printf("%d %d %d %d\n", a, i, tempSum, tempMax);

			if(i==b) result = tempSum - tempMax;
			DFS(i, b, tempSum, tempMax);
		}
	} */
}

int main()
{
    int a, b; //n은 노드 개수, a와 b는 로봇 위치
	scanf("%d %d %d", &n, &a, &b);
    connectWith.assign(n+1, vector<pair<int, int>>());
    visited.assign(n+1,0);
    
	for(int i=1; i<n; i++) {
		int x, y, l;

		scanf("%d %d %d", &x, &y, &l);

        connectWith[x].push_back(make_pair(y,l));
        connectWith[y].push_back(make_pair(x,l));
		// edge[x][y] = l; edge[y][x] = l;
	}
    // cout<<"input"<<endl;
	int checkMax = 0;
	int sum = 0;

	DFS(a, b, sum, checkMax);

	printf("%d", result);
    return 0;
}