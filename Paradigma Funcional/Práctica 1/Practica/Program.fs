open System.Text
open System

//Ejercicio 1
let desplazar (direccion: string) (posiciones: int) (lista: 'int list) =
    if posiciones > lista.Length then 
        let posiciones = lista.Length
        if direccion = "izq" then 
            let listaDer = List.init posiciones (fun _ -> 0)
            let listaIzq = List.skip (posiciones) lista
            listaIzq @ listaDer
        else if direccion = "der" then 
            let listaDer = List.take (posiciones) lista
            let listaIzq = List.init posiciones (fun _ -> 0)
            listaIzq @ listaDer
        else lista
    else
        if direccion = "izq" then 
            let listaDer = List.init posiciones (fun _ -> 0)
            let listaIzq = List.skip (posiciones) lista
            listaIzq @ listaDer
        else if direccion = "der" then 
            let listaDer = List.take (lista.Length-posiciones) lista
            let listaIzq = List.init posiciones (fun _ -> 0)
            listaIzq @ listaDer
        else lista
            
//Ejercicio 2
let contieneSubcadena (subcadena : string) (cadena : string) =
    let separadores = [|' '|]
    let subcadenaActual = cadena.Split(separadores, StringSplitOptions.RemoveEmptyEntries)
    let subcadenafinal = subcadenaActual |> Array.toList
    subcadenafinal |> List.contains subcadena

let sub_cadenas (subcadena: string) (cadena: string list) =
    let cadenas = List.filter (fun cadeni -> contieneSubcadena subcadena cadeni) cadena
    cadenas

//Ejercicio 3
let n_esimo (n : int) (lista : 'a list) =
    let indices = [0 .. List.length lista - 1]
    let elemento = 
        indices
        |> List.map (fun i -> if i = n then (List.item i lista) else -1)
    let elementoFinal = elemento |> List.max
    elementoFinal

//Ejercicio 4
type VerticeConPeso = string * int

let miembro elem lista =
    List.exists (fun x -> x = elem) lista

let rec vecinosConPesos nodo grafo =
    match grafo with
    | [] -> []
    | (head, neighbors, weights) :: rest ->
        if head = nodo then List.zip neighbors weights
        else vecinosConPesos nodo rest

let extenderConPesos ruta grafo = 
    List.filter (fun x -> x <> [])
    (
        List.map  
            (fun (vecino, peso) -> 
                if (miembro vecino ruta) then [] 
                else (vecino, peso)::ruta
            ) 
            (vecinosConPesos (fst (List.head ruta)) grafo)
    )

let rec profCaminoMasCorto ini fin grafo =
    let rec prof_aux_camino_mas_corto fin ruta grafo =
        if List.isEmpty ruta then []
        elif (fst (List.head ruta)) = fin then
            List.rev ruta
        else
            let caminosExtendidos = extenderConPesos ruta grafo
            let caminoMenorPeso =
                caminosExtendidos
                |> List.filter (fun camino -> not (List.isEmpty camino))
                |> List.minBy (fun camino -> List.sumBy snd camino)
            prof_aux_camino_mas_corto fin (caminoMenorPeso :: ruta) grafo
    prof_aux_camino_mas_corto fin [(ini, 0)] grafo


//Ejercicio 5
type LaberintoCasilla =
    | Libre
    | Pared

type Laberinto = LaberintoCasilla[][]

let grafoLaberinto laberinto =
    let numRows = Array.length laberinto
    let numCols = Array.length laberinto.[0]

    let esCasillaValida (fila, col) =
        fila >= 0 && fila < numRows && col >= 0 && col < numCols

    let vecinosCasilla (fila, col) =
        [
            (fila - 1, col);
            (fila, col + 1); 
            (fila + 1, col); 
            (fila, col - 1)  
        ]
        |> List.filter esCasillaValida

    let esLibre (fila, col) =
        laberinto.[fila].[col] = Libre

    let grafo = 
        [ for fila in 0 .. numRows - 1 do
            for col in 0 .. numCols - 1 do
                if esLibre (fila, col) then
                    let vecinosLibres = vecinosCasilla (fila, col) |> List.filter esLibre
                    (fila * numCols + col + 1, vecinosLibres |> List.map (fun (f, c) -> f * numCols + c + 1))
                else
                    (-1, []) ]
        |> List.filter (fun (vertice, _) -> vertice <> -1)
    grafo

let buscarRutas laberinto inicio fin =
    let grafo = grafoLaberinto laberinto

    let rec extender ruta grafo =
        List.map (fun (vecino, _) -> vecino::ruta) (grafo |> List.filter (fun (v, _) -> v = List.head ruta))

    let rec prof ruta fin grafo =
        if List.isEmpty ruta then []
        elif List.head ruta = fin then [List.rev ruta]
        else
            let caminosExtendidos = extender ruta grafo
            List.collect (fun camino -> prof camino fin grafo) caminosExtendidos

    prof [inicio] fin grafo

let encontrarRutaMasCorta rutas =
    if List.isEmpty rutas then None
    else
        rutas
        |> List.minBy (fun ruta -> List.length ruta)

// Ejemplos de uso
let lista = [1; 2; 3; 4; 5]
printfn "%A" (desplazar "izq" 3 lista)
printfn "%A" (desplazar "der" 2 lista)
printfn "%A" (desplazar "izq" 6 lista)

printfn "%A" (sub_cadenas "la" ["la casa"; "el perro"; "pintando la cerca"])

printfn "%i"n_esimo 2 lista

printfn "%i" n_esimo 3 lista

printfn "%i" n_esimo 6 lista