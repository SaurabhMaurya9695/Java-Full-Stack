#include <bits/stdc++.h>

/************************************ policy base data structure*****************/

// #include <ext/pb_ds/assoc_container.hpp> // Common file
// #include <ext/pb_ds/tree_policy.hpp> // Including tree_order_statistics_node_update
// #include <ext/pb_ds/detail/standard_policies.hpp>

// Pragmas
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")

/************************************ policy base data structure*****************/
using namespace std;
// using namespace __gnu_pbds;

/*
 *    coder :: Saurabh Maurya
 *        >>> INDIA <<<
 */
#define all(x) (x).begin(), (x).end()
#define sz(x) (int)((x).size())
#define ll long long
#define ff first
#define ss second
#define ook order_of_key
#define fbo find_by_order
#define minheap priority_queue<long long, vector<long long>, greater<long long>>
#define endl "\n"
#define sort(a) sort(a.begin(), a.end())
#define sortarr(arr, n) sort(arr, arr + n);
#define sortdesc(a) sort(a.begin(), a.end(), greator<int>())
#define rev(a) reverse(a.begin(), a.end())
#define fast                      \
    ios_base::sync_with_stdio(0); \
    cin.tie(0);                   \
    cout.tie(0);
#define pb push_back
#define PI 3.14159265358979323846
#define mod 1000000007
#define inf numeric_limits<int>::min();
#define print(v)                       \
    for (int i = 0; i < v.size(); i++) \
    {                                  \
        cout << v[i] << " ";           \
    }

#define maxelement(nums) *max_element(nums.begin(), nums.end());
#define minelement(nums) *min_element(nums.begin(), nums.end());

// movement in grid -> 2 d
int di[] = {+1, 0, 0, -1};
int dj[] = {0, -1, 1, 0};

// 8 directions
int dx[] = {1, 1, 0, -1, -1, -1, 0, 1};
int dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
// int  p = 1000000007;
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

/********************* template of PBDS ************/
// template < class T > using oset = tree< T , null_type, less  < T  > , rb_tree_tag , tree_order_statistics_node_update > ;
// oset< int > tree ;
// tree.ook ( val  )  return index of element ;
// tree.fbo ( idx )   return pointer at the element .

// typedef tree< pair<int,int>  , null_type, less  < pair<int,int>  > , rb_tree_tag ,
//  tree_order_statistics_node_update > PBDS;

// factorial

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

int modpow(ll x, int n, int m = mod)
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
int modinv(int x, int m = mod)
{
    return modpow(x, m - 2, m);
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

// Don't forget to include and check test case
// islower(s[i])
bool issorted(vector<int> arr)
{
    vector<int> temp = arr;
    sort(temp);
    if (temp == arr)
    {
        return true;
    }
    else
    {
        return false;
    }
}

long long lcm(int a, int b)
{
    return (a / gcd(a, b)) * b;
}

vector<vector<int>> readGraph(int N, int M)
{
    vector<vector<int>> g(N);
    for (int i = 0; i < M; i++)
    {
        int u, v;
        cin >> u >> v;
        --u, --v;
        g[u].push_back(v);
        g[v].push_back(u);
    }
    return g;
}
vector<vector<vector<int>>> readGraphWithWeight(int N, int M)
{
    vector<vector<vector<int>>> g(N);
    for (int i = 0; i < M; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        --u, --v;
        g[u].push_back({v, w});
        g[v].push_back({u, w});
    }
    return g;
}

// c=134217727; always gives &with same no
// cout<<fixed<<setprecision(9)<<ans<<"\n";

// start from here
bool sign(ll X)
{
    return abs(X) == X;
}

void solve()
{
    ll n;
    cin >> n;
    vector<ll> arr = readvector(n);
    ll temp = arr[0];
    ll sum = 0;
    for (int i = 1; i < n; i++)
    {
        if (sign(arr[i]) != sign(temp)) // as question says take the opposit consi elem
        {
            sum += temp;
            temp = arr[i];
        }
        // if the sign same then take max of two ;
        temp = max(temp, arr[i]);
    }
    cout << sum + temp << endl;
    return;
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
