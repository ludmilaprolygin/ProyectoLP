package Tema_4;

public class A {

    static int totalItemsCreados = 0;
    static int limiteProcesamiento = 100;

    int itemId; 
    int cantidadDisponible; 
    int valorUnitario;

    public A() {
        totalItemsCreados++;
        itemId = totalItemsCreados * 100; 
        cantidadDisponible = 50;
        valorUnitario = 10;
    }
    
    public int procesarLote() {
        int itemsProcesados = 0;
        int i = 0;

        int stock = verificarStock();

        while (i < cantidadDisponible & stock >= 0) {
            itemsProcesados += (i % 5) + 1; 
            if (itemsProcesados > limiteProcesamiento) {
                break;
            }
            i = i+1;
        }
        cantidadDisponible = cantidadDisponible - (itemsProcesados / 2); 
        if (cantidadDisponible < 0) {
            cantidadDisponible = 0;
        }
        return itemsProcesados;
    }

    public int obtenerInformacion(int tipoInfo) {
        if (tipoInfo == 1) {
            return itemId;
        }
        return valorUnitario * cantidadDisponible + tipoInfo;
    }

    public int obtenerValorUnitario(){
        return valorUnitario;
    }
    
    public int verificarStock() {
        if (cantidadDisponible > 20 && valorUnitario > 5) {
            return 1;
        }
        if (cantidadDisponible <= 20 || cantidadDisponible > 0) {
            return 0;
        }
        return -1;
    }
}