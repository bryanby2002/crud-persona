package capa_datos;

/**
 * La clase Persona representa a una persona con atributos como ID, DNI, nombre,
 * edad y género.
 */
public class Persona {

    private int id;
    private String dni;
    private String nombre;
    private String edad;
    private String genero;

    /**
     * Crea un objeto Persona con el DNI especificado.
     *
     * @param dni El DNI de la persona.
     */
    public Persona(String dni) {
        this.dni = dni;
    }

    /**
     * Crea un objeto Persona con el DNI, nombre, edad y género especificados.
     *
     * @param dni El DNI de la persona.
     * @param nombre El nombre de la persona.
     * @param edad La edad de la persona.
     * @param genero El género de la persona.
     */
    public Persona(String dni, String nombre, String edad, String genero) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Crea un objeto Persona con el ID, DNI, nombre, edad y género
     * especificados.
     *
     * @param id El ID de la persona.
     * @param dni El DNI de la persona.
     * @param nombre El nombre de la persona.
     * @param edad La edad de la persona.
     * @param genero El género de la persona.
     */
    public Persona(int id, String dni, String nombre, String edad, String genero) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    /**
     * Obtiene el ID de la persona.
     *
     * @return El ID de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     *
     * @param id El ID de la persona.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el DNI de la persona.
     *
     * @return El DNI de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI de la persona.
     *
     * @param dni El DNI de la persona.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return La edad de la persona.
     */
    public String getEdad() {
        return edad;
    }

    /**
     * Establece la edad de la persona.
     *
     * @param edad La edad de la persona.
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el género de la persona.
     *
     * @return El género de la persona.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la persona.
     *
     * @param genero El género de la persona.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
}
