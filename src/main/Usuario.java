package main;

import java.util.Date;
import java.text.SimpleDateFormat;

// Essa é a classe base (ou seja, é a classe "pai")
// Aluno e Professor vão usar ela como base
public class Usuario {

    // Atributos privados (só podem ser acessados pelos métodos)
    private String nome;          // guarda o nome da pessoa
    private long matricula;       // guarda a matrícula
    private Date dataNascimento;  // guarda a data de nascimento

    // Construtor → usado quando criamos um usuário novo
    public Usuario(String nome, long matricula, Date dataNascimento) {

        // Guarda os dados dentro do objeto
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
    }

    // Método para pegar o nome
    public String getNome() {
        return nome;
    }

    // Método para alterar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para pegar a matrícula
    public long getMatricula() {
        return matricula;
    }

    // Método para alterar a matrícula
    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    // Método para pegar a data de nascimento
    public Date getDataNascimento() {
        return dataNascimento;
    }

    // Método para alterar a data de nascimento
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    // Método para mostrar os dados do usuário
    public void exibir() {

        // Cria o formato da data: dia/mês/ano
        SimpleDateFormat formatoData =
                new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);

        // Mostra a data formatada
        System.out.println("Data de Nascimento: " +
                formatoData.format(dataNascimento));
    }
}