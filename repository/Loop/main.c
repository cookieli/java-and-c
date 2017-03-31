#include <stdio.h>
#include <stdlib.h>

int main()
{
  enum loop{NO,YES};
  enum loop okloop = YES;
  int i = 0 ;
  int c;
  int lim =10;
  while(okloop == YES)
  {
      if( i > lim - 1)                 okloop = NO;
      else if(( c = getchar())== '\n') okloop = NO;
      else if(c == EOF)                okloop = NO;
      else{
        i++;

      }
  }
}
