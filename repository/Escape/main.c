#include <stdio.h>
#include <stdlib.h>
void escape(char s[],char t[]);
void unescape(char s[],char t[]);
int main()
{
    char s[1000];
    char t[1000];
    char h[1000];
    int c ;
    for(int i = 0 ; (c = getchar())!=EOF ;i++){
        t[i] = c;
    }
    escape(s,t);
    unescape(h,s);
    printf("%s\n",s);
    printf("%s",h);
}
void escape(char s[],char t[])
{
    int i,j;
    for( i = 0 ,j = 0; t[i]!='\0' ; i++){
        switch(t[i]){
            case '\n' :
                     s[j++] = '\\';
                     s[j++] = 'n' ;
                     break ;
            case '\t' :
                    s[j++] = '\\';
                    s[j++] = 't' ;
                    break ;
            default  :
                   s[j++] = t[i];
                   break;
        }
    }
        s[j] = '\0';
}
void unescape(char s[],char t[])
{
    int i , j ;
    for(i = 0,j = 0 ; t[i]!='\0'; i++){
        if(t[i]!='\\') s[j++] = t[i];
        else
            switch(t[++i]){
            case 'n':
                s[j++] = '\n';break;
            case 't':
                s[j++] = '\t';break;
            default :
                s[j++] = '\\';
                s[j++] = t[i];
                break ;
            }
    }
        s[j] ='\0';
}
