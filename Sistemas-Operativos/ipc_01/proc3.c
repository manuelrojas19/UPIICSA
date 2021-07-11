#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#define NUM_PROC 4

void proceso_hijo(int np, int pipe_fd[]);
void proceso_padre(int pipe_fd[NUM_PROC][2]);

/* Paralelismo a nivel de aplicación */

/* Cuando los hijos escriban resultados 
 * Se deben usar tuberias dedicada
 * */

int main()
{
    pid_t pid;
    register int np;

    /* Se usa un arreglo de dos elementos para 
     * los descriptores de lectura y escritura
     */

    /* Una tuberia compartida por todos genera errores debido
     * al planificador, una tuberia por hijo resuelve el
     * problema
     * */

    int pipe_fd[NUM_PROC][2], state_pipe;

    printf("Ejemplo de procesos \n");

    //state_pipe = pipe(pipe_fd);

    //if (state_pipe == -1)
    //{
    //    perror("Error al crear la tuberia");
    //    exit(EXIT_FAILURE);
    //}

    for (np = 0; np < NUM_PROC; np++)
    {
        state_pipe = pipe(&pipe_fd[np][0]);
        if(state_pipe == -1)
        {   
            perror("Error al crear la tuberia \n");
            exit(EXIT_FAILURE);
        }
        pid = fork();
        if (pid == -1)
        {
            perror("Error al crear el proceso \n");
            exit(EXIT_FAILURE);
        }
        if (!pid)
        {
            proceso_hijo(np, &pipe_fd[np][0]);
        }
    }
    proceso_padre(pipe_fd);
    return 0;
}

void proceso_hijo(int np, int pipe_fd[])
{
    int num1 = 20, num2 = 4;
    int suma, resta, mult, div;

    /* 1 es para escrituras 0 es para lecturas 
     * Como solo se usara la parte de escritura
     * se cierra 0 que es de lectura*/
    close(pipe_fd[0]);
    if (np == 0)
    {
        suma = num1 + num2;

        /* Se usa el pipe_fd[1] que es para escritura,
         * manda la direccion de lo que se desea enviar
         * y el tamaño*/

        write(pipe_fd[1], &suma, sizeof(int));
    }
    else if (np == 1)
    {
        resta = num1 - num2;
        write(pipe_fd[1], &resta, sizeof(int));
    }
    else if (np == 2)
    {
        mult = num1 * num2;
        write(pipe_fd[1], &mult, sizeof(int));
    }
    else if (np == 3)
    {
        div = num1 / num2;
        write(pipe_fd[1], &div, sizeof(int));
    }
    close(pipe_fd[1]);
    exit(np);
}

void proceso_padre(int pipe_fd[NUM_PROC][2])
{
    register int np;
    int estado, num_proc, resultado;
    pid_t pid;
    for (np = 0; np < NUM_PROC; np++)
    {
        pid = wait(&estado);
        num_proc = estado >> 8;
        close(pipe_fd[num_proc][1]);
        read(pipe_fd[num_proc][0], &resultado, sizeof(int));
        printf("Termino el proceso %d con pid: %d \n", num_proc, pid);

        if (num_proc == 0)
        {
            printf("El resultado de la suma es: %d \n", resultado);
        }
        else if (num_proc == 1)
        {
            printf("El resultado de la resta es: %d \n", resultado);
        }
        else if (num_proc == 2)
        {
            printf("El resultado de la multiplicacion es: %d \n", resultado);
        }
        else if (num_proc == 3)
        {
            printf("El resultado de la division es: %d \n", resultado);
        }
        close(pipe_fd[num_proc][0]);
    }
}
