package main;

import java.util.Scanner;
import java.util.Date;

public class Principal {

    public static void main(String[] args) {

        // Scanner serve para ler o que o usuário digita no teclado
        Scanner sc = new Scanner(System.in);

        // Vetor (lista simples) para guardar até 5 usuários
        Usuario[] usuarios = new Usuario[5];

        // Essa variável guarda quantos usuários já foram cadastrados
        int qtd = 0;

        // Essa variável guarda a opção do menu
        int op = 0;

        // DO WHILE = repete o menu até o usuário escolher sair (5)
        do {

            // Mostra o menu na tela
            System.out.println("\nInforme uma opção:");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Editar Usuario");
            System.out.println("3 - Listar Usuario");
            System.out.println("4 - Remover Usuario");
            System.out.println("5 - Sair");

            // Lê o número digitado
            op = sc.nextInt();

            // OPÇÃO 1 = CADASTRAR USUÁRIO
            if (op == 1) {

                // Verifica se ainda tem espaço no vetor
                if (qtd < 5) {

                    // Pergunta se é aluno ou professor
                    System.out.println("Digite 1 para Aluno ou 2 para Professor:");
                    int tipo = sc.nextInt();

                    // Lê o nome
                    System.out.println("Nome:");
                    String nome = sc.next();

                    // Lê a data de nascimento
                    System.out.println("Data de nascimento (dd/MM/yyyy):");

                    // Lê a data completa
                    String nascimento = sc.next();

                    // Divide a data usando "/"
                    String[] partes = nascimento.split("/");

                    // Guarda dia, mês e ano separados
                    int dia = Integer.parseInt(partes[0]);
                    int mes = Integer.parseInt(partes[1]);
                    int ano = Integer.parseInt(partes[2]);

                    // Cria a data completa
                    Date data = new Date(ano - 1900, mes - 1, dia);

                    // Se for aluno
                    if (tipo == 1) {

                        // Lê a matrícula
                        System.out.println("Matricula:");
                        long mat = sc.nextLong();

                        // Lê o CRE
                        System.out.println("CRE:");
                        double cre = sc.nextDouble();

                        // Cria um objeto Aluno e guarda no vetor
                        usuarios[qtd] = new Aluno(nome, mat, data, cre);
                    }

                    // Se for professor
                    if (tipo == 2) {

                        // Lê o SIAPE
                        System.out.println("SIAPE:");
                        String siape = sc.next();

                        // Lê a carga horária
                        System.out.println("Carga Horaria:");
                        int ch = sc.nextInt();

                        // Cria um objeto Professor
                        usuarios[qtd] = new Professor(nome, siape, data, ch);
                    }

                    // Aumenta a quantidade de usuários cadastrados
                    qtd++;
                }
            }

            // OPÇÃO 2 = EDITAR
            if (op == 2) {

                // Pergunta se vai editar aluno ou professor
                System.out.println("Digite 1 para Aluno ou 2 para Professor:");
                int tipo = sc.nextInt();

                // Se for aluno
                if (tipo == 1) {

                    // Pede a matrícula do aluno
                    System.out.println("Digite a matricula:");
                    long mat = sc.nextLong();

                    // Percorre o vetor
                    for (int i = 0; i < qtd; i++) {

                        // Verifica se encontrou o aluno
                        if (usuarios[i] != null &&
                            usuarios[i].getMatricula() == mat) {

                            // Novo nome
                            System.out.println("Novo nome:");
                            String novoNome = sc.next();

                            // Nova matrícula
                            System.out.println("Nova matricula:");
                            long novaMat = sc.nextLong();

                            // Nova data
                            System.out.println("Nova data (dd/MM/yyyy):");
                            String nascimento = sc.next();

                            // Divide a data usando "/"
                            String[] partes = nascimento.split("/");

                            // Guarda dia, mês e ano separados
                            int dia = Integer.parseInt(partes[0]);
                            int mes = Integer.parseInt(partes[1]);
                            int ano = Integer.parseInt(partes[2]);

                            // Cria a data completa
                            Date novaData =
                                    new Date(ano - 1900, mes - 1, dia);

                            // Atualiza o nome
                            usuarios[i].setNome(novoNome);

                            // Atualiza a matrícula
                            usuarios[i].setMatricula(novaMat);

                            // Atualiza a data de nascimento
                            usuarios[i].setDataNascimento(novaData);

                            System.out.println("Aluno atualizado.");
                        }
                    }
                }

                // Se for professor
                if (tipo == 2) {

                    // Pede o SIAPE
                    System.out.println("Digite o SIAPE:");
                    String siapeBusca = sc.next();

                    // Percorre o vetor
                    for (int i = 0; i < qtd; i++) {

                        // Verifica se o usuário é um professor
                        if (usuarios[i] instanceof Professor) {

                            // Converte o usuário para Professor
                            Professor p = (Professor) usuarios[i];

                            // Verifica se encontrou o professor pelo SIAPE
                            if (p.getSiape().equals(siapeBusca)) {

                                // Novo nome
                                System.out.println("Novo nome:");
                                String novoNome = sc.next();

                                // Nova data
                                System.out.println("Nova data (dd/MM/yyyy):");
                                String nascimento = sc.next();

                                // Divide a data usando "/"
                                String[] partes = nascimento.split("/");

                                // Guarda dia, mês e ano separados
                                int dia = Integer.parseInt(partes[0]);
                                int mes = Integer.parseInt(partes[1]);
                                int ano = Integer.parseInt(partes[2]);

                                // Cria a data completa
                                Date novaData =
                                        new Date(ano - 1900, mes - 1, dia);

                                // Nova carga horária
                                System.out.println("Nova carga horaria:");
                                int novaCH = sc.nextInt();

                                // Atualiza o nome
                                p.setNome(novoNome);

                                // Atualiza a data de nascimento
                                p.setDataNascimento(novaData);

                                // Atualiza a carga horária
                                p.setCargaHoraria(novaCH);

                                System.out.println("Professor atualizado.");
                            }
                        }
                    }
                }
            }

            // OPÇÃO 3 = LISTAR
            if (op == 3) {

                // Percorre todos os usuários
                for (int i = 0; i < qtd; i++) {

                    // Verifica se não é vazio
                    if (usuarios[i] != null) {

                        // Mostra os dados
                        usuarios[i].exibir();

                        System.out.println("-------------------");
                    }
                }
            }

            // OPÇÃO 4 = REMOVER
            if (op == 4) {

                // Pergunta se vai remover aluno ou professor
                System.out.println("Digite 1 para Aluno ou 2 para Professor:");
                int tipo = sc.nextInt();

                // Se for aluno
                if (tipo == 1) {

                    // Pede a matrícula
                    System.out.println("Digite a matricula:");
                    long mat = sc.nextLong();

                    // Percorre o vetor
                    for (int i = 0; i < qtd; i++) {

                        // Verifica se encontrou
                        if (usuarios[i] != null &&
                            usuarios[i].getMatricula() == mat) {

                            // Remove colocando null
                            usuarios[i] = null;

                            System.out.println("Aluno removido");
                        }
                    }
                }

                // Se for professor
                if (tipo == 2) {

                    // Pede o SIAPE
                    System.out.println("Digite o SIAPE:");
                    String siapeBusca = sc.next();

                    // Percorre o vetor
                    for (int i = 0; i < qtd; i++) {

                    	// Verifica se é professor
                    	if (usuarios[i] != null &&
                    	    usuarios[i].getClass() == Professor.class) {

                    	    // Converte para Professor
                    	    Professor p = (Professor) usuarios[i];

                    	    // Verifica se encontrou o professor
                    	    if (p.getSiape().equals(siapeBusca)) {

                    	        // Remove colocando null
                    	        usuarios[i] = null;

                    	        System.out.println("Professor removido");
                    	    }
                    	}
                    }
                }
            }

        } while (op != 5);

        // Mensagem final
        System.out.println("Programa encerrado.");

        // Fecha o scanner
        sc.close();
    }
}