#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
}
unsigned setbits(unsigned x,int p,int n,unsigned y)
{
    return x&~(~(~0<<n)<<(p-n+1))|(~(~0<<n)&y<<(p-n+1);
}
unsigned invert(unsigned x,int p,int n)
{
    return x^(~(~0<<n)<<(p-n+1));

}
unsigned rightrot(unsigned x , int n)
{
    int wordlength();
    int rbit;
    while(n-->0)
    {
        rbit = (x&1)<<(wordlength()-1);
        x = x>>1;
        x = x|rbit;
    }
    return x;
}
unsigned rightrott(unsigned x,int n)
{
    int wordlength();
    int rbit;
    if((n=n%wordlength())>0){
        rbit = ~(~0<<n)&x ;
        rbit = rbit<<(wordlength - n);
        x = x>> n;
        x = x|rbit;
    }
    return x;
}
/* computes word length of the machine*/
int wordlength()
{
    int i;
    unsigned v = (unsigned)~0;
    for(i = 1 ; (v = v>>1)>0 ; i++);
    return i;
}
int lower(int c)
{

}
