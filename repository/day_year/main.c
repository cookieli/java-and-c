#include <stdio.h>
#include <stdlib.h>
static char daytab[2][13]={
                       {0,31,28,31,30,31,30,31,31,30,31,30,31},
                       {0,31,29,31,30,31,30,31,31,30,31,30,31}
};
int day_of_year(int year ,int month ,int day);
void month_day(int year,int yearday,int*pmonth,int*pday);
int main()
{
    printf("%d",day_of_year(2016,3,30));
    int *pm = malloc(32);
    int *pd = malloc(32);
    month_day(2016,90,pm,pd);
    printf("%d,%d",*pm,*pd);
}
int day_of_year(int year ,int month ,int day)
{
    int leap ;

    leap = year%4==0&&year%100!=0||year%400==0;
    char *p = daytab[leap];
    while(--month){
        day += *++p;
    }
    return day;
}
void month_day(int year,int yearday,int*pmonth,int*pday)
{
    int leap;
    leap = year%4==0&&year%100!=0||year%400==0;
    char *p = daytab[leap];
    for( ; yearday > *p ; p++)
    yearday -=*p ;
    *pmonth = p -*(daytab + leap);
    *pday = yearday ;

}
