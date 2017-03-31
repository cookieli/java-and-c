#include <stdio.h>
#include <stdlib.h>
//#include <string.h>
#include <ctype.h>

void Strcpy(char *s,char *t);
int Strcmp(char *s , char *t);
int strend(char *s,char *t);
int Atoi(char *s);
void reverse(char *s);
void Itoa(int n,char *s);
int strindex(char *s,char *t);
int main()
{
  char s[] = "abcde";
  char t[] = "h";
  printf("%d",strindex(s,t));
}
/* copy t to the s*/
void Strcpy(char *s,char *t)
{
    while(*s++ ==*t++);
}
int Strcmp(char *s , char *t)
{
    for(; *s == *t ; s++,t++)
        if(*s =='\0')
        return 0;
    return *s - *t;
}
/*t appears at the end of s,return 1 else return 0*/
int strend(char *s,char *t)
{
   char *bs = s;
   char *bt = t;
   for(; *s ; s++);
   for(; *t ; t++);
   for(;*s == *t;s--,t--){
    if(s==bs||t==bt)
        break;
   }
   if(*s == *t&&t == bt &&s!='\0')
    return 1;
   else
    return 0;
}
void strncpy(char *s,char *t,int n)
{
    while(*t&& n-- >0)
        *s++ = *t++;
  //  while(n-- > 0)
        *s++ = '\0';
}
void strncat(char *s ,char *t,int n)
{
  void strncpy(char *s,char *t,int n);
  int strlen(char *);
  strncpy(s+strlen(s) ,t , n);
}
int strncmp(char *s,char *t,int n)
{
    for( ;*s == *t ; s++,t++)
        if(*s == '\0'||--n<=0)
            return 0;
    return *s - *t;
}
int Getline(char *s ,int lim)
{
    char *p = s ;
    int c ;
    while(((--lim) > 0)&&((c = getchar())!='\0')&&c!='\n')
        *s++ = c ;
        if(c =='\n')
            *s++ = c ;
        *s = '\0';
        return s - p;
}
int Atoi(char *s)
{
    int sign ;
    int num = 0  ;
    for( ; isspace(*s) ; s++);
    sign = (*s == '-')?-1:1;
    if(*s == '+'||*s == '-')
        s++;
    for( ; isdigit(*s) ; s++){
        num = num*10 + (*s-'0');
    }
    return sign*num ;
}
void Itoa(int n,char *s)
{
   char *p = s;
   int  sign = 1;;
   if( n < 0 ) {
        sign = -1;
        n = -n;
   }
   while( n  >0){
    *s++ = n%10 + '0';
     n = n/10;
   }
   if( sign < 0) *s++ = '-' ;
   *s = '\0';
   reverse(p);
}
void reverse(char *s)
{
    void swap(char *s,char*t);
    char *p = s;
    for( ; *s ; s++);
    s--;
    while( s > p){
        swap(s--,p++);
    }
}
void swap(char *s,char*t)
{
    char temp = *s;
    *s = *t;
    *t = temp ;
}
int strindex(char *s,char *t)
{
    char *ps = s;
    char *pt = t;
    while(*s != *t){
        s++;
    if (*s == '\0')
        return -1;
    }
    for( ;*s==*t&&*s!='\0'&&*t!='\0';s++,t++);
    if(*t == 0)
        return s - ps-(t-pt);
    else
        return -1;
}
