package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	fmt.Println("Ingrese el texto que desea contar (presione Ctrl+Z en una nueva línea para finalizar la entrada):")

	var lines []string
	scanner := bufio.NewScanner(os.Stdin)
	for scanner.Scan() {
		linea := scanner.Text()
		lines = append(lines, linea)
	}

	texto := strings.Join(lines, "\n")

	caracteres := len(texto)
	palabras := cuentaPalabras(texto)
	lineas := len(lines)

	fmt.Printf("Total de caracteres: %d\n", caracteres)
	fmt.Printf("Total de palabras: %d\n", palabras)
	fmt.Printf("Total de líneas: %d\n", lineas)
}

func cuentaPalabras(texto string) int {
	palabras := strings.Fields(texto)
	return len(palabras)
}
