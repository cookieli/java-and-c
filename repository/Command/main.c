#include <stdio.h>
#include <stdlib.h>

int main(int argc , char *argv[])
{
    int i;
    for( i = 1 ; i < argc ; i++)
        printf("%s%s\n",*++argv,(argc > 1)?"\n ": "");
    printf("\n");
    return 0;
}