### Opcional 3 ~ llamadas encadenadas
```simplOn
llamadoM1
        % SetLibre Libre+1                        @Lugar de retorno m1
        SetD Libre, PC+6                          @PTR de m1
        SetD Libre+1, Actual                      @ED
        % SetD Libre+2, D[Libre-2]                @this
        SetD Libre+2, D[Libre-1]                  @this
```