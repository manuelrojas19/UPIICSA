#include <stdio.h>
#include <stdlib.h>

#include "defs.h"
#include "helper.h"

void ordenamiento(int *data)
{
    register int i, j;
    for (i = 0; i < N - 1; i++)
        for (j = 0; j < N - i - 1; j++)
        {
            if (data[j] > data[j + 1])
            {
                int aux = data[j];
                data[j] = data[j + 1];
                data[j + 1] = aux;
            }
        }
}

float promedio(int *data)
{
    register int i;
    float prom = 0;
    for (i = 0; i < N; i++)
        prom += data[i];
    return prom / N;
}

int pares(int *data)
{
    register int i;
    int pares = 0;
    for (i = 0; i < N; i++)
    {
        if (data[i] % 2 == 0)
        {
            pares++;
        }
    }
    return pares;
}

void mult_by_cons(int *data)
{
    register int i;
    for (i = 0; i < N; i++)
    {
        data[i] = data[i] * 10;
    }
}
