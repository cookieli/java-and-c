#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
int Atoi(char s[]);
int ItoA(int n,char s[]);
void reverse(char s[]);
void itob(int n,char s[],int b);
int main()
{
   char s[4] ;
   int  a = 10;
   itob(a,s,2);
   printf("%s",s);


}
int Atoi(char s[])
{
    int i,n,sign;
    for(i = 0 ; isspace(s[i]) ; i++ );//skip white space
    sign = (s[i]=='-')? -1 : 1;
    if(s[i] =='+'||s[i]=='-') i++;
    for(n = 0 ; isdigit(s[i]) ; i++)
        n = 10*n +(s[i]-'0');
    return sign * n ;
}
int ItoA(int n,char s[])
{
    int sign ;
    int i = 0;
    if((sign = n) < 0) n = -n;
    while(n>0){
        s[i++] ='0' +n%10;
        n /=10 ;
    }
    if(sign<0) s[i++] ='-';
    s[i] = '\0';
    reverse(s);
}
void reverse(char s[])
{
  int i = 0 , j =0;
  while(s[i]!='\0') i++;
  i--;
  if(s[i]=='\n') i--;
  while(i > j){
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp ;
    i--;
    j++;
  }
}
void itob(int n,char s[],int b)
{
    int sign , j,i;
    i = 0;
    if((sign = n)<0) n = -n;
    while(n > 0){
        j = n%b;
        s[i++] = (j>9)?(j - 10 + 'a'):(j+'0');
        n/=b;
    }
    if(sign < 0) s[i++] ='-';
    s[i] = '\0';
    reverse(s);
}
