package capa_logica;

/**
 * Importación de paquetes y clases necesarias.
 */
import capa_datos.*;
import capa_presentacion.PPersona;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * La clase LPersona implementa la interfaz IPersona y proporciona
 * implementaciones para las operaciones relacionadas con la manipulación de
 * objetos Persona.
 */
public class LPersona implements IPersona {

    /**
     * Inserta un objeto Persona en alguna fuente de datos.
     *
     * @param p El objeto Persona a insertar.
     * @return El resultado de la operación de inserción. Retorna el número de
     * filas afectadas.
     */
    @Override
    public int Insert(Persona p) {

        int salida = 0;
        Connection conex = null;
        CallableStatement cstm = null;

        try {

            conex = Conexion.getConnection();
            String sql = "{CALL InsertarPersona(?, ?, ?, ?)}";
            cstm = conex.prepareCall(sql);

            cstm.setString(1, p.getDni());
            cstm.setString(2, p.getNombre());
            cstm.setString(3, p.getEdad());
            cstm.setString(4, p.getGenero());

            salida = cstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        } finally {

            try {

                if (conex != null) {
                    conex.close();
                }
                if (cstm != null) {
                    cstm.close();
                }

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }
        }

        return salida;
    }

    /**
     * Actualiza un objeto Persona existente en alguna fuente de datos.
     *
     * @param p El objeto Persona con los nuevos valores a actualizar.
     * @return El resultado de la operación de actualización. Retorna el número
     * de filas afectadas.
     */
    @Override
    public int Update(Persona p) {

        int salida = 0;
        Connection conex = null;
        CallableStatement cstm = null;

        try {

            conex = Conexion.getConnection();
            String sql = "{CALL ActualizarPersona(?, ?, ?, ?)}";
            cstm = conex.prepareCall(sql);

            cstm.setString(1, p.getDni());
            cstm.setString(2, p.getNombre());
            cstm.setString(3, p.getEdad());
            cstm.setString(4, p.getGenero());

            salida = cstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        } finally {

            try {

                if (conex != null) {
                    conex.close();
                }
                if (cstm != null) {
                    cstm.close();
                }

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }
        }

        return salida;

    }

    /**
     * Elimina un objeto Persona de alguna fuente de datos.
     *
     * @param p El objeto Persona a eliminar.
     * @return El resultado de la operación de eliminación. Retorna el número de
     * filas afectadas.
     */
    @Override
    public int Delete(Persona p) {

        int salida = 0;
        Connection conex = null;
        CallableStatement cstm = null;

        try {

            conex = Conexion.getConnection();
            String sql = "{CALL EliminarPersona(?)}";
            cstm = conex.prepareCall(sql);

            cstm.setString(1, p.getDni());

            salida = cstm.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace(System.out);

        } finally {

            try {

                if (conex != null) {
                    conex.close();
                }
                if (cstm != null) {
                    cstm.close();
                }

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }
        }

        return salida;

    }

    /**
     * Lista los detalles de una Persona según el número de DNI.
     *
     * El número de DNI utilizado como criterio de búsqueda.
     */
    @Override
    public void Listar() {

        Connection conex = null;
        CallableStatement cstm = null;
        ResultSet rs = null;
        String dni = PPersona.dni();

        try {

            conex = Conexion.getConnection();
            cstm = conex.prepareCall("{call ListarPersona(?)}");

            cstm.setString(1, dni);

            rs = cstm.executeQuery();

            if (rs.next()) {

                String dnii = rs.getString(1);
                String nombre = rs.getString(2);
                String edad = rs.getString(3);
                String genero = rs.getString(4);

                PPersona.txtDni.setText(dnii);
                PPersona.txtNombre.setText(nombre);
                PPersona.txtEdad.setText(edad);
                if (genero.equals("Femenino")) {
                    PPersona.rbF.setSelected(true);
                    PPersona.rbM.setSelected(false);
                } else if (genero.equals("Masculino")) {
                    PPersona.rbM.setSelected(true);
                    PPersona.rbF.setSelected(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados");
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
                if (cstm != null) {
                    cstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    /**
     * Limpia los campos de texto y deselecciona los botones de género en la
     * interfaz gráfica.
     */
    @Override
    public void LimpiarCajas() {

        PPersona.txtDni.setText("");
        PPersona.txtNombre.setText("");
        PPersona.txtEdad.setText("");
        PPersona.botonesGenero.clearSelection();
    }

    /**
     * Valida los campos de entrada en la interfaz gráfica. Realiza la
     * validación del campo DNI, Nombre, Edad y Género.
     *
     * @return true si todos los campos son válidos, false de lo contrario.
     */
    @Override
    public boolean ValidarCajas() {

        // Validar DNI
        String dni = PPersona.dni();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Debe ingresar su DNI!");
            return false;
        } else if (dni.length() != 8 || !dni.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "¡DNI no válido!");
            return false;
        }

        // Validar Nombre
        String nombre = PPersona.nombre();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Debe ingresar su nombre!");
            return false;
        }

        // Validar Edad
        String edad = PPersona.edad();
        if (edad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "¡Debe ingresar su edad!");
            return false;
        } else if (edad.length() > 3 || !edad.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "¡La edad no es válida!");
            return false;
        }

        // Validar Género
        if (!PPersona.rbF.isSelected() && !PPersona.rbM.isSelected()) {
            JOptionPane.showMessageDialog(null, "¡Seleccione su género!");
            return false;
        }

        return true;
    }

}
