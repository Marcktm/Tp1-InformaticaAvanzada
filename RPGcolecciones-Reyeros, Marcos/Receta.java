import java.util.Set;
import java.util.TreeSet;

/**
 * La clase Receta modela una receta para preparar pociones
 * magicas.
 * 
 * Se la inicializa con un nombre a eleccion y en estado "ok"
 * en falso.
 *  
 * Se deben agregar uno a uno los ingredientes que la conforman.
 * Al terminar la carga, se la establece con "ok" en verdadero.
 * 
 * No se puede usar una receta sin terminar.
 * 
 * No se pueden agregar ingredientes a una receta terminada.
 */
public class Receta {
    private Boolean cerrada;
    private Set<String> ingredientes;
    private String nombre;
    private String Text="";

    /**
     * El constructor debe inicializar el objeto con un nombre
     * a eleccion y estado "ok" en falso.
     * 
     * No olvidar construir el conjunto (TreeSet) de ingredientes 
     * 
     * @param nombre El nombre de la receta.
     */
    public Receta (String nombre) {
        this.nombre = nombre;
        cerrada = false;
        ingredientes = new TreeSet<String>(); 
        // TODO - Implementar metodo

    }

    /**
     * Agrega un nuevo ingrediente a la receta.
     * 
     * Solo se aceptaran nuevos ingredientes cuando la
     * receta se encuentre sin terminar ("cerrada" en falso).
     * 
     * @param ingrediente El ingrediente a agregar.
     */
    public void addIngrediente(String ingrediente) {
        if(cerrada == false){
            ingredientes.add(ingrediente);
        }
    }

    /**
     * Devuelve la cantidad de ingredientes de la receta.
     * 
     * @return La cantidad de ingredientes de la receta.
     */
    public int getCantidadIngredientes () {
        // TODO - Implementar metodo
        return ingredientes.size();
    }

    /**
     * Devuelve los ingredientes de la receta.
     * 
     * @return Los ingredientes de la receta como conjunto.
     */
    public Set<String> getIngredientes () {
        return ingredientes;
    }
    
    /**
     * Cambia el estado de la receta cuando tenga al menos dos (2) ingredientes.
     * En caso contrario, no hace nada.
     * 
     * No puede revertirse.
     * 
     * @return true si se pudo cerrar la receta, false en caso contrario
     */
    public Boolean cerrarReceta () {
        // TODO - Implementar metodo
        if(ingredientes.size()>=2){
            cerrada = true;
        }
        return cerrada;
    }


    /**
     * Genera una cadena con la informacion sobre la receta.
     * 
     * Debe generarse usando el nombre, "incompleta" o "completa" segun
     * el estado ("ok") y listar los ingredientes que la conforman con el
     * formato
     *     "Receta <nombre> (<estado>)\nIngredientes:\n<ingr1>\n<ingr2>\n..."
     * 
     * Ejemplo receta incompleta:
     *    "Receta voladora (incompleta)
     *     Ingredientes:
     *     Pluma"
     * 
     * Ejemplo receta completa:
     *    "Receta voladora (completa)
     *     Ingredientes:
     *     Hueso
     *     Pluma
     *     Sangre"
     * 
     * @return El texto indicado en el ejemplo.
     */
    @Override
    public String toString() {
      // TODO - Implementar metodo
      String cond;
      if(cerrada == false){
          cond = "(incompleta)";
      }
      else{
          cond = "(completa)";
      }
      return getTexto();
    }
    
    public String getTexto(){
      String cond;
        if(cerrada == false){
          cond = "(incompleta)";
      }
      else{
          cond = "(completa)";
      }
      System.out.println("Receta " + nombre + " " + cond + "\nIngredientes:" );
      for(String s : ingredientes){
            System.out.println(s);
        }
      return Text;
    }

    /**
     * Verifica si la receta se puede usar.
     * 
     * @return true si puede usarse y false si no esta cargada completamente.
     */
    public Boolean isCerrada () {
        return cerrada;
    }

    public String getNombre () {
        return nombre;
    }

}