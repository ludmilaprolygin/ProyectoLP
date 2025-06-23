package Tema_4;

public class C extends B {

    B productoPrincipal;
    int numeroOrden; 

    public C(int ordenId) {
        super(); 
        numeroOrden = ordenId;
        inicializarProductoPrincipal();
    }
    
    public String toString()
    {
      return super.toString() + "\n\nproductoPrincipal: " + 
        productoPrincipal.toString() + "\n\n" +
        "numeroOrden: " + numeroOrden;
    }

    public void inicializarProductoPrincipal(){
        productoPrincipal = new B();
    }
    
    public int cumplirOrdenCompleja(int cantidadNecesaria) {
        int itemsFaltantes = cantidadNecesaria;
        int vecesProcesado = 0;
        int costoTotal = 0;

        do {
            int procesadoAhora = productoPrincipal.manejarPedido(itemsFaltantes / 2);
            if (procesadoAhora == -1) { 
                procesadoAhora = productoPrincipal.manejarPedido(itemsFaltantes); 
            }

            if (procesadoAhora > 0) {
                costoTotal += procesadoAhora;
                itemsFaltantes -= (procesadoAhora / productoPrincipal.obtenerValorUnitario());
            } else { 
                break;
            }
            vecesProcesado++;
        } while (itemsFaltantes > 0 && vecesProcesado < 5); 

        if (itemsFaltantes > 0) {
            return -costoTotal;
        }
        return costoTotal;
    }

    
}