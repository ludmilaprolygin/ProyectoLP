#### [X] Pregunta 1
Me ayudaría a disminuir la posibilidad de meter la pata con el offset del PC y la cantidad de código repetido. Pero no sé si es correcto.

```simplon
llamador 
    SetLibre Actual
    SetActual D[Actual+1]   
    Jump D[Libre]

obtenerValorUnitarioA  
    SetD Actual-1, H[D[Actual+2]+3]    
    obtenerValorUnitarioA
    Jump llamador

verificarStockA 
    JumpT PC+3, ((H[D[Actual+2]+2] > 20) & (H[D[Actual+2]+3] > 5))
    JumpT PC+4, ((H[D[Actual+2]+2] <= 20) | (H[D[Actual+2]+2] > 0))
    SetD Actual-1, -1  
    Jump llamador
    SetD Actual-1, 1    
    Jump llamador
    SetD Actual-1, 0    
    Jump llamador
```

#### [X] Pregunta 2
Vale la pena agregar una etiqueta para resolver mod?
Considerando el siguiente pseudocodigo:
```
public int mod (int numerador, int denominador){
    return numerador - ((numerador / denominador) * denominador);
}
```
Generaria un RA con:
- PTR
- ED
- numerador
- denominador

``` simplon
mod
    SetD Actual-1, D[Actual+2] - (D[Actual+2] / D[Actual+3])
    % Opcion sin volver
    SetLibre Actual
    SetActual D[Actual+1]   
    Jump D[Libre]
    % Opcion con volver
    Jump llamador
``` 

Supondria agregar esto antes de hacer mod:
```simplon
SetLibre Libre+1            @Lugar retorno
SetD Libre, PC+7            @PTR
SetD Libre+1, Actual        @ED
SetD Libre+2, <Numerador>   @Numerador
SetD Libre+3, <Denominador> @Denominador
SetActual Libre
SetLibre Actual+4      
Jump mod
```

Lo que podria resolver con:
``` simplon
SetD Actual+3, (D[Actual+4] - (D[Actual + 4] / 5))
```

Termina requiriendo:
``` simplon
SetLibre Libre+1 
SetD Libre, PC+7            @PTR
SetD Libre+1, Actual        @ED
SetD Libre+2, D[Actual+4]   @Numerador
SetD Libre+3, 5             @Denominador
SetActual Libre
SetLibre Actual+4
Jump mod
```

#### [X] Pregunta 3
Sobre los CRs... El valor se asigna cuando se ejecuta, pero no hay una instruccion de codigo que haga la asignacion fuera de la declaracion. 
El esquema es sin valor, pero en el codigo si le pongo el valor correspondiente?
```simplon
% CR de totalItemsCreados
    SetLabel CRAtotalItems, Libre
    SetD Libre, 0                                 @totalItemsCreados=0
    SetLibre Libre+1
    SetActual Libre
```

#### [X] Pregunta 4
main es un caso especial en el que no tiene PTR ni ED; puede no ir. Entonces en memoria D, D[Actual] no tiene PTR sino el primer parametro/variable de main. Al terminar main, no podria volver al llamador, pongo Halt al final?
--> No lo hice asi, le puse PTR y ED. Pero si no lo hiciera, como lo resuelvo? Omito llamada main?

#### [X] Pregunta 5
Cuando conviene usar etiquetas, y cuando conviene usar PC+offset?

#### [X] Pregunta 6
General de estructura de la traduccion. Hay alguna convencion para adoptar sobre orden de codigo y etiquetas?

#### [X] Pregunta 7
Sobre el opcional 1... "_Controlar la referencias nulas antes de enviar un mensaje a un objeto_".
Ver LP8 y resolucion del informe.

----- Controlar loc de H en el RA; deberia ser menor PO pero mayor que 0.

Que pasa si lo que hay en el lugar de la variable que referencia al objeto es un numero basura que satisface que sea menor al PO? Es mi responsabilidad vaciar/limpiar el stack o solo digo que puede suceder?

#### [X] Pregunta 8
Hice todos los & y | sin contemplar si funcionaban como && o ||. El enunciado pide ejemplificar con verificarStock de la clase A.
Con cortocircuito puede "traer problemas" porque puede haber efectos colaterales (false && i++ ; true || i++). En el codigo provisto en java no pasa, por lo que si no se hiciera el control entero, _no hay problema_.
- Como funcionan los & y | en simplOn? Sin cortocircuito?
- Como hago el abordaje de la evaluacion respecto de verificarStock contemplando lo anterior?

#### [X] Pregunta 9
Quien deberia responsabilizarse de la gestion de memoria en H? El constructor o el llamador del constructor? Me genero dudas la diapo.

#### [X] Pregunta 10
Casos de prueba relevantes?

#### [X] Pregunta 11
_"Explique intuitivamente cómo resolvió la traducción del mecanismo de selección múltiple del método procesarLote de clase B. *¿Qué dificultades o consideraciones adicionales existen en caso de que se puedan utilizar tipos más complejos (strings, objetos etc.) para su condición?*"_ 
Relacion con la cantidad extra de saltos con accesos a memoria? Un centrito.

----- Chequear el hecho de que tenes que hacer comparacion de valores en H

#### [X] Pregunta 12
Sobre la correccion del constructor y creacion de objetos. Esta bien?

#### [X] Pregunta 13
Como afecta en la traduccion tener modificadores de acceso? 