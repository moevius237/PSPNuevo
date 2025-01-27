package UD3.networking.ejer2;

import java.util.HashMap;
import java.util.Map;

public class Sala {
    private Map<Integer,String> butacas = new HashMap<>();

    public int insertarButaca(String id){
        synchronized (butacas) {
            if (butacas.size() <= 30){
                butacas.put(butacas.size()+1,id);
                return 200;
            }else {
            return 303;
            }
        }
    }
}
