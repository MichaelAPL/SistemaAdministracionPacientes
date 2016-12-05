/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelos.Tratamiento;
import modelos.database.ConectorBD;

/**
 *
 * @author miguelangel
 */
public class TratamientoDAO {

    private ConectorBD conectorBD;
    private AplicacionDAO aplicacionDAO;

    public TratamientoDAO() {
        this.conectorBD = new ConectorBD();
        this.aplicacionDAO = new AplicacionDAO();
    }

     public void actualizar(Tratamiento tratamiento) throws SQLException {
        //indices campos
        int INDICE_DOSIS_EDTA = 1;
        int INDICE_ACTIVO = 2;
        int INDICE_CLAUSULA = 3;

        conectorBD.conectar();
        String consulta = "UPDATE Tratamiento SET DosisEDTA = ?, Activo = ? "
                + "where ID_Tratamiento = ?";

        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setInt(INDICE_DOSIS_EDTA, tratamiento.getDosisEDTA_ml());
        declaracion.setBoolean(INDICE_ACTIVO, tratamiento.isActivo());
        declaracion.setInt(INDICE_CLAUSULA, tratamiento.getId());

        declaracion.execute();

        conectorBD.desconectar();

        if (tratamiento.getUltimaAplicacion() != null) {
            aplicacionDAO.actualizar(tratamiento.getUltimaAplicacion());
        }
        aplicacionDAO.crearAplicacion(tratamiento.getSiguienteAplicacion());
    }
    
    public void crearTratamiento(Tratamiento tratamiento) throws SQLException {
        //indices campos
        int INDICE_ID_TRATAMIENTO = 1;
        int INDICE_DOSIS_EDTA = 2;
        int INDICE_ACTIVO = 3;
        int INDICE_PACIENTE_ID = 4;

        conectorBD.conectar();

        String campos = "ID_Tratamiento, DosisEDTA, Activo, Paciente_ID";
        String consulta = "INSERT INTO Tratamiento (" + campos + ")" + " VALUES (?,?,?,?)";

        PreparedStatement declaracionTratamiento = conectorBD.consulta(consulta);

        declaracionTratamiento.setInt(INDICE_DOSIS_EDTA, tratamiento.getDosisEDTA_ml());
        declaracionTratamiento.setBoolean(INDICE_ACTIVO, tratamiento.isActivo());
        declaracionTratamiento.setInt(INDICE_PACIENTE_ID, tratamiento.getIdPaciente());

        declaracionTratamiento.execute();

        ResultSet generatedKeys = declaracionTratamiento.getGeneratedKeys();
        if (generatedKeys.next()) {
            int tratamientoID = generatedKeys.getInt(INDICE_ID_TRATAMIENTO);
            tratamiento.getSiguienteAplicacion().setTratamientoID(tratamientoID);
        }

        conectorBD.desconectar();

        aplicacionDAO.crearAplicacion(tratamiento.getSiguienteAplicacion());
    }
    
    public AplicacionDAO getAplicacionDAO() {
        return this.aplicacionDAO;
    }

    public Tratamiento obtenerTratamiento(int pacienteID) throws SQLException {
        conectorBD.conectar();
        String consulta = "select * from Tratamiento where Paciente_ID = " + pacienteID + " and "
                + "Activo = 1";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracion.executeQuery();

        Tratamiento tratamiento = null;

        tratamiento = new Tratamiento(resultado.getInt("DosisEDTA"));
        tratamiento.setId(resultado.getInt("ID_Tratamiento"));
        tratamiento.setActivo(resultado.getBoolean("Activo"));
        tratamiento.setIdPaciente(resultado.getInt("Paciente_ID"));
        tratamiento.setSiguienteAplicacion(aplicacionDAO.obtenerSiguienteAplicacion(tratamiento.getId()));

        int primeraAplicacion = 1;

        if (tratamiento.getSiguienteAplicacion().getNumAplicacion() != primeraAplicacion) {
            tratamiento.setUltimaAplicacion(aplicacionDAO.obtenerUltimaAplicacion(tratamiento.getId(),
                    tratamiento.getSiguienteAplicacion().getNumAplicacion() - 1));
        }

        conectorBD.desconectar();

        return tratamiento;
    }
}
