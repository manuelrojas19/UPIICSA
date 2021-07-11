#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#define NUM_PROC 2
#define EVER 1
#define N 95

void proceso_hijo(int, int *);
void proceso_padre(void);
int *init_array(void);
void llenar_arreglo(int *);
void print_array(int *);
int buscar_mayor(int *);
int buscar_menor(int *);

/* Paralelismo a nivel de a plicación */

int main()
{ 
    /*
     * pid_t es un tipo de dato que sirve como un
     * identificador de porceso
     *
     * */

    pid_t pid;
    register int np;
    int *datos;

    printf("Ejemplo de procesos \n");
    datos = init_array();
    llenar_arreglo(datos);
    print_array(datos);

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
            proceso_hijo(np, datos);
        }
    }
    proceso_padre();
    free(datos);
    return 0;
}

void proceso_hijo(int np, int *datos)
{
    int mayor, menor;
    // printf("Proceso hijo %d ejecutandose con pid: %d \n", np, getpid());

    if(np == 0)
    {
        mayor = buscar_mayor(datos);
        exit(mayor);
    }
    else if (np == 1)
    {
        menor = buscar_menor(datos);
        exit(menor);
    }
    /* Se regresan los valores comoo parametros de estado a traves de exit*/
    exit(np);
}

void proceso_padre(void)
{
    register int np;
    int estado;
    pid_t pid;

    for(np = 0; np < NUM_PROC; np ++)
    {
        /*Aqui se optiene el resultado con wait
         * Se evita usar otro mecanismo de ipc como
         * Tuberias o memoria compartida */
        pid = wait(&estado);
        printf("Proceso con pid %d y retorno %d \n", pid, estado>>8);
    }
}

int *init_array()
{
    srand(getpid());
    int *array;
    array = (int *)malloc(N * sizeof(int));
    if (!array)
    {
        perror("Error al asignar memoria \n");
        exit(EXIT_FAILURE);
    }
    return array;
}

void llenar_arreglo(int *datos)
{
    register int i;
    for(i=0; i < N; i++)
    {

        datos[i] = rand() % 256;
    }
}

void print_array(int *datos)
{
    register int i;
    for(i = 0; i < N; i++)
    {
        if(!(i % 16))
            printf("\n");
        printf("%3d ", datos[i]);
    }
    printf("\n\n");
}

int buscar_mayor(int *datos)
{
    register int i;
    int mayor = datos[0];
    for(i = 1; i < N; i++)
    {
        if(datos[i] > mayor)
            mayor = datos[i];
    }
    return mayor;
}

int buscar_menor(int *datos)
{
    register int i;
    int menor = datos[0];
    for(i = 1; i <N; i++)
    {
        if(datos[i] < menor)
            menor = datos[i];
    }
    return menor;
}
