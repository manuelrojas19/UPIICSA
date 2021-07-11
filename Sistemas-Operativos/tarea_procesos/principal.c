#include <stdio.h>
#include <stdlib.h>
#include "defs.h"
#include "helper.h"
#include "procesos.h"
#include "procesamiento.h"

int main()
{
    int *data;

    reservar_memoria(&data);
    llenar_arreglo(data);
    imprimir_arreglo(data);

    procesos(data);
    // Esta funcion incluye la funcion de proceso padre e hijo
    // procesos(data);

    free(data);

    return 0;
}
