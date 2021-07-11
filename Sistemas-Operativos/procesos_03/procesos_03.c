#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#define NUM_PROC 5

FILE *file;

void proceso_hijo(int np);

int main()
{
    pid_t pid[NUM_PROC];
    register int np;

    file = fopen("hola.txt", "w");

    if (!file) {
        perror("Error al abrir el archivo \n");
        exit(EXIT_FAILURE);
    }
    
    for (np = 0; np < NUM_PROC; np++) {
        pid[np] = fork();
        if (pid[np] == -1) {
            perror("Error al crear el proceso \n");
            exit(EXIT_FAILURE);
        }
        if (!pid[np]) {
            proceso_hijo(np);
        }
    }
    for (np = 0; np < NUM_PROC; np++)
        wait(NULL);
    fprintf(file, "uno. \n");
    fclose(file);
    return 0;
}

void proceso_hijo(int np)
{
    if (np == 0) {
        fprintf(file, "Hola ");
    } else if (np == 1) {
        fprintf(file, "esta ");
    } else if (np == 2) {
        fprintf(file, "es ");
    } else if (np == 3) {
        fprintf(file, "mi ");
    } else if (np == 4) {
        fprintf(file, "practica ");
    }
    exit(np);
}
