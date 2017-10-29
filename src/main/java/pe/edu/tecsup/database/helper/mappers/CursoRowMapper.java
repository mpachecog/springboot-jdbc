package pe.edu.tecsup.database.helper.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;
import pe.edu.tecsup.database.model.Curso;

public class CursoRowMapper implements RowMapper<Curso>
{

    @Override
    public Curso mapRow(ResultSet rs, int i) throws SQLException
    {
//        private Long id;
//    private String nombre;
//    private String codigo;
//    private Date fechaInicio;
//    private Programa programa;

        Curso curso = new Curso();
        curso.setId(rs.getLong(1));
        curso.setNombre(rs.getString(2));
        curso.setCodigo(rs.getString(3));

        return curso;

    }

}
