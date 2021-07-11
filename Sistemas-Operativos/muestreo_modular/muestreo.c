/** @brief muestreo.c
 *
 * Este programa genera una señal senoidal 
 * y la guarda en un archivo
 *
 */

#include <stdio.h>
#include "defs.h"
#include "archivos.h"
#include "procesamiento.h"

/*
 *  Librerias propias deben ir entre ""
 *  para que el compilador las busque
 *  en la carpeta acutal
 *
 * */

int main()
{
    float sin[MUESTRAS];
    
    /* 
     * Los archivos .h contienen 
     *  - declaraciones de funciones.
     *  - defines: directivas del procesaor.
     *  - plantillas de estructura.
     *
     * Funciones con codigo deben ir en archivos .c
     *
     * */

    init_sin(sin);
    save_data(sin);

    return 0;
}
