package br.com.inatel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ProfessorController {

    ProfessorService professorService;

    public ProfessorController(ProfessorService service){
        this.professorService = service;
    }

    public String insereNovoHorario(Professor p){
        if(professorService.periodoValido(p.getPeriodo()) && professorService.horarioValido(p.getHorario())){
            professorService.save(p);
            return "Novo horario salvo!";
        }
        else{
            return "Impossivel cadastrar com esses dados";
        }
    }

    public Professor buscaProfessor(String nome){
        String profJson = professorService.buscaProfessor(nome);

        JsonObject jsonObject = JsonParser.parseString(profJson).getAsJsonObject();

        return new Professor(jsonObject.get("nome").getAsString(),
                jsonObject.get("horario").getAsString(),
                jsonObject.get("periodo").getAsString());
    }

}
