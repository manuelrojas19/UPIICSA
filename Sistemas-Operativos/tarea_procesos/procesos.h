/** @brief procesos.h
* Contiene funciones para reserver memoria,
* llenar e imprimir el arreglo 
*/

#ifndef PROCESOS_H
#define PROCESOS_H

#include "defs.h"

void procesos(int *data);
void proceso_padre(int pipe_fd[NUM_PROC][2]);
void proceso_hijo(int np, int *data, int pipe_fd[]);

#endif