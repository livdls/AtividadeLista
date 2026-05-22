package main;

import java.util.Date;
import java.text.SimpleDateFormat;

// Classe Professor também herda de Usuario
public class Professor extends Usuario {

    // Atributo específico do professor
    private String siape;

    // Outro atributo específico
    private int cargaHoraria;

    public Professor(String nome, String siape,
                     Date dataNascimento, int cargaHoraria) {

        // Como SIAPE substitui a matrícula, pode usar 0 no super
        super(nome, 0, dataNascimento);

        // Guarda o SIAPE
        this.siape = siape;

        // Guarda a carga horária
        this.cargaHoraria = cargaHoraria;
    }

    // Método para pegar o SIAPE
    public String getSiape() {
        return siape;
    }

    // Método para alterar a carga horária
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    // Método para mostrar os dados do professor
    public void exibir() {

        // Cria o formato da data: dia/mês/ano
        SimpleDateFormat formatoData =
                new SimpleDateFormat("dd/MM/yyyy");

        // Mostra os dados básicos
        System.out.println("Nome: " + getNome());
        System.out.println("SIAPE: " + siape);

        // Mostra a data formatada
        System.out.println("Data de Nascimento: " +
                formatoData.format(getDataNascimento()));

        // Mostra o dado específico do professor
        System.out.println("Carga Horaria: " + cargaHoraria);
    }
}