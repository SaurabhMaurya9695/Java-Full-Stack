// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    // create a class for marks
    class Marks{
        int phy, chem, maths;
        Marks(int phy, int chem, int maths){
            this.phy = phy;
            this.chem = chem;
            this.maths = maths;
        }
    }
    
    class MarksCmp implements Comparator<Marks>{
        public int compare(Marks s1, Marks s2){
            // writting our own comp first sort on physics , chemistry then
            // Maths
            if(s1.phy < s2.phy) return -1;
            else if(s1.phy > s2.phy) return +1;
            else {
                if(s1.chem < s2.chem) return +1;
                else if(s1.chem > s2.chem) return -1;
                else {
                    if(s1.maths < s2.maths) return -1;
                    return +1;
                }
            }
        }
    }
    
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        PriorityQueue<Marks> q = new PriorityQueue<>(new MarksCmp());
        
        for(int i=0; i<N; i++){
            Marks stud = new Marks(phy[i], chem[i], math[i]);
            q.add(stud);
        }
        
        int idx = 0;
        while(q.size() > 0){
            Marks stud = q.remove();
            phy[idx] = stud.phy;
            chem[idx] = stud.chem;
            math[idx] = stud.maths;
            idx++;
        }
    }
}


///////////////////////////////////////////////////////////////////


class Marks{
    
    public:
    
    int p;
    int c;
    int m;
    
    Marks(int p, int c, int m){
        this->p = p;
        this->c = c;
        this->m = m;
    }
    
};

bool cmp(Marks a,Marks b){
        
    if(a.p != b.p)
        return a.p < b.p;
    else if(a.p == b.p && a.c != b.c)
        return a.c > b.c;
    else if(a.c == b.c && a.m != b.m)
        return a.m < b.m;
    else
        return a.p < b.p;
    
}

class Solution{
    public:
    
    
    void customSort (int p[], int c[], int m[], int n)
    {
        vector<Marks> maks;
        
        for(int i = 0 ; i < n ; i++){
            
            Marks temp(p[i],c[i],m[i]);
            
            maks.push_back(temp);
            
        }
        
        sort(maks.begin(),maks.end(),cmp);
        
        for(int i = 0 ; i < n ; i++){
            
            p[i] = maks[i].p;
            c[i] = maks[i].c;
            m[i] = maks[i].m;
            
        }
        
    } 
};