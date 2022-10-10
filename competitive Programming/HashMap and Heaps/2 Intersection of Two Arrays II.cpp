class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) 
    {
        unordered_map<int,int> mp ;
        for(int &x : nums1)
        {
            mp[x]++;
        }
        vector<int> ans;
        for(auto &it : nums2)
        {
            if(mp[it])  // if key is present them 
            {
                ans.push_back(it) ; // take it as a ans
                mp[it]--; // and decrese that freqency from that map;
            }
        }
        return ans ;
            
        
    }
};