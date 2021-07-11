#include <stdio.h>
#include <stdlib.h>
#include "defs.h"

void reservar_memoria(int **data)
{

    *data = (int *)malloc(N * sizeof(int));
    if (!data)
    {
        perror("Error al reservar memoria");
        exit(EXIT_FAILURE);
    }
}

void llenar_arreglo(int *data)
{
    register int i;
    for (i = 0; i < N; i++)
    {
        data[i] = rand() % 256;
    }
}

void imprimir_arreglo(int *data)
{
    register int i;

    for (i = 0; i < N; i++)
    {
        if (!(i % 16))
            printf("\n");
        printf("%3d ", data[i]);
    }
    printf("\n\n");
}