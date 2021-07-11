#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define NUM_HILOS 4

void *func_hilos(void *arg);
int contador; 
pthread_mutex_t bloqueo;

int main()
{ 
    register int nh;

    pthread_t tids[NUM_HILOS];
    int *hilo, nhs[NUM_HILOS];

    contador = 0;

    pthread_mutex_init(&bloqueo, NULL);

    printf("Ejemplo hilos \n");
    printf("Probando hilos... \n");

    for (nh = 0; nh < NUM_HILOS; nh++)
    {
        nhs[nh] = nh;
        pthread_create(&tids[nh], NULL, func_hilos, (void *)&nhs[nh]);
    }
    
    for (nh = 0; nh < NUM_HILOS; nh ++) 
    {
        pthread_join(tids[nh], (void **)&hilo);    
        printf("Hilo %d terminado \n", *hilo);
    }

    pthread_mutex_destroy(&bloqueo);
    return 0;
}

/*
 *
 * Si un hilo esta usando una variable nadie mas debe de utilizarla
 * Condición de carrera, se presenta por uso de variables compartidas
 * dentro de hilos
 *
 * Se usara mutex para bloquear acceso a datos compartidos mientras un hilo
 * lo este ocupando
 *
 * */

void *func_hilos(void *arg)
{
    int nh = *(int *)arg;
    register int i = 0; // 32 bits
   
    /* Inicia la seccion critica */

    pthread_mutex_lock(&bloqueo);

    
    contador++;

    printf("Hilo %d en ejecucion con contador: %d \n", nh, contador);

    while((--i));
    

    printf("Hilo %d en ejecucion con contador: %d \n", nh, contador);
    
    pthread_mutex_unlock(&bloqueo);
    
    /* Termina la seccion critica */

    pthread_exit(arg);
}

