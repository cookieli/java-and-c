#include <stdio.h>
#include <stdlib.h>
#define TABINC  8

int main()
{
    int c;
    int nb,pos;
    pos = 1;
    nb  = 0;
    while((c = getchar())!=EOF){
        if(c =='\t') {
            nb = TABINC - (pos-1)%TABINC;
            while(nb > 0) {
                putchar(' ');
                nb--;
                pos++;
            }
        }else if( c == '\n') {
            putchar(c);
            pos = 1 ;
        } else{
            putchar(c);
            pos++;
        }
    }
}
