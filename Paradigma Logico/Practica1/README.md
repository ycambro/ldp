# Práctica de Lenguajes – Paradigma Logico
## Ejercicios

### Notas
- ­	­Los siguientes ejercicios pretenden propiciar el entendimiento del lenguaje lógico Prolog.

- ­	­Los ejercicios deben ser implementados por el/la estudiante y no utilizar otras funciones que existan que lo realicen ya en Prolog (si es que existe)

## Ejercicio 1
Defina sumlist(L, S) que es verdadero si S es la suma de los elementos de L.

## Ejercicio 2
Defina la relación subconj(S, S1), donde S y S1 son listas representando conjuntos, que es verdadera si S1 es subconjunto de S.

## Ejercicio 3
Defina la función aplanar(L,L2). Esta función recibe una lista con múltiples listas anidadas como elementos otra lista que contendría los mismos elementos de manera lineal (sin listas). 

## Ejercicio 4
Defina un predicado llamado partir(Lista, Umbral, Menores, Mayores) para dividir una lista respecto un umbral dado, dejando los valores menores a la izquierda y los mayores a la derecha. Por ejemplo, el resultado de partir la lista [2,7,4,8,9,1] respecto al umbral 6 serían las listas [2,4,1] y [7,8,9].

## Ejercicio 5
Implemente un predicado que, a partir de una lista de cadenas string, filtre aquellas que contengan una subcadena que el usuario indique en otro argumento. Ej

sub_cadenas(“la”, [“la casa, “el perro”, “pintando la cerca”],Filtradas).
True
Filtradas = [“la casa, “pintando la cerca”]