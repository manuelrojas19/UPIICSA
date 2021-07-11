#include <stdio.h>
#include <stdlib.h>
#include <math.h>

#define MUESTRAS 512

void init_sin(float sin[]);
void save_data(float data[]);

int main()
{
    float sin[MUESTRAS];

    /* Inicializa valores de la funcion */

    init_sin(sin);

    /* Guardar los valores de la funcion en un archivo */

    save_data(sin);

    return 0;
}

void init_sin(float sin[])
{
    float f = 1000, fs = 45000;

    /* Especificador register: reserva un registro del procesador en ves de 
     * una direccion de memoria.
     *
     * Jerarquia de memomoria:
     *  - Procesador: Registros (register int n) 
     *    se asigna directamente al registro, el acceso es mas rapido
     *     
     *    Variables candidatas a se colocadas en registros: 
     *       aquellas a las que se accede con mayor frecuencia,
     *       suelen ser las usadas como indices en los ciclos.
     *
     *  - Cache: SRAM
     *
     *  - Principal: DRAM (int n) debe pasar por todo el sistema 
     *    de jerarquia para llegar a los registros
     *
     *  */

    register int n;

    /* Otros especificadores 
     * 
     * - static: variables locales con alcance global. 
     *   Su valor no se pierden cuando salen de la función.
     *
     * - extern: se usa para declarar variables en un modulo
     *   que puedan se usadas en otros modulos.
     *
     *   */

    for(n = 0; n < MUESTRAS; n++) {
        sin[n]= sinf(2 * M_PI * f * n /fs);
    }
}

void save_data(float data[])
{
    FILE *file;
    file = fopen("sin.dat", "w");
    register int n;

    if(file == NULL) 
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
