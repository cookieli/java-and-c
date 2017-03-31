#include <stdio.h>
#include <stdlib.h>
#define   MAXLINE  1000
void reverse(char s[]);
int getLine(char s[],int lim);
int main()
{
    char line[MAXLINE];
    while(getLine(line,MAXLINE)>0){
      reverse(line);
      printf("%s",line);
    }
}
void reverse(char s[])
{
  int i = 0 , j =0;
  while(s[i]!='\0') i++;
  i--;
  if(s[i]=='\n') i--;
  while(i > j){
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp ;
    i--;
    j++;
  }
}
int getLine(char s[],int lim)
{
   int c ,i ;
   for(i = 0 ; i<lim-1&&(c = getchar())!=EOF&&c!='\n';i++)
    s[i] = c ;
    if(c == '\n'){
        s[i] = c ;
        i++;
    }
    s[i] = '\0';
    return i ;
}

