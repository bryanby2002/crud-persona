package capa_logica;

/**
 * Importación de paquetes y clases necesarias.
 */
import capa_datos.Persona;
import capa_presentacion.PPersona;
import javax.swing.JOptionPane;

/**
 * Clase que implementa la lógica de manejo de personas. Contiene métodos para
 * agregar, modificar y eliminar personas en el sistema.
 */
public class LPersonaImp {

    Persona persona;
    LPersona logPersona = new LPersona();

    /**
     * Agrega una nueva persona al sistema. Muestra un cuadro de diálogo para
     * confirmar la acción. Si el usuario confirma, se crea un objeto Persona
     * con los datos ingresados en la interfaz gráfica y se invoca el método
     * Insert de la instancia logPersona para agregar la persona en la base de
     * datos. Si la inserción es exitosa, se limpian los campos de la interfaz y
     * se muestra un mensaje de éxito. En caso de error, se muestra un mensaje
     * de error.
     *
     * @throws Exception si ocurre un error durante la inserción.
     */
    public void agregarPersona() throws Exception {
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Desea agregar nueva persona?", "Crud", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
            persona = new Persona(PPersona.dni(), PPersona.nombre(), PPersona.edad(), PPersona.genero());
            int salida = logPersona.Insert(persona);
            if (salida > 0) {
                logPersona.LimpiarCajas();
                JOptionPane.showMessageDialog(null, "Agregado");
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    /**
     * Modifica los datos de una persona existente en el sistema. Muestra un
     * cuadro de diálogo para confirmar la acción. Si el usuario confirma, se
     * crea un objeto Persona con los datos ingresados en la interfaz gráfica y
     * se invoca el método Update de la instancia logPersona para actualizar los
     * datos de la persona en la base de datos. Si la modificación es exitosa,
     * se limpian los campos de la interfaz y se muestra un mensaje de éxito. En
     * caso de error, se muestra un mensaje de error.
     *
     * @throws Exception si ocurre un error durante la modificación.
     */
    public void modificarPersona() throws Exception {
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Desea modificar esta persona?", "Crud", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
            persona = new Persona(PPersona.dni(), PPersona.nombre(), PPersona.edad(), PPersona.genero());
            int salida = logPersona.Update(persona);
            if (salida > 0) {
                logPersona.LimpiarCajas();
                JOptionPane.showMessageDialog(null, "Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }

    /**
     * Elimina una persona existente en el sistema. Muestra un cuadro de diálogo
     * para confirmar la acción. Si el usuario confirma, se crea un objeto
     * Persona con el DNI ingresado en la interfaz gráfica y se invoca el método
     * Delete de la instancia logPersona para eliminar la persona de la base de
     * datos. Si la eliminación es exitosa, se limpian los campos de la interfaz
     * y se muestra un mensaje de éxito. En caso de error, se muestra un mensaje
     * de error.
     *
     * @throws Exception si ocurre un error durante la eliminación
     */
    public void eliminarPersona() throws Exception {
        int mensaje = JOptionPane.showConfirmDialog(null, "¿Desea eliminar esta persona?", "Crud", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (mensaje == JOptionPane.YES_OPTION) {
            persona = new Persona(PPersona.dni());
            int salida = logPersona.Delete(persona);
            if (salida > 0) {
                logPersona.LimpiarCajas();
                JOptionPane.showMessageDialog(null, "Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
}
