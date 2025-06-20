# Preguntas sobre código SimplON

## [ ] Pregunta 1

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

## [ ] Pregunta 2
Vale la pena agregar una etiqueta para resolver mod?
Considerando el siguiente pseudocodigo:
```
public int mod (int numerador, int denominador){
    return numerador - (numerador / denominador);
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