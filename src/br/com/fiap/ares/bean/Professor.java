package br.com.fiap.ares.bean;

import javax.swing.*;
import java.util.Random;

public class Professor {
    private String departamento;

    public Professor() {
    }

    public Professor(String departamento) {
        this.departamento = departamento;
    }


    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void aplicarEventoInterativo(Recurso rec) {
        Random random = new Random();
        double chances = random.nextDouble() * 100;

        if (chances < 20.0) {
            String acao;
            while (true) {
                acao = JOptionPane.showInputDialog(
                        "ALERTA VERMELHO: Tempestade de Poeira se aproximando!\n\n" +
                                "1. Ligar Escudos Máximos (-18 Energia)\n" +
                                "2. Suportar o impacto (-28 Energia | -10 O2)"
                );

                if (acao == null || (!acao.equals("1") && !acao.equals("2"))) {
                    JOptionPane.showMessageDialog(null,"ERRO CRÍTICO: Comando inválido! A tempestade não vai esperar!");
                } else {
                    break;
                }
            }

            if (acao.equals("1")) {
                rec.setEnergia(rec.getEnergia() - 15);
                JOptionPane.showMessageDialog(null, "Escudos ativados com sucesso!");
            } else {
                rec.setEnergia(rec.getEnergia() - 25);
                rec.setOxigenio(rec.getOxigenio() - 10);
                JOptionPane.showMessageDialog(null, "A base sofreu danos severos!");
            }


            } else if (chances >= 20.0 && chances < 40.0) {
            String acao;
            while (true) {
                acao = JOptionPane.showInputDialog(
                        "URGENTE: Vazamento estrutural de O2 detectado! \n\n" +
                                "1. Usar kit de reparo com Água (-10 Água)\n" +
                                "2. Ignorar desastre (-20 O2)"
                );

                if (acao == null || (!acao.equals("1") && !acao.equals("2"))) {
                    JOptionPane.showMessageDialog(null, "ERRO CRÍTICO: Comando inválido! O oxigênio está escapando!");
                } else {
                    break;
                }
            }

            if (acao.equals("1")) {
                rec.setAgua(rec.getAgua() - 10);
                JOptionPane.showMessageDialog(null, "Vazamento selado!");
            } else {
                rec.setOxigenio(rec.getOxigenio() - 20);
                JOptionPane.showMessageDialog(null, "O oxigênio vazou drasticamente!");
            }


            } else {
            JOptionPane.showMessageDialog(null, "Brisa Solar (leve): Um dia tranquilo na colônia. Seus colonos descansam.");
        }
        }



}
