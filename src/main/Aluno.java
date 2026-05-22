package main;

import java.util.Date;

// Classe Aluno herda tudo de Usuario
public class Aluno extends Usuario {

    // Atributo específico do aluno
    private double cre;

    // Construtor
    public Aluno(String nome, long matricula, Date dataNascimento, double cre) {

        // super chama o construtor da classe Usuario
        // ou seja, ele preenche nome, matrícula e data
        super(nome, matricula, dataNascimento);

        // Aqui guarda o CRE do aluno
        this.cre = cre;
    }

    // Método para mostrar os dados do aluno
    public void exibir() {

        // Primeiro mostra os dados comuns (nome, matrícula, data)
        super.exibir();

        // Depois mostra o que é só do aluno
        System.out.println("CRE: " + cre);
    }
}