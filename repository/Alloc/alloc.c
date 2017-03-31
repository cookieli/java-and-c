#include <stdio.h>
#include <stdlib.h>
#define ALLOCISIZE  10000
static char allocbuf[ALLOCISIZE];
static char *allocp = allocbuf;
char *alloc(int n)
{
    if((allocbuf + ALLOCISIZE - allocp) > n){
        allocp += n;
    return allocp - n ;
    } else
        return 0 ;
}
void afree(char *p)
{
    if(p>=allocbuf&&p<allocbuf + ALLOCISIZE)
        allocp = p ;
}
