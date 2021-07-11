#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    float num1 = 45, num2 = 12, sum, substract;
    
    /*
     * pid_t es un tipo de dato que sirve como un
     * identificador de porceso
     *
     * */

    pid_t pid;
    int status;

    printf("Ejemplo de procesos \n");
    
    /* Se crea el proceso hijo */
    pid = fork();
    
    /* Verificar que el proceso se creo correctamente */
    if (pid == -1)
    {
        perror("Error al crear el proceso \n");
        exit(EXIT_FAILURE);
    }    

    /* 
     * Si el valor regresado por la llamada 
     * fork() es 0, significa que se creo el proceso
     * hijo correctamente 
     *
     * */

    if (!pid) 
    {
        /* getpid() obtiene el pid del proceso hijo */
        printf("El proceso hijo se esta ejecutando con pid = %d \n", getpid());
        sum = num1 + num2;
        printf("La suma es: %f \n", sum);
        exit(50);
    }
    /*
     * El estado indica la salida de exit del proceso
     * en este caso exit(0) 1 regresa 256 2 regresa 512
     * Esto es por corrimiento
     *
     * 10 9 8 7 6 5 4 3 2 1
     * 0 0 0 0 0 0 0 0 1 0      
     * 0 1 0 0 0 0 0 0 0 0
     *
     * desplazamiento de 8 bits a la izquierda
     * cuando se usa exit el valor que se envia es recogido
     * por wait() con un corrimiento de 8 bits a la izquierda
     *
     *
     * */
    else 
    {
        sleep(15);
        printf("Proceso padre con pid: %d\n", getpid());
        substract = num1 - num2;
        printf("La resta es: %f \n", substract);
        pid = wait(&status);
        /* Se agrega un corrimiento de 8 bits a la derecha a status con
         * >> para que pueda ser imprimido correctamente*/
        printf("Proceso terminado con pid = %d y estado = %d\n", pid, status>>8);
        /*
         *  Proceso zombie:
         *
         *  Proceso que termino pero no fue esperado 
         *  por el proceso padre. En este caso se fueza con
         *  sleep(10).
         *
         *  Sale de este estado cuando el proceso padre utiliza la
         *  función wait() y sale de ese estado.
         *
         * */
    }
    return 0;
}
