#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define NUM_HILOS 4

void *func_hilos(void *arg);

/* 
 * En configuracion de perifericos se suelen usar
 * arreglos globales 
 *
 * */

int res_suma, res_resta, res_mult, res_div;
int num1 = 20, num2 = 4; 

int main()
{ 
    register int nh;
    
    pthread_t tids[NUM_HILOS];
    int *hilo, nhs[NUM_HILOS];

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
        if(*hilo == 0)
            printf("La suma es: %d \n", res_suma);
        else if(*hilo == 1)
            printf("La resta es: %d \n", res_resta);
        else if(*hilo == 2)
            printf("La multiplicacion es: %d \n", res_mult);
        else if(*hilo == 3)
            printf("La division es: %d \n", res_div);
    }
    return 0;
}

void *func_hilos(void *arg)
{
    int nh = *(int *)arg;
    
    printf("Hilo %d en ejecucion \n", nh);
    
    /* Se deben usar variables diferentes para que
     * los hilos no sobreescriban el resultado */
    if (nh == 0)
        res_suma = num1 + num2;
    else if (nh == 1)
        res_resta = num1 - num2;
    else if (nh == 2)
        res_mult = num1 * num2;
    else if (nh == 3)
        res_div = num1 / num2;
    pthread_exit(arg);
}

