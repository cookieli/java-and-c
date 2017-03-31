#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <buffer.h>
#include <ctype.h>
#include <string.h>


char buf[BUFSIZE];
int bufp = 0;

int getch(void)
{
    return (bufp > 0)? buf[--bufp]:getchar();
}
void ungetch(int c)
{
    if(bufp > BUFSIZE)
        printf("ungetch:too many characters\n");
    else
       buf[bufp++] = c ;
}
void ungets(char s[])
{
    int len = strlen(s);
    while(len>0)
        ungetch(s[--len]);
}
int getop(char s[])
{
    int i, c;
    static int lastic = 0;
    if(lastic == 0)  c = getchar();
    else {
        c = lastic ;
        lastic = 0;
    }
    while((s[0] = c )== ' '|| c == '\t'){
        c = getch();
    };
    s[1] = '\0';
    i = 0;
    if(islower(c)){
        while (islower(s[++i] = c = getch()));
        s[i] ='\0';
        if(c != EOF)
            lastic = c;
        if(strlen(s)>1)
            return NAME ;
        else
            return c;
    }
    if(!isdigit(c)&&c!='.'&&c!='-')
        return c ;
    if(c=='-'){
        if(isdigit(c = getch())||c == '.')
            s[++i] = c ;
        else if(c!=EOF){
            lastic = c;
            return '-';
        }
    }
    if(isdigit(c))
        while(isdigit(s[++i] = c = getch()));
    if(c =='.')
        while(isdigit(s[++i] = c = getch()));
    s[i] == '\0';
    if(c!=EOF)
        lastic = c;
    return NUMBER;

}
