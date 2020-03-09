package sample;

public class Fecha implements Comparable<Fecha> {

    private int dia;
    private int mes;
    private int ano;

    public void Fecha() {
        this.dia = 0;
        this.mes = 0;
        this.ano = 0;
    }

    public void Fecha (int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public void setDia(int dia) {

        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return this.dia + "-" + this.mes + "-" + this.ano;
    }

    @Override
    public int compareTo(Fecha otro) {
        int i = -3;
        if (this.dia == otro.dia && this.ano == otro.ano && this.mes == otro.mes) {
            i = 0;
        }
        if (this.ano > otro.ano) {
            i = 1;
        }
        if (this.ano < otro.ano) {
            if (this.mes > otro.mes) {
                i = 1;
            }
            if (this.mes < otro.mes) {
                if (this.dia > otro.dia) {
                    i = 1;
                } else {
                    i = -1;
                }
            }
        }
        return i;
    }

}
