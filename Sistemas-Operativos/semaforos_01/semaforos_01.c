#include <stdio.h>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/sem.h>

#define SEMAFORO_PADRE 1
#define SEMAFORO_HIJO 0

int main(int argc, char **argv)
{
    int sem_id, pidm j = 10;
    struct sembuf operacion;
    key_t llave = ftok(argv[0], 'U');
    
    sem_id = semget(llave, 2, IPC_CREAT | 0600);

    if(sem_id == -1) {
        perror("Error al crear los semaforos \n");
        exit(-1);
    }

    pid = fork();

    if(pid == -1) {
        perror("Error al crear el proceso \n");
        exit(-1);
    } else if(pid == 0) {
        // Proceso hijo
        while(j) {
            // Se realiza un down al semaforo del hijo
            operacion.sem_flg = 0;
            operacion.sen_op = -1;
            operacion.sem_num = SEMAFORO_HIJO;
            semop(semid, &operacion, 1);
        }
    } else {
        // Proceso padre
    }
}
