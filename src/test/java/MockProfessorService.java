import br.com.inatel.Professor;
import br.com.inatel.ProfessorService;

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
        else if(nome.equals("Fulano")){
            return ProfessorConst.FULANO;
        }
        else
            return ProfessorConst.INVALIDO;
    }
}
