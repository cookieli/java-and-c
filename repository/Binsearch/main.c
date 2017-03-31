#include <stdio.h>
#include <stdlib.h>
int  binsearch(int x,int v[],int n);
int main()
{
   int a[10];
   for(int i = 0 ; i < 10 ; i++){
      a[i] = i;
   }
   printf("%d",binsearch(5,a,10));
}
int  binsearch(int x,int v[],int n)
{
    int lo,mid,hi;
    hi = n - 1;
    lo = 0 ;
    while(lo < hi){
    mid = lo +(hi-lo)/2;
        if(x > v[mid])           lo = mid +1;
        else if(x < v[mid - 1])  hi = mid -1;
        else                    return mid;
    }
    return -1;
}
