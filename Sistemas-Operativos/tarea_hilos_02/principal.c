#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "helper.h"
#include "defs.h"
#include "hilos.h"

int *datos, res_prom, res_pares, res_primos;
pthread_mutex_t bloqueo;

int main()
{
    datos = reservar_memoria();
    llenar_arreglo(datos);
    imprimir_arreglo(datos);

    register int nh;
    pthread_t tids[NUM_HILOS];
    int nhs[NUM_HILOS];

    pthread_mutex_init(&bloqueo, NULL);

    // Se crean los hilos
    for (nh = 0; nh < NUM_HILOS; nh++)
    {
        nhs[nh] = nh;
        pthread_create(&tids[nh], NULL, func_hilos, (void *)&nhs[nh]);
    }

    // Variable de respuesta
    int *hilo; 

    // Se espera a los hilos
    for (nh = 0; nh < NUM_HILOS; nh++)
    {
        pthread_join(tids[nh], (void **)&hilo);
        
        printf("Hilo %d terminado \n", *hilo);

        // Se imprimen los resultados
        if (*hilo == 0)
        {
            printf("Se ordenaron por burbuja los datos del arreglo:  \n");
            imprimir_arreglo(datos);
        }
        else if (*hilo == 1)
        {
            printf("Promedio de los datos del arreglo: %d \n", res_prom);
        }
        else if (*hilo == 2)
        {
            printf("El total de numeros pares del arreglo es: %d \n", res_pares);
        }
        else if (*hilo == 3)
        {
            printf("Se multiplicaron los datos del arreglo por una constante: \n");
            imprimir_arreglo(datos);
        }
    }

    pthread_mutex_destroy(&bloqueo);
    return 0;
}
