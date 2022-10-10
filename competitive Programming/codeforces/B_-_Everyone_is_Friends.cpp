class Solution {
public:
    int hardestWorker(int n, vector<vector<int>>& logs) 
    {
        int temp = 0;
        int ans= 0;
        int val = 0 ;
        int nn = logs.size();
        for(int i = 0 ; i< n ; i++)
        {
            if(i > 0) {
                val = logs[i-1][1];
            }
            else{
                val = 0;
            }
            if(logs[i][1] - val  > temp)
            {
                ans = logs[i][0] ;
                temp = logs[i][1] - val;
            }
            else if(logs[i][1] - val == temp)
            {
                ans = min(ans , ans = logs[i][0] );
            }
        }
        return ans ;
    }

};