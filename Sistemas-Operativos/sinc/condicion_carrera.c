#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define NUM_HILOS 4

void *func_hilos(void *arg);
int contador; 

int main()
{ 
    register int nh;

    pthread_t tids[NUM_HILOS];
    int *hilo, nhs[NUM_HILOS];

    contador = 0;

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
    return 0;
}

/*
 *
 * Si un hilo esta usando una variable nadie mas debe de utilizarla
 * Condición de carrera, se presenta por uso de variables compartidas
 * dentro de hilos
 *
 * */
void *func_hilos(void *arg)
{
    int nh = *(int *)arg;
    register int i = 0; // 32 bits
    
    contador++;
    
    printf("Hilo %d en ejecucion con contador: %d \n", nh, contador);

    /* 
     * nvim no puede ser usada en hilos por que es no reentrante 
     * es decir pierde valores 
     * */

    //sleep(1);
    
    /*
     * Se usan contadores con ciclos anidados
     *
     * En este caso comienza en 0, antes de la declaración
     * se hace un decremento 0  - 1 = -1 en binario
     *
     * 0001 = 1 binario
     * Invertir los bits
     * 
     * 1110 = 1 en complemento a 1
     * 0001 sumar para obtener el valor de -1
     * ----
     * 1111 = -1 en complemento a 2
     *
     * Todos los registros se encienden
     *
     * Al ser de 32 de bits se encienden 8 bits
     *
     * 1111 1111 1111 1111 1111 1111 1111 1111
     *
     * */

    /* 
     * Genera un retardo en base a la frecuencia del procesador
     * este ciclo consume tiempo de procesador de 2^32 iteraciones
     *
     * */

    while((--i));

    printf("Hilo %d en ejecucion con contador: %d \n", nh, contador);

    pthread_exit(arg);
}

