# Archivo Makefile simple
PROYECTO=hpc_04
DESTDIR=/usr/local/bin
CFLAGS=-Wall
LFLAGS=-lm -lpthread
CC=gcc
#SRCS := $(wildcard *.c)
#OBJS := $(SRCS:c=o)
OBJS := $(patsubst %.c,%.o,$(wildcard *.c))

all: $(PROYECTO)

# $< indica que tomara el nombre la primera dependencia, lado derecho
# En shell se puede poner *.c, no es reconocido en make
%.o: %.c
	$(CC) $(CFLAGS) -c $<

# muestreo.o: muestreo.c
#	$(CC) $(CFLAGS) -c muestreo.c

# procesamiento.o: procesamiento.c
#	$(CC) $(CFLAGS) -c procesamiento.c

#archivos.o: archivos.c
#	$(CC) $(CFLAGS) -c archivos.c

# $^ indica que se tomara todos los nombres de la lista de las dependencias
# $@ indica que se tomara el nombre del objetivo de la regla

#$(PROYECTO): muestreo.o procesamiento.o archivos.o

$(PROYECTO): $(OBJS)
	$(CC) -o $@ $(LFLAGS) $^

#$(PROYECTO): muestreo.o procesamiento.o archivos.o
#	$(CC) -o $(PROYECTO) $(LFLAGS) muestreo.o procesamiento.o archivos.o


# Evita conflictos con archivos con el mismo nombre
# que los objetivos falsos
.PHONY: clean

install: all
	if [ ! -d $(DESTDIR) ] ; then \
		sudo mkdir $(DESTDIR) ; \
	fi; \
	sudo cp $(PROYECTO) $(DESTDIR)

uninstall:
	sudo rm $(DESTDIR)/$(PROYECTO)

clean: 
	rm -f *.o $(PROYECTO)

# Willcard uso del asterisco
# Funciones para el analisis y sustitucion de cadena
