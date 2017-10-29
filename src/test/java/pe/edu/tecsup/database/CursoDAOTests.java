package pe.edu.tecsup.database;

import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.database.dao.CursoDAO;
import pe.edu.tecsup.database.model.Curso;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;

    @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        for (Curso curso : cursos) {
            System.out.println(curso.getId() + "-" + curso.getNombre() + "-" + curso.getCodigo());
        }
        Assert.assertTrue(cursos.size() > 0);
    }

    @Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(2l);
        System.out.println(curso.getId() + "-" + curso.getNombre() + "-" + curso.getCodigo());
        Assert.assertTrue(curso.getId() == 2l);
    }

    @Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setCodigo("1081");
        curso.setNombre("Nuevo Curso Manuel");
  

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }

    @Test
    public void verifyUpdate() {

        //cambiar el código para validar 
        Curso curso = new Curso();
        curso.setId(35l);
        curso.setCodigo("888");
        curso.setNombre("Curso Modificado Manuel888");
        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(35l).getCodigo().equals("888"));
    }

    @Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(35l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(35l) == null);
    }

}
