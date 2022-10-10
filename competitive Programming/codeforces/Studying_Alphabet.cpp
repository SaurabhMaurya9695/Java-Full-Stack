#include<bits/stdc++.h>
using namespace std;
int main()
{
    string s;
    cin>> s;
    sort(s.begin(), s.end());
    int t;
    cin>> t;
    while(t--)
    {
        string temp;
        cin>> temp;
        sort(temp.begin() , temp.end());
        if(temp == s)
        {
            cout<< "Yes" << endl;
        }
        else{
            cout<<"No\n";
        }
    }
}