#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
    int tokens;
    int num_char;

    //size_t argc = sizeof(argv) /sizeof(char*);
 
    for(tokens = 0; tokens < argc; tokens++) {
        if(argv[tokens][0] == '-')
            printf("Opcion: %s \n", argv[tokens] + 1);
        else
            num_char = strlen(argv[tokens]);
            //num_char = sizeof(argv[tokens]) / sizeof(char);
            printf("Argumento %d: %s, numero de caracteres: %d \n", tokens, argv[tokens], num_char);
            num_char = 0;
    } 
    exit(0);

}
