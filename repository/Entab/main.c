#include <stdio.h>
#include <stdlib.h>
#define TABINC  8
int main()
{
  int pos  ;
  int nb  = 0 ;
  int nt  = 0 ;
  int c;
  for(pos = 1 ; (c =getchar())!=EOF ; pos++)
  {
      if(c == ' ') {
        if(pos%TABINC != 0) {
            nb++;
        } else {
            nt++;
            nb = 0;
        }
      } else {
          for( ;nt > 0 ; nt--)
            putchar('\t');
          if(c == '\t') nb = 0;
          else
            for( ; nb > 0 ; nb --) putchar(' ');
             putchar(c);
             if(c == '\n') pos = 0 ;
             else if( c == '\t')
                pos = pos +(TABINC - (pos-1)%TABINC) - 1 ;

      }
  }
}
