#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "helper.h"
#include "defs.h"

void *func_hilo(void *arg);

int *array_a, promedio;

pthread_mutex_t locker;

int main()
{  
    pthread_t tids[NUM_HILOS];
    int *hilo;
    int nhs[NUM_HILOS];
    
    array_a = reservar_memoria();
    llenar_arreglo(array_a);
    imprimir_arreglo(array_a);

    promedio = 0;
    
    pthread_mutex_init(&locker, NULL);

    printf("Probando hilos... \n");
    register int nh;
    for (nh = 0; nh < NUM_HILOS; nh++) {
        nhs[nh] = nh;
        pthread_create(&tids[nh], NULL, func_hilo, (void *)&nhs[nh]);
    }
    
    for (nh = 0; nh < NUM_HILOS; nh ++) {
        pthread_join(tids[nh], (void **)&hilo);   
        printf("El hilo %d termino \n", *hilo);
    }

    /* 
     * Si se divide entre una potencia de 2^n es equivalente a hacer un
     * corrimiento.
     * */

    //promedio = promedio / N;
        
    promedio = promedio >> 4;
    printf("Promedio de los valores del arreglo: %d \n", promedio);

    free(array_a);
    pthread_mutex_destroy(&locker);

    return 0;
}

void *func_hilo(void *arg)
{
    int nucleo = *(int *)arg;
    int partial_sum;

    printf("Hilo %d en ejecucion \n", nucleo);
    
    register int i;
    
    partial_sum = 0;

    for (i = nucleo; i < N; i+= NUM_HILOS) {
        partial_sum += array_a[i];  
    }
    
    pthread_mutex_lock(&locker);

    promedio += partial_sum;
    
    pthread_mutex_unlock(&locker);

    pthread_exit(arg);
}

