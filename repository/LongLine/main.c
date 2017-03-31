#include <stdio.h>
#include <stdlib.h>
#define  LONGLINE   10
#define  MAXLINE    1000
int getLine(char s[],int lim);

int main()
{
    char line[MAXLINE];
    int len ;
    while((len = getLine(line,MAXLINE))!=0){
        if(len > LONGLINE) printf("%s",line);
    }
}
int getLine(char s[],int lim)
{
   int c ,i ;
   for(i = 0 ; i<lim-1&&(c = getchar())!=EOF&&c!='\n';i++)
    s[i] = c ;
    if(c = '\n'){
        s[i] = c ;
        i++;
    }
    s[i] = '\0';
    return i ;
}
