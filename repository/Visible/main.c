#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    return 0;
}
void escape(char s[],char t[])
{
    int i,j;
    for( i=j=0 ; t[i]!='\0' ;i++){
        switch(t[i]){
            case '\n'
              s[j++] = '\\';
              s[j++] = 'n';
              break;
            case '\t'
              s[j++] = '\\';
              s[j++] = 't';
              break;
            default
              s[j++] = t[i];
              break ;
        }
    }
}
