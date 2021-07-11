#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/shm.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <sys/mman.h>


int main()
{
    /* Nombre del objeto de memoria compartida */
    const char *name = "OS";
    /* Tamaño en bits del objeto de memoria compartida */
    const int size = 4096;
    /* Strings a escribir dentro de la memoria compartida */
    const char *message_0 = "Hola";
    const char *message_1 = "Mundo!";
    /* File descriptor de la memoria compartida */
    int fd;
    /* Apuntador al objeto de memoria compartida*/
    char *ptr;

    /* Creando el objeto de memoria compartida */
    fd = shm_open(name, O_CREAT | O_RDWR, 066);
    
    /* Configurando el tamanio del objeto de memoria compartida */
    ftruncate(fd, size);

    /* Mapeando la memoria del objeto de memoria compartida */
    ptr = (char *)mmap(0, size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

    /* Escrituras para el objeto de memoria compartida */
    sprintf(ptr, "$%s", message_0);
    ptr += strlen(message_0);
    sprintf(ptr, "$%s", message_1);
    ptr += strlen(message_1);
    
    return 0;
}
