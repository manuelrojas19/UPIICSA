#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>

#include "procesos.h"
#include "procesamiento.h"
#include "helper.h"

void procesos(int *data)
{
    pid_t pid;

    // 2 uno para escritura y lectura
    int pipe_fd[NUM_PROC][2], state_pipe;

    register int np;

    for (np = 0; np < NUM_PROC; np++)
    {
        /* Creación de tuberias */
        state_pipe = pipe(&pipe_fd[np][0]);
        if (state_pipe == -1)
        {
            perror("Error al crear la tuberia \n");
            exit(EXIT_FAILURE);
        }

        /* Creación de procesos */
        pid = fork();
        if (pid == -1)
        {
            perror("Error al crear el proceso \n");
            exit(EXIT_FAILURE);
        }
        if (!pid)
        {
            proceso_hijo(np, data, &pipe_fd[np][0]);
        }
    }
    proceso_padre(pipe_fd);
}

void proceso_padre(int pipe_fd[NUM_PROC][2])
{
    register int np;
    int estado, num_proc;
    int *res;
    float res_prom;
    pid_t pid;

    for (np = 0; np < NUM_PROC; np++)
    {
        pid = wait(&estado);
        num_proc = estado >> 8;
        close(pipe_fd[num_proc][1]);

        printf("Termino el proceso %d con pid %d \n", num_proc, pid);

        if (num_proc == 0)
        {
            res = (int *)malloc(N * sizeof(int));
            read(pipe_fd[num_proc][0], (void *)res, N * sizeof(int));

            printf("El proceso %d con pid %d ordeno el arreglo: \n", num_proc, pid);

            imprimir_arreglo(res);
        }
        else if (num_proc == 1)
        {
            res = (int *)malloc(sizeof(int));
            read(pipe_fd[num_proc][0], &res_prom, sizeof(float));
            printf("El proceso %d con pid %d calculo un promedio de: %f \n\n", num_proc, pid, res_prom);
        }
        else if (num_proc == 2)
        {
            res = (int *)malloc(sizeof(int));
            read(pipe_fd[num_proc][0], res, sizeof(int));
            printf("El proceso %d con pid %d calculo que en el arreglo existe un total de numeros pares de pares de: %d \n\n", num_proc, pid, *res);
        }
        else if (num_proc == 3)
        {
            res = (int *)malloc(N * sizeof(int));
            read(pipe_fd[num_proc][0], (void *)res, N * sizeof(int));

            printf("El proceso %d con pid %d multiplico el arreglo por una constante: \n", num_proc, pid);

            imprimir_arreglo(res);
        }
        close(pipe_fd[num_proc][0]);
        res = NULL;
    }
    free(res);
}

void proceso_hijo(int np, int *data, int pipe_fd[])
{
    int r3;
    float r2;
    close(pipe_fd[0]);
    // Ordenamiento burbuja
    if (np == 0)
    {
        ordenamiento(data);
        write(pipe_fd[1], data, N * sizeof(int));
    }
    //  Promedio
    else if (np == 1)
    {
        r2 = promedio(data);
        write(pipe_fd[1], &r2, sizeof(float));
    }
    // Numeros pares
    else if (np == 2)
    {
        r3 = pares(data);
        write(pipe_fd[1], &r3, sizeof(int));
    }
    // Multiplicacion par constante
    else if (np == 3)
    {
        mult_by_cons(data);
        write(pipe_fd[1], data, N * sizeof(int));
    }
    close(pipe_fd[1]);
    exit(np);
}
