/*
    오르락 내리락
    
    acmicpc
    1463 DP + sum DP
*/

#include <iostream>
#include <vector>

using namespace std;

int Answer;

int main(int argc, char** argv)
{
	int T, test_case;

	vector<int> opt(1000001,0);
	vector<int> sum(1000001,0);
	opt[1] = 0;
	opt[2] = 1;
	
	sum[1] = 0;
	sum[2] = 1;
	
	for(int i=2; i<1000001; i++) {
	    if(i%2 == 1) {
	        opt[i+1] = opt[(i+1)/2] + 1;
	        opt[i] = opt[i+1] + 1;
	        sum[i] += sum[i-1] + opt[i];
	        sum[i+1] += sum[i] + opt[i+1];
	    }
	}

	cin >> T;
	for(test_case = 0; test_case  < T; test_case++)
	{   
        int N1,N2;
	    cin>> N1 >> N2;
	    
		Answer = sum[N2] - sum[N1-1];
	   
		cout << "Case #" << test_case+1 << '\n';
		cout << Answer << '\n';
	}

	return 0;
}
