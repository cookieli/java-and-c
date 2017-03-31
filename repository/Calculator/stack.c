#include <stdio.h>
#include <stdlib.h>
#include<stack.h>
int sp = 0;/*next position in stack */
double val[MAXVAL];
void push(double f)
{
   if(sp < MAXVAL) val[sp++] = f ;
   else
    printf("stack is full");
}
double pop()
{
    if(sp > 0) return val[--sp];
    else{
        printf("stack is empty");
        return 0.0;
    }
}
void clear(void)
{
    sp = 0 ;
}
