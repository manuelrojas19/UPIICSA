#include <stdio.h>
#include <stdlib.h>
#include "defs.h"
#include "procesamiento.h"

void ordenamiento(int *datos)
{
    register int i, j;
    for (i = 0; i < N - 1; i++)
    {
        for (j = 0; j < N - i - 1; j++)
        {
            if (datos[j] > datos[j + 1])
            {
                int aux = datos[j];
                datos[j] = datos[j + 1];
                datos[j + 1] = aux;
            }
        }
    }
}

float promedio(int *datos)
{
    register int i;
    float res = 0;
    for (i = 0; i < N; i++)
    {
        res += datos[i];
    }
    return res / N;
}

int pares(int *datos)
{
    register int i;
    int res = 0;
    for (i = 0; i < N; i++)
    {
        if (datos[i] % 2)
            res++;
    }
    return res;
}

int primos(int *datos)
{
    register int i, j;
    int flag_par;
    int res = 0;
    for (i = 0; i < N; i++)
    {
        flag_par = 1;
        for (j = 2; j < datos[i]; j++)
        {

            if (datos[i] % j == 0)
            {
                flag_par = 0;
                break;
            }
        }
        if (flag_par == 1)
        {
            res++;
        }
    }
    return res;
}
