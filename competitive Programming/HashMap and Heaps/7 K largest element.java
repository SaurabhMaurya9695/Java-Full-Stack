class Solution
{
    //Function to return k largest elements from an array.
    public static ArrayList<Integer> kLargest(int arr[], int n, int k)
    {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            if(i < k){
                q.add(arr[i]);
            } else if(q.peek() < arr[i]) {
                q.remove();
                q.add(arr[i]);
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        while(q.size() > 0){
            res.add(q.remove());
        }
        Collections.reverse(res);
        return res;
    }
        
}
// cpp code
class Solution
{
    public:
    //Function to return k largest elements from an array.
    vector<int> kLargest(int arr[], int n, int k)
    {
    priority_queue<int> maxheap;
    for(int i =0;i < n; i++)
    { 
        maxheap.push(arr[i]);
    }
    vector<int> ans;
    while(k--)
    {
        int x = maxheap.top();
        maxheap.pop();
        ans.push_back(x);
    }
    return ans ;
    }
        
    
};