package Tema_4;

public class Principal {
    public static void main(String[] args) {
        int solicitudInicial = Sistema.read(); 
        int prioridadOrden = Sistema.read();

        C gestorPrincipal = new C(100); 

        Sistema.print(gestorPrincipal.obtenerInformacion(prioridadOrden));
        
        Sistema.print(gestorPrincipal.procesarLote()); 
        
        System.out.println("------------------------");
        System.out.println(gestorPrincipal.toString());
        System.out.println("------------------------");
        
        Sistema.print(gestorPrincipal.cumplirOrdenCompleja(solicitudInicial * solicitudInicial * prioridadOrden));
    
        System.out.println("------------------------");
        System.out.println(gestorPrincipal.toString());
      
    }
}