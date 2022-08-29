package br.com.inatel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TesteControllerProfessor {

    ProfessorService service;
    ProfessorController professorController;

    @Before
    public void setup(){
        service = new MockProfessorService();
        professorController = new ProfessorController(service);
    }



    //Sucesso integral
    @Test
    public void testeInsereNovoProfessorValidoIntegral(){
        Professor p = new Professor("Chris", "15:30", "integral");

        String s = professorController.insereNovoHorario(p);

        assertEquals("Novo horario salvo!", s);
    }

    //Sucesso noturno
    @Test
    public void testeInsereNovoProfessorValidoNoturno(){
        Professor p = new Professor("Chris", "17:30", "noturno");

        String s = professorController.insereNovoHorario(p);

        assertEquals("Novo horario salvo!", s);
    }

    //Falha
    @Test
    public void testeInsereNovoProfessorComPeriodoInvalido(){
        Professor p = new Professor("Chris", "15:30", "diurno");

        String s = professorController.insereNovoHorario(p);

        assertEquals("Impossivel cadastrar com esses dados", s);
    }

    //Falha
    @Test
    public void testeInsereNovoProfessorComHorarioInvalido(){
        Professor p = new Professor("Chris", "3:30", "integral");

        String s = professorController.insereNovoHorario(p);

        assertEquals("Impossivel cadastrar com esses dados", s);
    }

    //Sucesso
    @Test
    public void buscaProfessorValido(){
        Professor professor = professorController.buscaProfessor("Chris");

        assertEquals("Chris", professor.getNome());
        assertEquals("17:30", professor.getHorario());
        assertEquals("noturno", professor.getPeriodo());
    }

    //Falha
    @Test
    public void testeBuscaProfessorInvalido(){
        Professor professor = professorController.buscaProfessor("Francisco");

        assertEquals("Nao Cadastrado", professor.getNome());
        assertEquals("--:--", professor.getHorario());
        assertEquals("----", professor.getPeriodo());
    }


}
