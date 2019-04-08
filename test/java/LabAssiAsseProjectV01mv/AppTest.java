package LabAssiAsseProjectV01mv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import java.security.Provider;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);


    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void addTemaSuccess()
    {
        int success = service.saveTema("1", "Tema",8,6);

        assertEquals(1, success);
    }

    @Test
    public void addTemaFailure()
    {
        int fail = service.saveTema("", "",0,0);

        assertEquals(0, fail);
    }

    @Test
    public void addStudentSuccess()
    {
        int success1 = service.saveStudent("1", "b",110);
        int success2 = service.saveStudent("1", "b",938);
        int success3 = service.saveStudent("1", "b",111);
        int success4 = service.saveStudent("1", "b",937);


        assertEquals(0, success1);
        assertEquals(0, success2);
        assertEquals(0, success3);
        assertEquals(0, success4);
    }

    @Test
    public void addStudentFailure()
    {
        int fail1 = service.saveStudent("", "b",110);
        int fail2 = service.saveStudent(null, "b",110);
        int fail3 = service.saveStudent("1", "",110);
        int fail4 = service.saveStudent("1", null,110);
        int fail5 = service.saveStudent("1", "b",109);
        int fail6 = service.saveStudent("1", "b",939);


        assertEquals(1, fail1);
        assertEquals(1, fail2);
        assertEquals(1, fail3);
        assertEquals(1, fail4);
        assertEquals(1, fail5);
        assertEquals(1, fail6);
    }
}

