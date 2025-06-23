package Tema_4;

public class B extends A {

    int ubicacionAlmacen;
    int tipoProducto; 

    public B() {
        super();
        ubicacionAlmacen = 1000 + itemId; 
        tipoProducto = (itemId % 2) + 1; 
    }
    
    public String toString()
    {
      return super.toString() + "ubicacionAlmacen: " + ubicacionAlmacen + "\n" +
        "tipoProducto: " + tipoProducto + "\n";
    }

    public int procesarLote() {
        int resultadoBase = super.procesarLote();
        int ajuste = 0;

        switch (tipoProducto) {
            case 1: 
                ajuste = resultadoBase / 2;
                break;
            case 2: 
                ajuste = resultadoBase * 2;
                break;
            default:
                ajuste = resultadoBase;
                break;
        }
        cantidadDisponible = cantidadDisponible - (ajuste / 5);
        return resultadoBase + ajuste;
    }

    public int manejarPedido(int cantidadSolicitada) {
        if (cantidadSolicitada <= 0) {
            return 0;
        }
        if (cantidadSolicitada <= cantidadDisponible) {
            cantidadDisponible -= cantidadSolicitada;
            return cantidadSolicitada * valorUnitario; 
        }
        return -1;
    }

    public int manejarPedido(int cantidadSolicitada, int prioridad) {
        int costo = this.manejarPedido(cantidadSolicitada);
        if (costo > 0 && prioridad > 5) { 
            return costo + (costo / 10);
        }
        return costo;
    }

    public int obtenerInformacion(int tipoInfo) {
        if (tipoInfo == 1) {
            return super.obtenerInformacion(tipoInfo) + ubicacionAlmacen;
        }
        return tipoProducto * valorUnitario + tipoInfo;
    }

    public int obtenerValorUnitario() {
        return super.obtenerValorUnitario() + (tipoProducto * 2);
    }
}