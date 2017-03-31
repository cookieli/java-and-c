#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
int main()
{
    unsigned int i = -11111;
    printf("signed char min = %d\n",SCHAR_MIN);
    printf("signed char max = %d\n", SCHAR_MAX);
    printf("unsigned char max = %d\n", UCHAR_MAX);
    printf("signed short min = %d\n",SHRT_MIN);
    printf("unsigned int max = %d\n",UINT_MAX);
    printf("unsigned int i = %d\n",i);

}
