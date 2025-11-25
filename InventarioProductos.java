import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class InventarioProductos {

    List<Producto> inventario;

    public void predefinir(){
        Producto e1=new Producto(1,"MANZANA",2.90);
        Producto e2=new Producto(2,"PERA", 2.50);
        Producto e3=new Producto(3,"CHOCOLATE",2.60);
        Producto e4=new Producto(4,"LECHE",2.70);
        Producto e5=new Producto(5,"HUEVOS",1.80);

        inventario.add(e1);
        inventario.add(e2);
        inventario.add(e3);
        inventario.add(e4);
        inventario.add(e5);
    }

    public InventarioProductos(){
        inventario=new ArrayList<Producto>();
        predefinir();
    }

    public List<Producto> getInventario() {
        return inventario;
    }

    public void agregar (Producto producto){
        inventario.add(producto);
    }

    public List<Producto> todos(){
        return inventario;
    }

    // ==========================================================
    // ORDENAR POR PRECIO (Método burbuja)
    // ==========================================================
    public void ordenar(){
        Producto aux;
        for(int i=0; i<inventario.size()-1; i++){
            for(int j=i+1; j<inventario.size(); j++){
                if(inventario.get(i).getPrecio()>inventario.get(j).getPrecio()){
                    aux=inventario.get(i);
                    inventario.set(i,inventario.get(j));
                    inventario.set(j,aux);
                }
            }
        }
    }

    // ==========================================================
    // ORDENAR POR ID (también burbuja
    // ==========================================================
    public void ordenarID(){
        Producto aux;
        for(int i=0; i<inventario.size()-1; i++){
            for(int j=i+1; j<inventario.size(); j++){
                if(inventario.get(i).getId()>inventario.get(j).getId()){
                    aux=inventario.get(i);
                    inventario.set(i,inventario.get(j));
                    inventario.set(j,aux);
                }
            }
        }
    }

        //busqueda binaria por nombre
    public Producto buscarBinarioPorNombre(String nombre) {
        int i = 0;
        int s = inventario.size() - 1;
        int c;

        while (i <= s) {
            c = (i + s) / 2;
            String actual = inventario.get(c).getNombre();

            if (actual.equalsIgnoreCase(nombre)) {
                return inventario.get(c);
            } else if (actual.compareToIgnoreCase(nombre) > 0) {
                s = c - 1;
            } else {
                i = c + 1;
            }
        }
        return null;//1
    }

     //busqueda por precio binaria
    public Producto buscarBinarioPorPrecio(double precio) {
        int i = 0;
        int s = inventario.size() - 1;
        int c;

        while (i <= s) {
            c = (i + s) / 2;
            double actual = inventario.get(c).getPrecio();

            if (actual == precio) {
                return inventario.get(c);
            } else if (precio < actual) {
                s = c - 1;
            } else {
                i = c + 1;
            }
        }
        return null;
    }
    //busqueda por precio lineal

    public Producto buscarPorPrecio(double precio) {
        for (Producto p : inventario) {
            if (p.getPrecio() == precio) {
                return p;
            }
        }
        return null;
    }
    //ordenar por precio 
    public void ordenarPorPrecio() {
        Producto aux;
        for (int i = 0; i < inventario.size() - 1; i++) {
            for (int j = i + 1; j < inventario.size(); j++) {
                if (inventario.get(i).getPrecio() > inventario.get(j).getPrecio()) {
                    aux = inventario.get(i);
                    inventario.set(i, inventario.get(j));
                    inventario.set(j, aux);
                }
            }
        }
    }


    // ==========================================================
    // NUEVO: ORDENAR POR NOMBRE (método burbuja)
    // ==========================================================
    public void ordenarPorNombre() {
        Producto aux;
        for(int i=0; i<inventario.size()-1; i++){
            for(int j=i+1; j<inventario.size(); j++){
                // compareTo compara alfabéticamente
                if(inventario.get(i).getNombre().compareTo(inventario.get(j).getNombre()) > 0){
                    aux = inventario.get(i);
                    inventario.set(i, inventario.get(j));
                    inventario.set(j, aux);
                }
            }
        }
    }

    // ==========================================================
    // BÚSQUEDA BINARIA POR ID
    //
    // ==========================================================
    public Producto buscarPorIdBinario(int id) {
        int i = 0;
        int s = inventario.size() - 1;
        int c;

        while (i <= s) {
            c = (i + s) / 2;
            int idActual = inventario.get(c).getId();

            if (idActual == id) {
                return inventario.get(c); // encontrado
            }
            else if (id < idActual) {
                s = c - 1;
            }
            else {
                i = c + 1;
            }
        }
        return null; // no encontrado
    }

    // ==========================================================
    // NUEVO: BÚSQUEDA LINEAL POR ID
    //
    // ==========================================================
    public Producto buscarIdLineal(int idBuscado){
        for(Producto p : inventario){
            if(p.getId() == idBuscado){
                return p; // encontrado
            }
        }
        return null; // no existe
    }


    // ==========================================================
    // BÚSQUEDA LINEAL POR NOMBRE
    // ==========================================================
    public Producto buscar(String nombre) {
        for (Producto p : inventario) {
            if (p.getNombre().equals(nombre)) {
                return p;   // lo encontró
            }
        }
        return null; // no existe
    }

}
