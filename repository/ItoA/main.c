#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
void Itoa(int n ,char s[]);
void reverse(char s[]);
int main()
{
   char s[] = "abcdefg";
   reverse(s);
   printf("%s",s);
}
void Itoa(int n ,char s[])
{
    static int i ;
    if(n/10)   Itoa(n/10,s);
    else  {
        i = 0 ;
        if(n < 0)
            s[i++] = '-';
    }
    s[i++] = abs(n)%10 + '0';
    s[i]   = '\0';
}
void reverse(char s[])
{
    void Lreverse(char s[],int lo ,int hi);
    int lo = 0 ;
    int hi = strlen(s) - 1 ;
    Lreverse(s,lo,hi) ;
}
void Lreverse(char s[],int lo ,int hi)
{
    void swap(char s[],int v,int w);
    if(lo > hi) return ;
    else {
        swap(s,lo,hi);
        Lreverse(s,lo+1,hi-1);
    }
}
void swap(char s[],int v,int w)
{
    char temp = s[v];
    s[v] = s[w];
    s[w] = temp;
}
