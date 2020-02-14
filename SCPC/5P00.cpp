/*
    오르락 내리락
*/

#include <iostream>
#include <vector>

using namespace std;

int Answer;

int main(int argc, char** argv)
{
	int T, test_case;
	/*
	   The freopen function below opens input.txt file in read only mode, and afterward,
	   the program will read from input.txt file instead of standard(keyboard) input.
	   To test your program, you may save input data in input.txt file,
	   and use freopen function to read from the file when using cin function.
	   You may remove the comment symbols(//) in the below statement and use it.
	   Use #include<cstdio> or #include <stdio.h> to use the function in your program.
	   But before submission, you must remove the freopen function or rewrite comment symbols(//).
	 */	

	// freopen("input.txt", "r", stdin);

	cin >> T;
	for(test_case = 0; test_case  < T; test_case++)
	{

		Answer = 0;
		/////////////////////////////////////////////////////////////////////////////////////////////
		/*
		   Implement your algorithm here.
		   The answer to the case will be stored in variable Answer.
		 */
		int N1, N2;
		cin>> N1 >> N2;
		int opt[N2+1] = {0,};
		
		/*
		    i: odd
		        opt(i) = opt(i+1) + 1
		    i: even
		        opt(i) = opt(i/2) + 1
		*/
		
		if(N2>2){
    		opt[1] = 0;
    		opt[2] = 1;
    		opt[3] = 3;
    		opt[4] = 2;
    		
    		for(int i=3; i<=N2; i++) {
    		    if(i%2 == 1) {
    		        opt[i+1] = opt[(i+1)/2] + 1;
    		        opt[i] = opt[i+1] + 1;
    		    }
    		    
    		    if(N1<=i && i<=N2) Answer += opt[i];
    		}
		} else if(N2==2) {
		    Answer = 1; 
		} 

		
		/////////////////////////////////////////////////////////////////////////////////////////////
		for(int e: opt) printf("%d ", e);
		// Print the answer to standard output(screen).
		cout << "Case #" << test_case+1 << endl;
		cout << Answer << endl;
	}

	return 0;//Your program should return 0 on normal termination.
}