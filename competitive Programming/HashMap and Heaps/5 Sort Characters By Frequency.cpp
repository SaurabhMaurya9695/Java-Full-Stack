class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char , int> mp;
        for(int i = 0;i < s.size() ; i++)
        {
            mp[s[i]]++;  // insert into map
        }
        priority_queue<pair<int,char>> pq; // made a priority queue 
        for(auto it: mp)
        {
            pq.push({it.second , it.first}) ; // insert in pq on the basic of its value , max comes first
        }
        string str =""; // to store ans ;
       while(!pq.empty()) // extract untile pq gets empty() ;
        {
            int x = pq.top().first; 
            while(x != 0) // until its value become zero
            {
                str += pq.top().second; //no of times we added this
                x--;
            }
            pq.pop(); // and pop  that element from pq;
        }
        return str;
    }
};

static int x=[](){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    return 0;
}();