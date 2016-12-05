package modelos.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelos.Fecha;
import modelos.Paciente;
import modelos.Persona;
import modelos.Tratamiento;
import modelos.database.ConectorBD;
import modelos.enums.DatosPacienteDao;

public class PacienteDAO {

    private ConectorBD conectorBD;
    private TratamientoDAO tratamientoDAO;
    private final MedicamentosExternosDAO medicamentosExternosDAO;
    private final EnfermedadesPreviasDAO enfermedadesPreviasDAO;

    public PacienteDAO() {
        this.conectorBD = new ConectorBD();
        tratamientoDAO = new TratamientoDAO();
        medicamentosExternosDAO = new MedicamentosExternosDAO();
        enfermedadesPreviasDAO = new EnfermedadesPreviasDAO();
    }

    public void crearPaciente(Paciente paciente) throws SQLException {
        conectorBD.conectar();

        String campos = "Nombre, Apellido, Direccion, Localidad, Telefono, "
                + "Edad, ID_Paciente, EnfermedadesPrevias, MedicamentosExternos, "
                + "FechaInscripcion";

        String consulta = "INSERT INTO Paciente (" + campos + ")" + " VALUES (?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement declaracion = conectorBD.consulta(consulta);

        declaracion.setString(DatosPacienteDao.NOMBRE.getDato(), paciente.getNombres());
        declaracion.setString(DatosPacienteDao.APELLIDO.getDato(), paciente.getApellidos());
        declaracion.setString(DatosPacienteDao.DIRECCION.getDato(), paciente.getDireccion());
        declaracion.setString(DatosPacienteDao.LOCALIDAD.getDato(), paciente.getLocalidad());
        declaracion.setString(DatosPacienteDao.TELEFONO.getDato(), paciente.getTelefono());
        declaracion.setInt(DatosPacienteDao.EDAD.getDato(), paciente.getEdad());
        declaracion.setInt(DatosPacienteDao.ENFERMEDADES_PREVIAS.getDato(), 
                paciente.getEnfermedadesPrevias().size());
        declaracion.setInt(DatosPacienteDao.MEDICAMENTOS_EXTERNOS.getDato(), 
                paciente.getMedicamentosExternos().size());

        java.sql.Date fechaDeInscripcion = new java.sql.Date(paciente.getFechaDeInscripcion().getTime());
        declaracion.setDate(DatosPacienteDao.FECHA_INSCRIPCION.getDato(), fechaDeInscripcion);

        declaracion.execute();

        ResultSet generatedKeys = declaracion.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            paciente.setId(id);
            paciente.getTratamiento().setId(id);
        }

        conectorBD.desconectar();

