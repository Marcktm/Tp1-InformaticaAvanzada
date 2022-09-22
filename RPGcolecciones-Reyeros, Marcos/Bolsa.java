import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


/** 
 * Modela la bolsa que utiliza el Personaje para
 * transportar elementos. La capacidad se determina por
 * el peso maximo que soporta.
 * 
 * Todos los objetos se incluyen en un mapa.
 */

public class Bolsa {
    private final int PESO_MAXIMO;
    private int pesoActual;
    private String nombre;
    private Map<String, Elemento> porNombre;

    /**
     * Constructor con parámetros
     * Inicializa las variables de instancia
     * 
     * 
     * No olvidar construir el mapa de elementos (TreeMap), ni
     * setear el peso inicial de la bolsa 
     * 
     * 
     * @param nombre El nombre de la bolsa.
     * @param peso El peso maximo que puede contener la bolsa
     */
    public Bolsa (String nombre, int peso) {
        // TODO - Implementar metodo
        porNombre= new TreeMap<String, Elemento>();
        this.nombre= nombre;
        this.pesoActual= 0;
        PESO_MAXIMO = peso; // Ojo, esta linea no es valida
    }

    /**
     * Agrega un elemento a la bolsa y actualiza el peso total.
     * 
     * Si el elemento no puede agregarse, se debe imprimir el
     * mensaje;
     * 
     *  "<nombre>: No se puede agregar <elemento>"
     * 
     * donde <nombre> es el nombre de la bolsa y <elemento> es el
     * nombre del elemento a agregar.
     * 
     * No se puede agregar un elemento si 
     *         - su peso excede el limite de la bolsa
     *         - existe un elemento con el mismo nombre
     * 
     * @param obj El elemento a agregar en la bolsa.
     */
    public void addElemento (Elemento obj) {
        // TODO - Implementar metodo
        if( (this.pesoActual + obj.getPeso()) > PESO_MAXIMO || porNombre.containsKey(obj.getNombre()) ){
            System.out.println(this.nombre + ": No se puede agregar " + obj.getNombre()); 
        } else {
            porNombre.put(obj.getNombre(), obj);
            setPesoActual(obj.getPeso() + getPesoActual());
        }
    }

    /**
     * Quita un objeto de la bolsa por su nombre y actualiza
     * el peso total.
     * 
     * @param nombre El nombre del elemento a quitar de la bolsa.
     * @return el elemento eliminado, o null si no existe ese elemento a remover
     */
    public Elemento delElemento (String nombre) {
        // TODO - Implementar metodo
        Elemento retornable= null;
        if(porNombre.containsKey(nombre)){
            setPesoActual(getPesoActual() - porNombre.get(nombre).getPeso());
            retornable= porNombre.get(nombre);
            porNombre.remove(nombre);
        } 
        return retornable;
    }

    /**
     * Devuelve una lista con los elementos almacenados en la bolsa.
     * 
     * @return ArrayList<Elemento> lista con los elementos de la bolsa.
     */
    public ArrayList<Elemento> getElementosEnLaBolsa() {
        // TODO - Implementar metodo
        ArrayList<Elemento> listaR= new ArrayList<Elemento>();
        for(Elemento elementos: porNombre.values()){
            listaR.add(elementos);
        }
        return listaR;
    }

    /**
     * Devuelve la lista de elementos almacenados en la bolsa
     * cuyo nombre comienza con el prefijo indicado.
     * 
     * @param pre El prefijo a buscar
     * @return ArrayList<Elemento> lista con los elementos de la bolsa que 
     * cumplen con el criterio.
     */
    public ArrayList<Elemento> getElementosConPrefijo(String pre) {
        // TODO - Implementar metodo
        ArrayList<Elemento> listaR= new ArrayList<Elemento>();
        for(String nombre: porNombre.keySet()){
            if(nombre.startsWith(pre)){ //caso toLowerCase
                listaR.add(porNombre.get(nombre));
            }
        }
        return listaR;
    }

    /**
     * Devuelve el peso disponible que aún puede almacenarse 
     * en la bolsa en un momento dado. 
     * Cambia según se agregan o quitan objetos.
     * 
     * @return El peso máximo a agregar.
     */
    public int getPesoLibre () {
        // TODO - Implementar metodo
        return (getPesoMaximo() - this.pesoActual);
    }

    /**
     * Incrementa el peso total almacenado en la bolsa.
     * Se utiliza para agregar como para quitar objetos.
     *
     *   @param peso El peso a quitar/agregar.
     */
    public void addPeso (int peso) {
        // TODO - Implementar metodo
        if(getPesoActual() + peso > PESO_MAXIMO || 0 > getPesoActual() + peso ){
        } else {
            setPesoActual(peso + getPesoActual());
        }
    }

    public int getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(int pesoActual) {
        this.pesoActual = pesoActual;
    }

    public String getKeySet () {
        return porNombre.keySet().toString();
    }

    public int getPesoMaximo () {
        return PESO_MAXIMO;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public Map<String,Elemento> getMapaDeElementos(){
        return porNombre;
    }
}