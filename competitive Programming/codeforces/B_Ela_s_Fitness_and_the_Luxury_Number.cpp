#include <bits/stdc++.h>
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")
using namespace std;
/*
 *    coder :: Saurabh Maurya
 *        >>> INDIA <<<
 */
#define sz(x) (int)(x).size()
#define ll long long
#define ff first
#define ss second
#define minheap priority_queue<long long, vector<long long>, greater<long long>>
#define endl "\n"
#define sort(a) sort(a.begin(), a.end())
#define sortarr(arr, n) sort(arr, arr + n);
#define rev(a) reverse(a.begin(), a.end())
#define fast                      \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);
#define pb push_back
#define PI 3.14159265358979323846
#define mod 1000000007
#define print(v)                       \
    for (int i = 0; i < v.size(); i++) \
    {                                  \
        cout << v[i] << " ";           \
    }
#define maxelement(nums) *max_element(nums.begin(), nums.end());
#define minelement(nums) *min_element(nums.begin(), nums.end());
#define py "YES"
#define pn "NO"

// movement in grid -> 2 d
int di[] = {+1, 0, 0, -1};
int dj[] = {0, -1, 1, 0};

// 8 directions
int dx[] = {1, 1, 0, -1, -1, -1, 0, 1};
int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};

template <class T>
vector<T> readvector(T n)
{
    vector<T> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    return arr;
}

template <typename T, typename T1>
T amax(T &a, T1 b)
{
    if (b > a)
        a = b;
    return a;
}
template <typename T, typename T1>
T amin(T &a, T1 b)
{
    if (b < a)
        a = b;
    return a;
}

// gcd
ll gcd(ll a, ll b) // TC = O(log n)
{
    if (b == 0)
    {
        return a;
    }
    else
    {
        return gcd(b, a % b);
    }
}

// fibonacci of nth no .
ll fib(ll n)
{
    double phi = (1 + sqrt(5)) / 2;
    return (ll)round(pow(phi, n) / sqrt(5));
}

// check whether the no is prime or not.
bool isPrime(int n)
{
    if (n <= 1)
        return false;
    if (n <= 3)
        return true;
    if (n % 2 == 0 || n % 3 == 0)
        return false;
    for (int i = 5; i * i <= n; i = i + 6)
    {
        if (n % i == 0 || n % (i + 2) == 0)
            return false;
    }
    return true;
}

int toconvert(int n, int d)
{
    int ans = 0;
    int cnt = 0, rem = 0;
    while (n != 0)
    {
        rem = n % d;
        int c = pow(10, cnt);
        ans += rem * c;
        n /= d;

        cnt++;
    }
    return ans;
}

int power(ll x, int n, int m = mod)
{
    ll res = 1;
    while (n > 0)
    {
        if (n & 1)
            res = (res * x) % m;
        x = (x * x) % m;
        n >>= 1;
    }
    return res;
}
int INV(int x, int m = mod)
{
    return power(x, m - 2, m);
}

bool isPalindrome(string S)
{
    for (int i = 0; i < S.length() / 2; i++)
    {
        if (S[i] != S[S.length() - i - 1])
        {
            return false;
        }
    }

    return true;
}

long long lcm(int a, int b)
{
    return (a / gcd(a, b)) * b;
}

bool sign(ll X)
{
    return abs(X) == X;
}
// c=134217727; always gives &with same no
// cout<<fixed<<setprecision(9)<<ans<<"\n";

// `````````````````````````````````````Code Begins`````````````````````````````````````````

ll giveSqrt(ll x){
    ll low = 1, high = 3e9, ans = 1;
 
    while(low<=high){
        ll mid = (low+high)/2;
 
        if(mid*mid<=x){
            ans = mid;
            low = mid+1;
        }
        else
            high = mid-1;
    }
 
    return ans;
}

void solve()
{
    ll l, r;
    cin >> l >> r;
    
    // try to show the pattern 
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16  17 18 19 20
    // 1 2 3 -> floor value of all squareroot is is 1 and divide all ; ans = 3
    // 4 5 6 7 8 -> floor value of all squareroot is 2 and it fully divide 4 ,6 ,8 => ans = 3;
    // 9 10 11 12 13 14 15 -> floor value of all squareroot is 3 and it fully divide 9 ,12 ,15 => ans = 3;
    // .
    // .
    // .
    // so on..
    // if the squareroot is 2 then its divisible value is -> 4 ,6 ,8;
    // for k -> (k * k ) , (k + 1) * k  , (k +  2) * k;
    // if(k) is lies in range of (k * k ) , (k + 1) * k  , (k +  2) * k; then we increment the cnt ;
    // in l to r , l has 3 squareroot if it has lies between l and r ;
    // and for rest of the middle element r - l - 1 has 3 ;
    ll leftsq = giveSqrt(l);
    ll rightsq = giveSqrt(r) ;
    ll midans = max({0ll, rightsq - leftsq - 1});
    // check for lies condition 
    ll leftans = 0;
    if(leftsq * leftsq  >=  l && leftsq * leftsq <= r )
    {
        leftans++;
    }
    if((leftsq + 1) * leftsq  >=  l && (leftsq + 1) * leftsq <= r )
    {
        leftans++;
    }
    if((leftsq +  2) * leftsq >=  l && (leftsq + 2) * leftsq <= r )
    {
        leftans++;
    }

    // and also check for right
    ll rightans = 0;
    if(leftsq != rightsq)
    {
        if(rightsq * rightsq  >= l && rightsq * rightsq <= r )
        {
            rightans++;
        }
        if((rightsq + 1) * rightsq  >= l && (rightsq + 1) * rightsq <= r )
        {
            rightans++;
        }
        if((rightsq +  2) * rightsq >= l && (rightsq + 2) * rightsq <= r )
        {
            rightans++;
        }
    }

    cout << leftans + rightans + midans * 3 << endl;
    return ;
    


}

int main()
{
    fast;
    ll t;
    cin >> t;
    while (t--)
    {
        solve();
    }

    // kicstart
    // for(int i =0; i < t ; i++)
    // {
    //     cout<<"Case #"<<i+1<<": ";
    //     solve();

    // }

    return 0;
}