        tratamientoDAO.crearTratamiento(paciente.getTratamiento());
        enfermedadesPreviasDAO.crearEnfermedadesPrevias(paciente);
        medicamentosExternosDAO.crearMedicamentosExternos(paciente);
    }

    public ArrayList<Paciente> recuperarTodos() throws SQLException {
        this.conectorBD.conectar();

        String consulta = "select * from Paciente";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();

        ArrayList<Paciente> pacientes = new ArrayList();

        while (resultado.next()) {

            Persona persona = new Persona(resultado.getString("Nombre"), 
                    resultado.getString("Apellido"), resultado.getString("Direccion"), 
                    resultado.getString("Localidad"), resultado.getString("Telefono"),
                    resultado.getInt("Edad"));
            int paciente_id = resultado.getInt("ID_Paciente");
            Date fechaInscripcion = resultado.getDate("FechaInscripcion");
            Paciente paciente = new Paciente(persona,
                    medicamentosExternosDAO.getMedicamentosExternos(paciente_id),
                    enfermedadesPreviasDAO.getEnfermedadesPrevias(paciente_id),
                    tratamientoDAO.getTratamiento(paciente_id),
                    new Fecha(fechaInscripcion), paciente_id);
            pacientes.add(paciente);
        }

        this.conectorBD.desconectar();

        return pacientes;
    }

    public Paciente obtenerPacientePorID(int id) throws SQLException {
        conectorBD.conectar();

        String consulta = "select * from Paciente where ID_Paciente = " + id;
        PreparedStatement declaracion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracion.executeQuery();

        ArrayList enfermedadesPrevias = enfermedadesPreviasDAO.getEnfermedadesPrevias(id);
        ArrayList medicamentosExternos = medicamentosExternosDAO.getMedicamentosExternos(id);
        Tratamiento tratamiento = tratamientoDAO.getTratamiento(id);
        Date fechaInscripcion = null;
        Persona persona = null;

        persona = new Persona(resultado.getString("Nombre"), resultado.getString("Apellido"),
                resultado.getString("Direccion"), resultado.getString("Localidad"),
                resultado.getString("Telefono"), resultado.getInt("Edad"));
        
        fechaInscripcion = resultado.getDate("FechaInscripcion");

        Paciente paciente = new Paciente(persona, medicamentosExternos,
                enfermedadesPrevias, tratamiento, new Fecha(fechaInscripcion), id);

        conectorBD.desconectar();

        return paciente;
    }

    public ArrayList<Paciente> obtenerPacientesPorNombre(String nombre) throws SQLException {
        this.conectorBD.conectar();

        ArrayList<Paciente> pacientes = new ArrayList();
        String consulta = "select * from paciente  where paciente.Nombre||\" \"||"
                + "paciente.Apellido like \"%" + nombre + "%\"";
        PreparedStatement declaracionDeRecuperacion = conectorBD.consulta(consulta);

        ResultSet resultado = declaracionDeRecuperacion.executeQuery();

        while (resultado.next()) {
            Persona persona = new Persona(resultado.getString("Nombre"), 
                resultado.getString("Apellido"),resultado.getString("Direccion"), 
                resultado.getString("Localidad"), resultado.getString("Telefono"),
                resultado.getInt("Edad"));

            int paciente_id = resultado.getInt("ID_Paciente");
            Date fechaInscripcion = resultado.getDate("FechaInscripcion");

            Paciente paciente = new Paciente(persona,
                    medicamentosExternosDAO.getMedicamentosExternos(paciente_id),
                    enfermedadesPreviasDAO.getEnfermedadesPrevias(paciente_id),
                    tratamientoDAO.getTratamiento(paciente_id),
                    new Fecha(fechaInscripcion), paciente_id);

            pacientes.add(paciente);
        }

        this.conectorBD.desconectar();
        return pacientes;
    }

    public void actualizar(Paciente paciente) throws SQLException {
        conectorBD.conectar();
        int campoNombres = 1;
        int campoApellidos = 2;
        int campoDireccion = 3;
        int campoLocalidad = 4;
        int campoTelefono = 5;
        int campoEdad = 6;
        int campoEnfermedadesPrevias = 7;
        int campoMedicamentosExternos = 8;
        int campoClausula = 9;
        
        String consulta = "UPDATE Paciente SET Nombre = ?, Apellido = ?, Direccion = ?, "
                + "Localidad = ?, Telefono = ?, Edad = ?, EnfermedadesPrevias = ?, "
                + "MedicamentosExternos = ? where ID_Paciente = ?";

        PreparedStatement declaracion = conectorBD.consulta(consulta);
        declaracion.setString(campoNombres, paciente.getNombres());
        declaracion.setString(campoApellidos, paciente.getApellidos());
        declaracion.setString(campoDireccion, paciente.getDireccion());
        declaracion.setString(campoLocalidad, paciente.getLocalidad());
        declaracion.setString(campoTelefono, paciente.getTelefono());
        declaracion.setInt(campoEdad, paciente.getEdad());
        declaracion.setInt(campoEnfermedadesPrevias, paciente.getEnfermedadesPrevias().size());
        declaracion.setInt(campoMedicamentosExternos, paciente.getMedicamentosExternos().size());
        declaracion.setInt(campoClausula, paciente.getId());

        enfermedadesPreviasDAO.actualizar(paciente);
        medicamentosExternosDAO.actualizar(paciente);
        tratamientoDAO.actualizar(paciente.getTratamiento());

        conectorBD.desconectar();
    }

    public void actualizarAplicaciones(Paciente paciente) throws SQLException {
        tratamientoDAO.getAplicacionDAO().actualizar(paciente.getTratamiento().getUltimaAplicacion());
        tratamientoDAO.getAplicacionDAO().crearAplicacion(paciente.getTratamiento().getSiguienteAplicacion());
    }
}
