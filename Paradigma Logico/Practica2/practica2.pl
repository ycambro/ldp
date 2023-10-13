conectado(i,2).
conectado(2,3).
conectado(2,8).
conectado(8,9).
conectado(9,3).
conectado(3,4).
conectado(4,10).
conectado(10,16).
conectado(16,22).
conectado(22,21).
conectado(21,15).
conectado(15,14).
conectado(14,13).
conectado(13,7).
conectado(7,1).
conectado(14,20).
conectado(20,26).
conectado(22,28).
conectado(26,27).
conectado(27,28).
conectado(28,29).
conectado(29,23).
conectado(23,17).
conectado(17,11).
conectado(11,5).
conectado(1,7).
conectado(5,6).
conectado(28,34).
conectado(34,35).
conectado(35,36).
conectado(36,30).
conectado(30,24).
conectado(24,18).
conectado(18,12).
conectado(32,31).
conectado(31,25).
conectado(25,19).
conectado(34,33).
conectado(33,32).
conectado(32,f).

persona(juan, 'Perez', [0,1,1,0,1,0,1,1,0,1]).
persona(maria, 'Gomez', [1,1,0,0,1,0,1,1,1,0]).
persona(luis, 'Rodriguez', [1,0,1,1,0,0,0,1,1,0]).

%Ejercicio 1
ruta(X,Y,L):- ruta_aux(X,Y,[],L).

ruta_aux(X,X,L,LFinal):- reverse(L,LFinal).
ruta_aux(X,Y,L,Resultado):-
	conectado(X,X1),
	not(member(X1,L)),
	ruta_aux(X1,Y,[X|L],Resultado).

todas_rutas(X,Y,LRutas):- findall(R,ruta(X,Y,R),LRutas).

longitud([], 0).
longitud([_|T], L) :- longitud(T, L1), L is L1 + 1.

ruta_mas_corta(X, Y, RutaMasCorta) :-
    todas_rutas(X, Y, LRutas),
    calcular_ruta_mas_corta(LRutas, RutaMasCorta).

calcular_ruta_mas_corta([Ruta], Ruta).
calcular_ruta_mas_corta([Ruta|RestoRutas], RutaMasCorta) :-
    calcular_ruta_mas_corta(RestoRutas, RutaMasCortaResto),
    longitud(Ruta, LongitudRuta),
    longitud(RutaMasCortaResto, LongitudRutaMasCortaResto),
    (LongitudRuta < LongitudRutaMasCortaResto -> RutaMasCorta = Ruta; RutaMasCorta = RutaMasCortaResto).

% Ejercicio 2
similitud_cromosomas([], [], 0).
similitud_cromosomas([H1|T1], [H2|T2], Similitud) :-
    similitud_cromosomas(T1, T2, RestoSim),
    (H1 = H2 -> Similitud is RestoSim + 1; Similitud is RestoSim).

cromosomas(Muestra, Persona) :-
    persona(Persona, _, CromosomasPersona),
    similitud_cromosomas(Muestra, CromosomasPersona, Similitud),
    \+ ((persona(OtraPersona, _, CromosomasOtraPersona),
         OtraPersona \= Persona,
         similitud_cromosomas(Muestra, CromosomasOtraPersona, SimOtraPersona),
         SimOtraPersona > Similitud)).

ejemplo :-
    Muestra = [1,0,1,0,0,1,1,0,1,0],
    writeln('Muestra:'),
    writeln(Muestra),
    writeln('Persona mas parecida a la muestra:'),
    cromosomas(Muestra, Persona),
    writeln(Persona),
    writeln('Ruta mas corta entre i y f:'),
    ruta_mas_corta(i, f, RutaMasCorta),
    writeln(RutaMasCorta).
