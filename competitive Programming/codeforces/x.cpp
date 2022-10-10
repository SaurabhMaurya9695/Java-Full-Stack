#include<bits/stdc++.h>
using namespace std;

vector<string> solve(vector<string> a , vector<string> b , vector<string> c)
{
    int x1 = a[0] - '0' ;
    int x2 = b[0] - '0' ;
    int x3 = c[0] - '0' ;
    int y1 = a[1] - '0' ;
    int y2 = b[1] - '0' ;
    int y3 = c[1] - '0' ;

    float x4 , y4 ;
    x4 = (x1 + x2 + x3) / 3 ;
    y4 = (y1 + y2 + y3) / 3 ;

    return {to_string(x4) , to_string(y4)}; 
}

int main()
{
     
}