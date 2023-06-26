package capa_logica;

import capa_datos.Persona;

/**
 * La interfaz IPersona define las operaciones relacionadas con la manipulación de objetos Persona.
 * Proporciona métodos para insertar, actualizar, eliminar, listar, limpiar cajas y validar cajas de datos de Persona.
 */
public interface IPersona {
    
    public int Insert(Persona p);   
    public int Update(Persona p);   
    public int Delete(Persona p);
    public void Listar();
    public void LimpiarCajas();
    public boolean ValidarCajas();
    
}

