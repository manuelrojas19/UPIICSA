#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "hilos.h"
#include "procesamiento.h"

extern int *datos, res_prom, res_pares, res_primos;
extern pthread_mutex_t bloqueo;

void *func_hilos(void *arg)
{
    int nh = *(int *)arg;

    int *res = (void *)malloc(sizeof(int));

    printf("Hilo %d en ejecucion \n", nh);

    *res = nh;

    pthread_mutex_lock(&bloqueo);

    if (nh == 0)
    {
        ordenamiento(datos);
    }
    else if (nh == 1)
    {
        res_prom = promedio(datos);
    }
    else if (nh == 2)
    {
        res_pares = pares(datos);
    }
    else if (nh == 3)
    {
        res_primos = primos(datos);
    }

    pthread_mutex_unlock(&bloqueo);

    pthread_exit((void *)res);
}
