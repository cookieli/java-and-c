#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAXLINE   1000
int Getline(char *s,int lim);
int main(int argc , char *argv[])
{
  char line[MAXLINE];
  int found = 0;
  if(argc != 2)
    printf("Usage: find pattern\n");
  else
    while(Getline(line , MAXLINE) > 0)
      if(strstr(line ,argv[1])!=NULL){
        printf("%s",line);
        found ++;
      }
      return found ;
}
int Getline(char *s,int lim)
{
    int c;
    char *p = s;
    while(--lim > 0&&(c = getchar())!=EOF&&c!='\n')
        *s++ = c;
    if(*s == '\n')
        s++;
    *s == '\0';
    return s - p;
}
