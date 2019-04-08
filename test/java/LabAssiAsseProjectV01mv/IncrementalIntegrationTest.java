package LabAssiAsseProjectV01mv;

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

import static org.junit.Assert.*;

public class IncrementalIntegrationTest {
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
        int successStudent = service.saveStudent("1", "b",123);

        int successTema = service.saveTema("1", "Tema",8,6);


        assertArrayEquals(new int[]{ 0,0},new int[]{successStudent, successTema});
    }
    

    @Test
    public void addGradeSuccess()
    {
        int successStudent = service.saveStudent("1", "b",123);

        int successTema = service.saveTema("1", "Tema",8,6);

        int successGrade = service.saveNota("1", "1",4,7, "haha");

        assertArrayEquals(new int[]{ 0,0,0},new int[]{ successStudent,successTema,successGrade});
    }


    @Test
    public void addStudentSuccess()
    {
        int successEC = service.saveStudent("1", "b",123);


        assertEquals(0, successEC);
    }


}
