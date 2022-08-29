import br.com.inatel.ControllerProfessor;
import br.com.inatel.ProfessorService;
import org.junit.Before;

public class TesteControllerProfessor {

    ProfessorService service;
    ControllerProfessor controllerProfessor;

    @Before
    public void setup(){
        //Criando o contexo do meu teste com o Mock (serviço mock)
        service = new MockProfessorService();
        controllerProfessor = new ControllerProfessor(service);
    }


}
