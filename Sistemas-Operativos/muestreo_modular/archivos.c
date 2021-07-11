/** @brief archivos.c
 *
 * Este programa guarda un arreglo
 * de datos en un archivo .dat
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include "defs.h"

void save_data(float data[])
{
    FILE *file;
    register int n;

    file = fopen("sin.dat", "w");

    if(!file)
    {
        perror("Error al abrir el archivo");
        exit(EXIT_FAILURE);
    }

    for(n = 0; n < MUESTRAS; n++)
    {
        fprintf(file, "%f \n", data[n]);
    }

    fclose(file);
    
}
