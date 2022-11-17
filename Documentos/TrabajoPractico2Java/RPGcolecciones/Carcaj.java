

/**
 * Modela el Carcaj que lleva el personaje para
 * tranportar sus flechas.
 */
public class Carcaj extends Elemento {
    private final Integer PESO_PROPIO = 10;
    private Integer capacidad;
    private List<Flecha> flechas;

    /**
     * Constructor para un Carcaj generico chico. Su capacidad
     * es de 5 flechas pero se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     */
    public Carcaj() {
        flechas = new ArrayList<Flecha>();
        capacidad = 5;

        // modificadores
        setNombre("Carcaj chico");
        setPeso(PESO_PROPIO);
        setTipo(TipoElemento.RECIPIENTE);
    }

    /**
     * Constructor para un Carcaj de nombre y capacidad indicados
     * por parametro.  Se inicializa vacio.
     * Recordar que es de tipo recipiente y tiene un peso inicial.
     * 
     * @param nombre El nombre del carcaj.
     * @param capacidad Cantidad maxima de flechas.
     */
    public Carcaj(String nombre, Integer capacidad) {
        setNombre(nombre);
        this.capacidad = capacidad;
        setPeso(PESO_PROPIO);
        setTipo(TipoElemento.RECIPIENTE);
        flechas = new ArrayList<Flecha>();
    }

    /**
     * Agrega una flecha al carcaj.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no tiene capacidad disponible, debe imprimir
     *     "<nombre>: Capacidad completa"
     * donde <nombre> es el nombre del carcaj.
     * 
     * Si el elemento a agregar no es una flecha, debe imprimir:
     *     "<nombre>: No es una flecha"
     * donde <nombre> es el nombre del elemento entregado.
     * 
     * @param flecha La flecha a agregar.
     */
    public void addFlecha (Elemento flecha) {
        // -- 1 - preguntar si es tipo
        // -- 2 - preguntar por capacidad de carcaj
        // -- 3 - agregar flecha al carcaj
        if ( flecha.getTipo() != TipoElemento.MUNICION){
            System.out.println(flecha.getNombre() + ": No es una flecha");
        }
        else{
            if ( flechas.size() >= capacidad ){
                System.out.println(getNombre() + ": Capacidad completa");
            }
            else{
                flechas.add(new Flecha());
                // actualizar el peso
                addPeso(flecha.getPeso());
            }
        }
    }

    /**
     * Quita del carcaj una flecha.
     * 
     * Debe actualizarse el peso total.
     * 
     * Si no hay mas flechas, devuelve null y debe imprimir:
     *      "<nombre>: No quedan flechas"
     * donde <nombre> es el nombre del carcaj.
     * 
     * @return Una flecha.
     */
    public Flecha getFlecha() {
        if ( flechas.isEmpty() == true ){
            System.out.println(getNombre() + ": No quedan flechas");
            return null;
        }
        else{
            addPeso(-flechas.get(0).getPeso());
            // flechas.remove(Flecha.TipoElemento.MUNICION);
            return flechas.remove(0);
        }
    }

    /**
     * Modifica el peso del carcaj.
     * Puede sumar o restar peso.
     * 
     * @param peso El peso a modificar.
     */
    public void addPeso (Integer peso) {
        setPeso(getPeso() + peso);
    }

    /**
     * Devuelve informacion sobre el carcaj de la forma:
     *     "<nombre>: Flechas <cant>/<max>"
     * donde <nombre> es el nombre del carcaj,
     * <cant> es la cantidad de flechas que contiene y
     * <max> la capacidad maxima.
     */
    @Override        
    public String toString() {
        return getNombre() + ": Flechas " + getCantidadFlechas() + "/" + getCapacidad();
    }

    public Integer getCantidadFlechas () {
        return flechas.size();
    }

    public Integer getCapacidad () {
        return capacidad;
    }
    
}
