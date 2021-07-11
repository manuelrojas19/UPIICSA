/** @brief procesamiento.c
 *  Este programa genera una
 *  señal senoidal con frecuencia
 *  fundamental f y de muestreo 
 *  fs
 *
 */
#include <stdio.h>
#include <math.h>
#include "defs.h"

void init_sin(float sin[])
{
    float f = 100, fs = 450000;
    register int n;

    for(n = 0; n < MUESTRAS; n++)
        sin[n] = sinf(2 * n * M_PI * f / fs);
}

