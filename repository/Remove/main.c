#include <stdio.h>
#include <stdlib.h>
void rcomment(int c);
void in_comment();
int main()
{
   int c;
   while( (c = getchar())!= EOF){
     rcomment(c);
   }
}
/*remove the comment*/
void rcomment(int c)
{
    int d ;
    d = getchar();
    if(c=='/'){
      if(d =='*')  in_comment();
    else if(d == '/'){
            putchar(c);
            rcomment(d);
        }
    } else  {
        putchar(c);
        putchar(d);
    }

}
/*inside the comment to ignore*/
void in_comment()
{
    int c ,d;
    c = getchar();
    d = getchar();
    while(c!='*'||d!='/'){
        c = d ;
        d = getchar();
    }


}
