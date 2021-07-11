#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "hilos.h"
#include "procesamiento.h"

extern int *datos, res_prom, res_pares;
extern pthread_mutex_t bloqueo;

void *func_hilos(void *arg)
{
    int nh = *(int *)arg;

    register int i = 0;

    printf("Hilo %d en ejecucion \n", nh);

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
        mult_by_cons(datos);
    }

    while ((--i));

    pthread_mutex_unlock(&bloqueo);

    pthread_exit(arg);
}
