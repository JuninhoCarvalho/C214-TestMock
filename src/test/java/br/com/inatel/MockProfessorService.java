package br.com.inatel;

public class MockProfessorService implements ProfessorService {
    @Override
    public boolean periodoValido(String periodo) {
        if(periodo.equals("integral") || periodo.equals("noturno")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void save(Professor p) {

    }

    @Override
    public String buscaProfessor(String nome) {
        if(nome.equals("Chris")) {
            return ProfessorConst.CHRIS;
        }

        return ProfessorConst.INVALIDO;
    }

    @Override
    public boolean horarioValido(String horario) {
        if (horario.length()!=5){
            return false;
        }

        return true;
    }
}
