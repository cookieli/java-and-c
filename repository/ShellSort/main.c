#include <stdio.h>
#include <stdlib.h>
void shellsort(int v[],int n);
int main()
{
    int v[10];
    for(int i = 0 ; i < 10 ; i++){
        v[i] =10 - i;
    }
    shellsort(v,10);

    for(int i = 0 ; i < 10 ; i++){
        printf("i:%d ,",i,v[i]);
    }
}
void shellsort(int v[],int n)
{
    int gap,i,j,temp;
    for(gap = n/2 ; gap > 0 ;gap/=2){
        for(i = gap ; i < n ; i++){
            for(j = i-gap ;j > 0&&v[j]>v[j+gap] ; j++){
                temp = v[j];
                v[j] = v[j+gap];
                v[j+gap] = temp;
            }
        }
    }
}
