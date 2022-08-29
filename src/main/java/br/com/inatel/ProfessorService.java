package br.com.inatel;

public interface ProfessorService {

    boolean periodoValido(String periodo);
    void save(Professor p);

    String buscaProfessor(String nome);

    boolean horarioValido(String horario);
}
