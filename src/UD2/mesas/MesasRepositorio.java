package UD2.mesas;

/**
 * Metodos que solo se pueden usar en metodos o bloques sincronizados
 * Wait(),notify y notifyALL();
 * Consumer , Producer -> algunos producen cosas y otras las consumen
 */
public class MesasRepositorio {
    private String message;
    private boolean hasMessage;

    //Estan bloqueados
    //Tenemos un deadlock
    //El problema es que lo coge y nunca lo suelta
    public synchronized String quitar(){
            while (!hasMessage) {
                try {
                    wait();//Libera el bloqueo y se queda suspendido
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            hasMessage = false;
            notify();
            return message;

    }
    public synchronized void Poner(String mensaje){
        while (hasMessage){
            try {
                wait();//Libera el bloqueo y se queda suspendido
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        hasMessage=true;
        notify();
        this.message=mensaje;
    }
}
