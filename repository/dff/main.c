#include <stdio.h>
#include <stdlib.h>
#define IN           1
#define OUT          0
#define MAXWORD      11
#define MAXHIST      15
main()
{
   int c,state,nc,overlength;
   int maxvalue;
   int len ;
   int wl[MAXWORD];
   for(int i = 0 ; i < MAXWORD ;i++)
    wl[i] = 0;
    state = OUT;
    nc = 0 ;
    overlength = 0;
   while((c = getchar())!=EOF){
    if(c=='\n'||c=='\t'||c==' '){
        state = OUT;
        if(nc > 0 ){
            if(nc <MAXWORD) wl[nc]++;
            else        overlength++;
        }
    //        nc = 0 ;
    }
    else if(state == OUT){
           state = IN;
           nc = 1;
    }
    else  nc++;
   }
   maxvalue = 0 ;
   for(int i = 0 ;i < MAXWORD ; i++)
    if((wl[i]) > maxvalue ) maxvalue = wl[i];
   for(int i =0 ; i < MAXWORD ; i++){
       printf("%5d - %5d:",i,wl[i]);
       if(wl[i]>0){
        if((len = wl[i]*MAXHIST/maxvalue)<=0) len = 1;
       }
       else  len = 0 ;
       while(len > 0 ){
        putchar('*');
        --len ;
       }
       putchar('\n');
   }


}

