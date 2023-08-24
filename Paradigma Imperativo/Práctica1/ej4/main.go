package main

import (
	"fmt"
)

// Estructura para representar un zapato
type calzado struct {
	modelo   string
	precio   float64
	talla    int
	cantidad int
}

type listaCalzado []calzado

var lCalzado listaCalzado

func (l *listaCalzado) agregarCalzado(modelo string, cantidad int, precio float64, talla int) {
	// modificar el código para que cuando se agregue un calucto, si este ya se encuentra, incrementar la cantidad
	// de elementos del calucto y eventualmente el precio si es que es diferente
	var cal, err = l.buscarCalzado(modelo)
	if err == -1 {
		*l = append(*l, calzado{modelo: modelo, cantidad: cantidad, precio: precio, talla: talla})
	} else {
		cal.cantidad = cal.cantidad + cantidad
		cal.precio = precio
	}
}

func (l *listaCalzado) buscarCalzado(modelo string) (*calzado, int) { //el retorno es el índice del calucto encontrado y -1 si no existe
	var err = -1
	var i int
	var p *calzado = nil //Es nulo
	for i = 0; i < len(*l); i++ {
		if (*l)[i].modelo == modelo {
			return &((*l)[i]), i
		}
	}
	return p, err
}

func (l *listaCalzado) venderCalzado(modelo string, cantidad int) {
	var cal, err = l.buscarCalzado(modelo)
	if err != -1 {
		//modificar para que cuando no haya existencia de cantidad de calzados, el calzado se elimine de "la lista" y notificar dicha acción
		//modifique posteriormente para que se ingrese de parámetro la cantidad de calzados a vender
		if (cal.cantidad == cantidad && err != -1) || (cal.cantidad < cantidad && err != -1) {
			lCalzado = append(lCalzado[:err], lCalzado[err+1:]...)
			cal.cantidad = cal.cantidad - cal.cantidad
			fmt.Println("Zapato", cal.modelo, "eliminado debido a que se agotaron las existencias")
			cal = nil
		} else if cal.cantidad > cantidad && err != -1 {
			cal.cantidad = cal.cantidad - cantidad
		} else {
			fmt.Println("No existe ese zapato")
		}
	}
}

func llenarDatos() {
	lCalzado.agregarCalzado("Nike Air", 10, 50000, 42)
	lCalzado.agregarCalzado("Adidas UltraBoost", 5, 60000, 40)
	lCalzado.agregarCalzado("Puma Classic", 8, 45000, 38)
	lCalzado.agregarCalzado("Reebok Flex", 7, 55000, 39)
	lCalzado.agregarCalzado("Converse All Star", 12, 40000, 37)
	lCalzado.agregarCalzado("Vans Old Skool", 9, 48000, 41)
	lCalzado.agregarCalzado("New Balance 990", 4, 70000, 42)
	lCalzado.agregarCalzado("Under Armour Hovr", 6, 60000, 44)
	lCalzado.agregarCalzado("Salomon Speedcross", 3, 80000, 43)
	lCalzado.agregarCalzado("Mizuno Wave Rider", 8, 55000, 40)

}

func main() {
	llenarDatos()

	lCalzado.venderCalzado("Nike Air", 3)
	lCalzado.venderCalzado("si", 3)
	lCalzado.venderCalzado("Mizuno Wave Rider", 8)
	lCalzado.venderCalzado("Reebok Flex", 11)
}
