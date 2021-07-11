#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#define NUM_PROC 2
#define EVER 1

void proceso_hijo(int);
void proceso_padre(void);

int main()
{ 
    /*
     * pid_t es un tipo de dato que sirve como un
     * identificador de porceso
     *
     * */

    pid_t pid;

    printf("Ejemplo de procesos \n");

    register int np;
   
    for(np = 0; np < NUM_PROC; np++)
    {
        pid = fork();
        if (pid == -1)
        {
            perror("Error al crear el proceso \n");
            exit(EXIT_FAILURE);
        }    


        if (!pid) 
        {
            proceso_hijo(np);
        }
    }
    proceso_padre();
    return 0;
}

void proceso_hijo(int np)
{
    printf("Proceso hijo %d ejecutandose con pid: %d \n", np, getpid());

    for(;EVER;);

    exit(np);
}

void proceso_padre(void)
{
    register int np;
    int estado;
    pid_t pid;

    for(np = 0; np < NUM_PROC; np ++)
    {
        pid = wait(&estado);
        printf("Proceso %d con pid %d terminado \n", estado>>8, pid);
    }
}
