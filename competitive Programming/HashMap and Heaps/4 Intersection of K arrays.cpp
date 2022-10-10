/*
        Method 1 -> using Binary search 
class Solution {
public:
    vector<int> intersection(vector<vector<int>>& arr) 
    {
        //1st sort all the element of the row ;
        int n = arr.size() ;
        for(int i = 0; i< n; i++)
        {
            sort(arr[i].begin() , arr[i].end()) ;
        }
        vector<int> ans ;
        
        // search first row element into all vectors ;
        for(int j = 0 ; j< arr[0].size() ; j++)
        {
            int cnt = 0;
            int x = arr[0][j] ; // get all element of an array ;
            for(int i = 0 ; i< n; i++)
            {
                if(binary_search(arr[i].begin() , arr[i].end() , x) == true)
                {
                    cnt++;
                }
            }
            if(cnt ==  n)
            {
                ans.push_back(x) ;
            }
        }
        return ans;
    }
    
};
*/
            // Method 2 Map
class Solution {
public:
    vector<int> intersection(vector<vector<int>>& arr) 
    {
        int n = arr.size(); int m = arr[0].size() ;
        unordered_map<int,int> mp;
        for(auto x : arr)
        {
            for(auto y : x)
            {
                mp[y]++;
            }
        }
    //if any of the element is present in all this means its frequency is equal to n         
        vector<int> ans ;
        for(auto it : mp)
        {
            if(it.second == n)
            {
                ans.push_back(it.first) ;
            }
        }
        sort(ans.begin() , ans.end()) ;
        return ans ;
    }
    
};

static int x=[](){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    return 0;
}();
