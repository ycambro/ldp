package main

import (
	"fmt"
)

func printStars(actualSpaces int, actualLineElements int, centerLineElements int) {
	count := 0
	for i := 1; i < centerLineElements || count < actualLineElements; i++ {
		if i >= actualSpaces && count != actualLineElements {
			fmt.Printf("* ")
			count++
		} else if i >= actualSpaces && count == actualLineElements {
			fmt.Printf("*")
			count++
		} else {
			fmt.Printf(" ")
		}
	}
	fmt.Println("")
}

func main() {
	var centerLineElements int
	fmt.Printf("Ingrese el numero de elementos de la linea del centro de la figura: ")
	for i := 1; i != 0; i++ {
		fmt.Scanln(&centerLineElements)
		fmt.Println()
		if centerLineElements%2 != 0 {
			break
		} else {
			fmt.Printf("Ingrese nuevamente el numero, debe ser impar positivo: ")
		}
	}
	var stars []int

	for i := centerLineElements; i >= 1; i -= 2 {
		stars = append(stars, i)
	}

	spaces := centerLineElements
	for i := len(stars); i >= 1; i-- {
		printStars(spaces, stars[i-1], centerLineElements)
		spaces -= 2
	}

	spaces += 2

	for i := 1; i <= len(stars)-1; i++ {
		spaces += 2
		printStars(spaces, stars[i], centerLineElements)
	}

}
