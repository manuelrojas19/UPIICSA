#include<stdio.h>
#include<stdlib.h>

typedef struct nodo Nodo;
struct nodo
{
    int *dato;
    Nodo *siguiente;
};

typedef struct pila Pila;
struct pila{
    Nodo *tope;
    int size;
};

void init(Pila **pila);
int push(Pila *pila, int *dato);
int pop(Pila *pila);
void show(Pila *pila);

int main(int argc, char **argv) {
    Pila *pila;
    int *dato1, *dato2,*dato4,*dato5,*dato6,*dato7,*dato8, *dato3, *dato9;
    dato1 = (int *)malloc(sizeof(int));
    dato2 = (int *)malloc(sizeof(int));
    dato3 = (int *)malloc(sizeof(int));
    dato4 = (int *)malloc(sizeof(int));
    dato5 = (int *)malloc(sizeof(int));
    dato6 = (int *)malloc(sizeof(int));
    dato7 = (int *)malloc(sizeof(int));
    dato8 = (int *)malloc(sizeof(int));
    dato9 = (int *)malloc(sizeof(int));
    printf("Agregando valores a la pila \n");
    init(&pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato1);
    push(pila, dato1);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato2);
    push(pila, dato2);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato3);
    push(pila, dato3);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato4);
    push(pila, dato4);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato5);
    push(pila, dato5);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato6);
    push(pila, dato6);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato7);
    push(pila, dato7);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato8);
    push(pila, dato8);
    show(pila);
    printf("Valor[%d]: ", pila -> size);
    scanf("%d", dato9);
    push(pila, dato9);
    show(pila);
    printf("Extrayendo valores a la pila \n");
    int datoA = pop(pila);
    printf("Valor extrído: %d \n", datoA);
    show(pila);
    int datoB = pop(pila);
    printf("Valor extrído: %d \n", datoB);
    show(pila);
    int datoC = pop(pila);
    printf("Valor extrído: %d \n", datoC);
    show(pila);
    int datoD = pop(pila);
    printf("Valor extrído: %d \n", datoD);
    show(pila);
    int datoE = pop(pila);
    printf("Valor extrído: %d \n", datoE);
    show(pila);
    int datoF = pop(pila);
    printf("Valor extrído: %d \n", datoF);
    show(pila);
    int datoG = pop(pila);
    printf("Valor extrído: %d \n", datoG);
    show(pila);
    int datoH = pop(pila);
    printf("Valor extrído: %d \n", datoH);
    show(pila);
    int datoI = pop(pila);
    printf("Valor extrído: %d \n", datoI);
    show(pila);
}

void init(Pila **pila) {
    (*pila) = (Pila *)malloc(sizeof(pila));
    (*pila) -> tope = NULL;
    (*pila) -> size = 0;
}

int push(Pila *pila, int *dato) {
    Nodo *nuevo_elemento;
    nuevo_elemento = (Nodo *)malloc(sizeof(Nodo));
    nuevo_elemento -> dato = (int *)malloc(sizeof(int));
    nuevo_elemento -> dato = dato;
    nuevo_elemento -> siguiente = pila -> tope;
    pila -> tope = nuevo_elemento;
    pila -> size++;
    return 1;
}

int pop(Pila *pila) {
    Nodo *tope;
    int dato;
    if(pila -> size == 0) {
        return -1;
    } else {
        tope = pila -> tope;
        pila -> tope = pila -> tope -> siguiente;
        pila -> size--;
        dato = *tope -> dato;
        free(tope);
    }
    return dato;
}

void show(Pila *pila) {
    Nodo *actual;
    int i;
    actual = pila -> tope;
    printf("Tamaño de la pila: %d \n", pila -> size);
    for (i = 0; i < pila -> size; i++) {
        printf("%d\n", *(actual -> dato));
        actual = actual -> siguiente;
    }
}
