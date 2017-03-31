#include <stdio.h>
#include <stdlib.h>
int day_of_year(int year ,int month ,int day);
void month_day(int year , int day ,int*month,int*d);
static char detab[2][13]={
                       {0,31,28,31,30,31,30,31,31,30,31,30,31},
                       {0,31,29,31,30,31,30,31,31,30,31,30,31}
};

int main()
{
    int i = 0;
    int j = 0;
    //printf("%d\n",day_of_year(2016,3,30));
    int *month = &i;
    int *day  = &j;
     month_day(2016 , 90 ,month,day);
    printf("%d,%d",*month,*day);
}
/* get day of year from month&day*/
int day_of_year(int year ,int month ,int day)
{
    int yeap;
    yeap = year%4==0&&year%100!=0||year%400==0 ;
    for(int i = 1 ; i < month ; i++){
        day+=detab[yeap][i];
    }
    return day;
}
void  month_day(int year , int day ,int *pmonth,int *pday)
{
    int i,leap;
    leap = year%4 == 0 && year%100 !=0 || year%400 == 0;
    for( i = 1  ;day > detab[leap][i] ; i++)
        day -= detab[leap][i];
    *pmonth = i;
    *pday = day;
}
