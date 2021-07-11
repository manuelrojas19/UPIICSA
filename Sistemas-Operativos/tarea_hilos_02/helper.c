#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "helper.h"
#include "defs.h"

int *reservar_memoria()
{
    //srand(getpid());
    int *array = NULL;
    array = (int *)malloc(N * sizeof(int));
    if (!array)
    {
        perror("Error al reservar memoria \n");
        exit(EXIT_FAILURE);
    }
    return array;
}

void llenar_arreglo(int *datos)
{
    register int i;
    for (i = 0; i < N; i++)
    {
        datos[i] = rand() % 256;
    }
}

void imprimir_arreglo(int *datos)
{
    register int i;
    for (i = 0; i < N; i++)
    {
        if (!(i % 16))
            printf("\n");
        printf("%4d ", datos[i]);
    }
    printf("\n\n");
}
