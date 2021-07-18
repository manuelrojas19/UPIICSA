/* Version con procesos */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include "helper.h"

#define NUM_PROC 4
#define N 16

void proceso_hijo(int np, int pipe_fd[]);
void proceso_padre(int pipe_fd[NUM_PROC][2]);

/* En un proceso las variables globales no son las mismas */

int *array_a, *array_b, *array_c;

int main()
{
    pid_t pid;
    register int np;

    int pipe_fd[NUM_PROC][2], state_pipe;
    
    array_a = reservar_memoria();
    array_b = reservar_memoria();
    array_c = reservar_memoria();

    llenar_arreglo(array_a);
    llenar_arreglo(array_b);

    imprimir_arreglo(array_a);
    imprimir_arreglo(array_b);

    for (np = 0; np < NUM_PROC; np++) {
        state_pipe = pipe(&pipe_fd[np][0]);
        if(state_pipe == -1) {   
            perror("Error al crear la tuberia \n");
            exit(EXIT_FAILURE);
        }
        pid = fork();
        if (pid == -1) {
            perror("Error al crear el proceso \n");
            exit(EXIT_FAILURE);
        }
        if (!pid) {
            proceso_hijo(np, &pipe_fd[np][0]);
        }
    }
    
    proceso_padre(pipe_fd);
    
    imprimir_arreglo(array_c);
    
    free(array_a);
    free(array_b);
    free(array_c);

    return 0;
}

void proceso_padre(int pipe_fd[NUM_PROC][2])
{
    register int np;
    int estado, num_proc;
    pid_t pid;

    int size_block = N / NUM_PROC;
    int init_block;

    for (np = 0; np < NUM_PROC; np++)
    {
        /* Reconocer el proceso que terminara, se necesita el corrimiento
         * por 8 bits a la derecha */

        pid = wait(&estado);
        num_proc = estado >> 8;

        /* Descriptor 0 es lectura 1 escritura */

        close(pipe_fd[num_proc][1]);

        init_block = num_proc * size_block;

        read(pipe_fd[num_proc][0], array_c + init_block, size_block * sizeof(int));

        printf("Termino el proceso %d con pid: %d \n", num_proc, pid);

        close(pipe_fd[num_proc][0]);
    }
}

void proceso_hijo(int np, int pipe_fd[])
{
    /* Calculo de los bloques 
     * tamanio bloque o 
     * elementos por bloque = total de datos / num de procesos
     * inicio = nucleo * numero de elementos
     * fin = inicio + tamanio
     * */
    
    int size_block = N / NUM_PROC;
    int begin_block = np * size_block;
    int end_block = begin_block + size_block;

    close(pipe_fd[0]);

    /* Conviene retornar por bloques al usar tuberias
     * Las variables son copias, no compartidas com en hilos */
    
    register int i;
    for (i = begin_block; i < end_block; i++)
        array_c[i] = array_a[i] * array_b[i];

    /* C es la direccion del arreglo + el desplazamiento con el inicio del 
     * bloque */

    write(pipe_fd[1], array_c + begin_block, size_block * sizeof(int));

    close(pipe_fd[1]);
    exit(np);
}

