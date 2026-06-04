package br.com.fiap.ares.bean;

public class Recurso implements Monitoravel{
    private double oxigenio;
    private double agua;
    private double energia;

    public Recurso() {
        this.oxigenio = 50;
        this.agua = 50;
        this.energia = 50;
    }

    public Recurso(double oxigenio, double agua, double energia) {
        this.oxigenio = 50;
        this.agua = 50;
        this.energia = 50;
    }

    public double getOxigenio() {
        return oxigenio;
    }

    public void setOxigenio(double oxigenio) {
        this.oxigenio = oxigenio;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public boolean consumirCiclo() {
        this.oxigenio -= 2.0;
        this.energia -= 3.0;

        return (this.agua > 0 && this.energia > 0);
    }

    @Override
    public String verificarStatusCritico() {
        String alerta = "";

        if (this.oxigenio < 20.0) alerta += "[O2 BAIXO] ";
        if (this.agua < 20.0) alerta += "[ÁGUA BAIXA] ";
        if (this.energia < 20.0) alerta += "[ENERGIA BAIXA] ";

        if (alerta.isEmpty()) {
            return "Sistemas estáveis.";
        }

        return "ALERTA CRÍTICO: " + alerta;
    }
}

