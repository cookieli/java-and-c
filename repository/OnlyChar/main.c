#include <stdio.h>
#include <stdlib.h>
#define   MAXLINE  1000
int Remove(char a[]);
int getLine(char s[],int lim);
int main()
{
    char line[MAXLINE];

    while( getLine(line,MAXLINE)>0){
      if( Remove(line) >0)
        printf("%s",line);
   }
}
int Remove(char a[])
{
  int i;
  for(i = 0 ; a[i]!='\n';i++);
  i--;
  while(i>0&&(a[i]=='\t'||a[i]==' '))
    i--;
  if(i>=0){
    i++;
    a[i] = '\n';
    i++;
    a[i] = '\0';
  }
  return i;
}
int getLine(char s[],int lim)
{
   int c ,i ;
   for(i = 0 ; i<lim-1&&(c = getchar())!=EOF&&c!='\n';i++)
    s[i] = c ;
    if(c =='\n'){
        s[i] = c ;
        i++;
    }
    s[i] = '\0';
    return i ;
}
