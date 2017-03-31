#include <stdio.h>
#include <stdlib.h>
#define  MAXCOL    10
#define  TABINC     8
char line[MAXCOL];
void printl(int pos);
int extab(int pos);
int findBlank(int pos);
int newpos(int pos);
int main()
{
   int c;
   int pos = 0;
   while((c = getchar())!=EOF){
        line[pos] = c;
      if(c =='\t') pos = extab(pos);
      else if(c =='\n'){
        printl(pos);
        pos = 0 ;
      } else if(++pos > MAXCOL){
          pos = findBlank(pos);
          printl(pos);
          pos = newpos(pos);
      }

   }
}
void printl(int pos)
{
  for(int i = 0 ; i < pos ; i++)
    putchar(line[i]);
   if(pos > 0 ) putchar('\n');
}
int extab(int pos)
{
    line[pos] = ' ';
    for(++pos ; pos < MAXCOL&&(pos%TABINC != 0) ; pos++){
        line[pos] = ' ';
    }
    if(pos < MAXCOL) return pos;
    else {
        printl(pos);
        return 0;
    }
}
int findBlank(int pos)
{
    while(pos > 0&& (line[pos]!=' '))
        pos--;
    if(pos == 0)      return MAXCOL;
    else              return pos+1;
}
int newpos(int pos)
{
  int i,j;
  if(pos<=0||pos > MAXCOL) return 0;
  i = 0 ;
  for(int j = pos ; j < MAXCOL ; j++){
    line[i] = line[j];
    i++;
  }
  return i ;
}

