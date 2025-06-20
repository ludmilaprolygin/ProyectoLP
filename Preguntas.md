# Preguntas sobre código SimplON

## [ ] Pregunta 1

Me ayudaría a disminuir la posibilidad de meter la pata con el offset del PC y la cantidad de código repetido. Pero no sé si es correcto.

```simplon
volver 
    SetLibre Actual
    SetActual D[Actual+1]   
    Jump D[Libre]

obtenerValorUnitarioA  
    SetD Actual-1, H[D[Actual+2]+3]    
    obtenerValorUnitarioA
    Jump volver

verificarStockA 
    JumpT PC+3, ((H[D[Actual+2]+2] > 20) & (H[D[Actual+2]+3] > 5))
    JumpT PC+4, ((H[D[Actual+2]+2] <= 20) | (H[D[Actual+2]+2] > 0))
    SetD Actual-1, -1  
    Jump volver
    SetD Actual-1, 1    
    Jump volver
    SetD Actual-1, 0    
    Jump volver
```