package br.com.fiap.ares.bean;

public class Simulacao {
    private Aluno comandante;
    private Recurso recursosAtuais;
    private int diasSobrevividos;
    private boolean statusAtivo;

    public Simulacao() {
    }

    public Simulacao(Aluno comandante, Recurso recursosIniciais) {
        this.comandante = comandante;
        this.recursosAtuais = recursosIniciais;
        this.diasSobrevividos = 0;
        this.statusAtivo = true;
    }

    public Aluno getComandante() {
        return comandante;
    }

    public void setComandante(Aluno comandante) {
        this.comandante = comandante;
    }

    public Recurso getRecursosAtuais() {
        return recursosAtuais;
    }

    public void setRecursosAtuais(Recurso recursosAtuais) {
        this.recursosAtuais = recursosAtuais;
    }

    public int getDiasSobrevividos() {
        return diasSobrevividos;
    }

    public void setDiasSobrevividos(int diasSobrevividos) {
        this.diasSobrevividos = diasSobrevividos;
    }

    public boolean isStatusAtivo() {
        return statusAtivo;
    }

    public void setStatusAtivo(boolean statusAtivo) {
        this.statusAtivo = statusAtivo;
    }

    public void avancarDia() throws Exception {
        if (!statusAtivo) {
            throw new Exception("A simulação já acabou.");
        }

        boolean sobreviveu = this.recursosAtuais.consumirCiclo();

        if (sobreviveu) {
            this.diasSobrevividos++;
        } else {
            this.statusAtivo = false;
            throw new Exception("Game Over. Você sobreviveu por " + diasSobrevividos + " dias.");
        }
    }
    public void processarTurno(Professor prof, Recurso rec, Aluno aluno) throws Exception {
        prof.aplicarEventoInterativo(rec);


        if (rec.getOxigenio() <= 0 || rec.getAgua() <= 0 || rec.getEnergia() <= 0) {
            String motivo = "";
            if (rec.getOxigenio() <= 0) motivo = "Asfixia. Dica: Foque na Manutenção dos Painéis de Algas!";
            else if (rec.getAgua() <= 0) motivo = "Desidratação. Dica: Não esqueça da Coleta de Gelo!";
            else if (rec.getEnergia() <= 0) motivo = "Apagão Crítico. Dica: O Reator precisa de análises constantes!";

            aluno.setCausaMorte(motivo);
            throw new Exception(motivo);
        }

        // Se não morreu, ganha 1 dia de sobrevivência!
        aluno.setDiasSobrevividos(aluno.getDiasSobrevividos() + 1);
    }
}
