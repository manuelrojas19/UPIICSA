#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#define NUM_HILOS 4

//void *suma(void *arg);
//void *resta(void *arg);
//void *mult(void *arg);
//void *divi(void *arg);

void *func_hilos(void *arg);

int main()
{ 
    //pthread_t tid_suma, tid_resta, tid_mult, tid_div;
    pthread_t tids[NUM_HILOS];
    //int *res_suma, *res_resta, *res_mult, *res_div;
    int *resultado;
    int nhs[NUM_HILOS];
    register int nh;

    printf("Ejemplo hilos \n");

    /* Create
     *
     * El primer parametro de esta funcion es el 
     * tid del hilo
     *
     * Esta funcion utiliza en su tercer parametro
     * un apuntador a una función, la cual 
     * regresa un apuntador void y 
     * recibe un apuntador void
     *
     * El ultimo argumento es el argumento
     * que se manda a la funcion
     *
     * El nombre de una función es su apuntador
     * a su primer instruccion asi como el nombre
     * de un arreglo es un apuntador a su primer
     * elemento
     *
     * */

    printf("Probando hilos... \n");

    //pthread_create(&tid_suma, NULL, suma, NULL);
    //pthread_create(&tid_resta, NULL, resta, NULL);
    //pthread_create(&tid_mult, NULL, mult, NULL);
    //pthread_create(&tid_div, NULL, divi, NULL);

    for (nh = 0; nh < NUM_HILOS; nh++)
    {
        nhs[nh] = nh;
        pthread_create(&tids[nh], NULL, func_hilos, (void *)&nhs[nh]);
    }


    /* Join
     * 
     * Esta funcion permite esperar a que termine el
     * hilo, equivalente a wait
     *
     * El primer parametro es el identificador del hilo
     * 
     * El segundo parametro es un valor de retorno, algo que
     * regresa el hilo al proceso que lo creo
     *
     * */
    
    //pthread_join(tid_suma, (void **)&res_suma);
    //pthread_join(tid_resta, (void **)&res_resta);
    //pthread_join(tid_mult, (void **)&res_mult);
    //pthread_join(tid_div, (void **)&res_div);
    
    for (nh = 0; nh < NUM_HILOS; nh ++) 
    {
        pthread_join(tids[nh], (void **)&resultado);
        printf("El resultado es es %d \n", *resultado);
        free(resultado);
    }

    //printf("La resta es %d \n", *res_resta);
    //printf("La suma es %d \n", *res_suma);
    //printf("La multiplicacion es %d \n", *res_mult);
    //printf("La division es %d \n", *res_div);
    
    //free(res_mult);
    //free(res_div);

    return 0;
}

void *func_hilos(void *arg)
{
    int nh = *(int *)arg;
    //static int res;
    /* Cada hilo que se cree tendra su propia variable de resultado */
    int *res = (void *) malloc(sizeof(int));
    int num1 = 20, num2 = 4; 

    printf("Hilo %d en ejecucion \n", nh);

    /* Se deben usar variables diferentes para que
     * los hilos no sobreescriban el resultado */
    if (nh == 0)
        *res = num1 + num2;
    else if (nh == 1)
        *res = num1 - num2;
    else if (nh == 2)
        *res = num1 * num2;
    else if (nh == 3)
        *res = num1 / num2;

    //pthread_exit((void *)&res);
    pthread_exit((void *)res);
}

/*
 * Al ser variables locales no pueden salir de la 
 * funcion, son destruidas, por lo tanto no pueden 
 * ser recogidos en main, se puede solucionar con 
 * distintas estrategias, una de ellas es usar el 
 * especificador static
 *
 * static indica que el valor de la variable no se
 * destruye cuando la funcion termina
 *
 * */

//void *suma(void *arg)
//{
//    int num1 = 20, num2 = 19;
//    static int res;
//
//    res = num1 + num2; 
//
//    /*
//     * Esta función termina el hilo
//     * utiliza el valor de retorno
//     *
//     * */
//
//    pthread_exit((void *)&res);
//}
//
//void *resta(void *arg)
//{
//    int num1 = 20, num2 = 19;
//    static int res;
//
//    res = num1 - num2; 
//
//    /*
//     * Esta función termina el hilo
//     * utiliza el valor de retorno
//     *
//     * */
//
//    pthread_exit((void *)&res);
//}
//
///*
// * Otra solución es asignar memoria
// *
// * */
//
//void *mult(void *arg)
//{
//    int num1 = 20, num2 = 19;
//    int *res = (int *)malloc(sizeof(int));
//    *res = num1 * num2;
//
//    /*
//     * Esta función termina el hilo
//     * utiliza el valor de retorno
//     *
//     * */
//
//    pthread_exit((void *)res);
//}
//
//void *divi(void *arg)
//{
//    int num1 = 20, num2 = 19;
//    int *res = (int *)malloc(sizeof(int));
//
//    *res = num1 / num2; 
//
//    /*
//     * Esta función termina el hilo
//     * utiliza el valor de retorno
//     *
//     * */
//
//    pthread_exit((void *)res);
//}
//
