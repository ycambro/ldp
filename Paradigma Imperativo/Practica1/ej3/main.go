package main

import "fmt"

func main() {
	secuencia := []string{"a", "b", "c", "d", "e", "f", "g", "h"}
	fmt.Println(secuencia)

	var rotaciones int
	var direccion int
	fmt.Printf("Ingrese el numero de rotaciones que desea realizar: ")
	for i := 1; i != 0; i++ {
		fmt.Scanln(&rotaciones)
		if rotaciones > 0 {
			break
		} else {
			fmt.Printf("Ingrese nuevamente el numero, debe ser positivo: ")
		}
	}

	fmt.Printf("Ingrese 1 si desea rotar a la izquierda o 2 si desea rotar a la derecha: ")
	for i := 1; i != 0; i++ {
		fmt.Scanln(&direccion)
		if direccion <= 2 && direccion >= 1 {
			break
		} else {
			fmt.Printf("Ingrese nuevamente el numero, debe ser 1 o 2: ")
		}
	}

	rotar(secuencia, rotaciones, direccion)

}

func rotar(secuencia []string, cantRotaciones int, dir int) {
	if dir == 1 {
		for i := 1; i <= cantRotaciones; i++ {
			mover := secuencia[0]
			secuencia = append(secuencia[:0], secuencia[1:]...)
			secuencia = append(secuencia, mover)
		}
		fmt.Println(secuencia)
	} else {
		lenSecuencia := len(secuencia) - 1
		for i := 1; i <= cantRotaciones; i++ {
			secuencia = append(secuencia[lenSecuencia:], secuencia[:lenSecuencia]...)
		}
		fmt.Println(secuencia)
	}
}
