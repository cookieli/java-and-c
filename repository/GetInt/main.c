#include <stdio.h>
#include <stdlib.h>
#include <buffer.h>
#include <ctype.h>
#define   SIZE    10
int main()
{
    int n , getint(int *),getfloat(float *);
    float array[10];
    for(n = 0 ; n < SIZE&&getfloat(&array[n])!=EOF ; n++) ;
   // for(int i = 0 ; i < SIZE ;i++)
        printf("%f , ",array[0]);
}
int getint(int *pn)
{
    int c ,sign,d;
    /*skip white space*/
    while(isspace(c = getch()));
    if(!isdigit(c)&&c!=EOF&&c!='+'&&c!='-'){
        ungetch(c);
        return 0;
    }
    sign = (c=='-')?-1 : 1;
    if(c == '+'||c=='-') {
        d = c ;
        if(!isdigit(c= getch())){
            if(c!=EOF)
                ungetch(c);
            ungetch(d);
            return d;
        }
    }
    for(*pn = 0 ; isdigit(c) ; c = getch())
        *pn = 10*(*pn) +(c-'0');
    *pn *= sign;
    if(c!=EOF)
        ungetch(c);
    return c ;
}
int getfloat(float *pf)
{
    int c ,sign ;
    double power;
    power = 1.0;
    while(isspace(c = getch()));
    if(!isdigit(c)&&c!=EOF&&c=='+'&&c=='-'){
        ungetch(c);
        return 0;
    }
    sign = (c == '-')?-1:1;
    if(c=='-'||c=='+')
        c = getch();
    for(*pf = 0 ; isdigit(c); c = getch())
        *pf =10.0* (*pf) + (c -'0');
    if(c == '.')
        c = getch();
    for( ; isdigit(c) ; c = getch()){
        *pf = 10.0* (*pf) + (c - '0');
        power *= 10.0;
    }
        *pf/=power;
        *pf *= sign ;
    if(c!=EOF)
        ungetch(c);
    return c;

}
