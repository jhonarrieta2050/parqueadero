package clases.personal;

import java.util.ArrayList;

public class ImprimirInfo {
    public static  <T> void imprimir(ArrayList<T> array){
            array.forEach(c ->{
                System.out.println(c.toString());
            });
    }
}
