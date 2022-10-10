// Problem link : https://practice.geeksforgeeks.org/problems/common-elements1132/1/#

#include <bits/stdc++.h>
using namespace std;


// Method 2 : get that element in one map whose frequency is 3
class Solution
{
    public:    
       vector <int> commonElements (int A[], int B[], int C[], int n1, int n2, int n3)
        {
            //code here.
            unordered_map<int,int> mp1 , mp2;
            for(int i = 0; i< n2 ; i++)
            {
                mp1[B[i]] ++ ;
            }
            for(int i = 0; i< n3 ; i++)
            {
                mp2[C[i]] ++ ;
            }
            vector<int> ans;
            for(int i = 0; i< n1 ; i++)
            {
                if( (mp1.find(A[i]) != mp1.end()) && (mp2.find(A[i]) != mp2.end()) )
                {
                    ans.push_back(A[i]) ;
                    mp1.erase(A[i]) ;
                    mp2.erase(A[i]) ;
                }
            }
            return ans ;
        }

};

