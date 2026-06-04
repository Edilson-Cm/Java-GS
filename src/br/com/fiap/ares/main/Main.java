package br.com.fiap.ares.main;

import br.com.fiap.ares.bean.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        Recurso recurso = new Recurso();
        Professor professor = new Professor();
        Simulacao simulacao = new Simulacao();
        Aluno aluno = new Aluno();
        boolean logado = false;

        while (!logado) {
            try {
                String nome = JOptionPane.showInputDialog("Digite seu nome de usuário:");
                if (nome == null) System.exit(0);
                usuario.setNome(nome);
                String email = JOptionPane.showInputDialog("Digite seu e-mail (Gmail, Outlook ou Hotmail):");
                if (email == null) System.exit(0);
                usuario.setEmail(email);
                String senha = JOptionPane.showInputDialog("Digite sua senha:");
                if (senha == null) System.exit(0);
                usuario.setSenha(senha);

                logado = true;
                JOptionPane.showMessageDialog(null, "Bem-vindo à colônia A.R.E.S, " + nome + "!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Atenção: " + e.getMessage());
            }

        }

        boolean jogando = true;
        while (jogando) {
            String decisao = JOptionPane.showInputDialog("==== TERMINAL A.R.E.S. ====\n1.Tarefas\n2.Relatorio da missão\n3.Status\n4.Sair  ");
            if (decisao == null || decisao.equals("4")) {
                jogando = false;
                JOptionPane.showMessageDialog(null,"É uma pena que tenha desistido da cõlonia, até bréve!!");
            }
            if (decisao.equals("1")) {
                String tarefas = JOptionPane.showInputDialog("Qual tarefa deseja fazer?" +
                        "\n1.Analisar e Concertar possiveis falhas no reator {+15% Energia| {-5% O2} | {-3% Água}}" +
                        "\n2.Coleta manual de Gelo superficial {+4L Água | -8% O2 | -5% Energia}" +
                        "\n3. Manutenção de Paineis de Algas {+15 O2 | -4% Água | -2% Energia}");
                if (tarefas == null){
                    continue;
                }

                switch (tarefas) {

                    case "1":
                        recurso.setOxigenio(recurso.getOxigenio() - 5);
                        recurso.setAgua(recurso.getAgua() - 3);
                        JOptionPane.showMessageDialog(null, "Reator reestabilizado, energia transferida (Alguns recursos reduzidos");
                        break;
                    case "2":
                        recurso.setAgua(recurso.getAgua() + 4);
                        recurso.setOxigenio(recurso.getOxigenio() - 8);
                        recurso.setEnergia(recurso.getEnergia() - 5);
                        JOptionPane.showMessageDialog(null, "Coleta bem sucedida, Agua armazenada! (Alguns recursos reduzidos)");
                        break;
                    case "3":
                        recurso.setOxigenio(recurso.getOxigenio() + 15);
                        recurso.setAgua(recurso.getAgua() - 4);
                        recurso.setEnergia(recurso.getEnergia() - 2);
                        JOptionPane.showMessageDialog(null, "Paineis em perfeito estado! (Alguns recursos reduzidos!)");
                        break;
                    default: JOptionPane.showMessageDialog(null, "Comando não reconhecido. Ação abordada!");
                }
                try {
                    simulacao.processarTurno(professor,recurso,aluno);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"GAME OVER! "+e.getMessage());
                    jogando = false;
                }
            }else if (decisao.equals("2")) {
                JOptionPane.showMessageDialog(null, "==== RELATÓRIO OFICIAL A.R.E.S. ====\n\n" +
                        "Operador Cadastrado: " + usuario.getNome() + "\n" +
                        "Ciclos Sobrevividos: " + aluno.getDiasSobrevividos() + " dias\n" +
                        "Status Atual da Colônia: Operacional");
            }
            else if (decisao.equals("3")) {
                recurso.consumirCiclo();
                String alertaDoSistema = recurso.verificarStatusCritico(); //

                JOptionPane.showMessageDialog(null, "----------Status----------\n" +
                        " Oxigênio: " + recurso.getOxigenio() + "%\n" +
                        " Energia: " + recurso.getEnergia() + "%\n" +
                        " Água: " + recurso.getAgua() + "%\n"+alertaDoSistema+"\n\n" +"AVISO:Você perde um pouco de recursos em ações!\ncomo o simples ato de abrir seus status\n\n");

            }
            else {
                // A barreira contra inputs zoados
                JOptionPane.showMessageDialog(null, "Formato incorreto! Comando não reconhecido pelo terminal A.R.E.S.");
            }
        }
    }
}

