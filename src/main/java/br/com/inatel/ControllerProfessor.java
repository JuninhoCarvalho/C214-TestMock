package br.com.inatel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ControllerProfessor {

    ProfessorService professorService;

    public ControllerProfessor(ProfessorService service){
        this.professorService = service;
    }

    public String insereNovoHorario(String nome, String horario, String periodo){
        if(professorService.periodoValido(periodo)){
            Professor p = new Professor(nome, horario, periodo);
            professorService.save(p);
            return "Novo horario salvo para o professor " + nome;
        }
        else{
            return "Periodo inválido para cadastro";
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
