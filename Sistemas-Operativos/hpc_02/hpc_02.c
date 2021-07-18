#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "helper.h"
#include "defs.h"

void *func_hilo(void *arg);

/* 
 * En configuracion de perifericos se suelen usar
 * arreglos globales 
 *
 * */
int res_suma, res_resta, res_mult, res_div;
int *array_a, *array_b, *array_c; 

int main()
{  
    pthread_t tids[NUM_HILOS];
    int *hilo;
    int nhs[NUM_HILOS];
    
    array_a = reservar_memoria();
    array_b = reservar_memoria();
    array_c = reservar_memoria();
    
    llenar_arreglo(array_a);
    llenar_arreglo(array_b);

    imprimir_arreglo(array_a);
    imprimir_arreglo(array_b);
    
    printf("Probando hilos... \n");

    register int nh;
    for (nh = 0; nh < NUM_HILOS; nh++) {
        nhs[nh] = nh;
        pthread_create(&tids[nh], NULL, func_hilo, (void *)&nhs[nh]);
    }
    
    for (nh = 0; nh < NUM_HILOS; nh++) {
        pthread_join(tids[nh], (void **)&hilo);   
        printf("El hilo %d termino \n", *hilo);
    }
    imprimir_arreglo(array_c);

    free(array_a);
    free(array_b);
    free(array_c);

    return 0;
}

void *func_hilo(void *arg)
{
    int nucleo = *(int *)arg;

    printf("Hilo %d en ejecucion \n", nucleo);
    
    register int i;
    for(i = nucleo; i < N; i+= NUM_HILOS) {
        array_c[i] = array_a[i] * array_b[i];
    }

    pthread_exit(arg);
}

