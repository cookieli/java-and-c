#include <stdio.h>
#include <stdlib.h>
#define  YES   1
#define   NO   0
int htoi(char s[]);
unsigned  getbits(unsigned  x , int p ,int n);
int main()
{
    printf("%d",getbits(7,4,3));
}
int htoi(char s[])
{
    int i,hexdigit,inhex,n;
    inhex = NO;
    if(s[0]=='0'&&(s[1]=='x'||s[1]=='X'))
        inhex = YES;
        n = 0 ;
    for( i = 2 ; i<strlen(s)&&inhex==YES ; i++){
        if(s[i]>='0'&&s[i]<='9') {
            hexdigit = s[i] - '0';
        }
        else if(s[i]>='a'&&s[i]<='f'){
            hexdigit = s[i] - 'a'+10;
        }
        else if(s[i]>='A'&&s[i]<='F'){
            hexdigit = s[i] - 'A'+10;
        }
        else   inhex = NO;
        if(inhex == YES)
        n =16* n +hexdigit;
    }

     return n;
}
void squeeze(char s1[],char s2[])
{
    int i , j , k;
    for( i = 0,k = 0 ; s1[i]!='\0' ; i++){
        for(j = 0 ; s2[j]!='\0'&&s2[j]!=s1[i] ; j++);
        if(s2[j]=='\0'){
            s1[k++] = s1[i];
        }
    }
    s1[k] = '\0';
}
int any(char s1[],char s2[])
{
    int i ,j;
    for(int i = 0 ; s1[i]!='\0' ; i++){
        for( j = 0 ; s2[j]!='\0' ; j++)
            if(s1[i] == s2[j]) return i;
    }
    return -1;
}
unsigned int getbits(unsigned  x , int p ,int n)
{
    return (x>>(p+1-n))&~(~0<<n);
}
