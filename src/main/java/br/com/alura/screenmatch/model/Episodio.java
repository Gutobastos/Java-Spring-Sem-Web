package br.com.alura.screenmatch.model;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Episodio {

    private int temporada;
    private String titulo;
    private int numeroDoEpisodio;
    private double avaliacao;
    private LocalDate dataDeLancamento;

    public Episodio(int numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroDoEpisodio = dadosEpisodio.numero();

        try {
            this.avaliacao = Double.parseDouble(dadosEpisodio.avaliacao());
        } catch (NumberFormatException av) {
            this.avaliacao = 0.0;
        }
//        this.dataDeLancamento = LocalDate.parse(dadosEpisodio.dataDeLancamento());
        try {
            this.dataDeLancamento = LocalDate.parse(dadosEpisodio.dataDeLancamento());
        } catch (DateTimeException dt) {
            this.dataDeLancamento = null;
        }
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public LocalDate getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(LocalDate dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    @Override
    public String toString() {
        return "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroDoEpisodio +
                ", avaliacao=" + avaliacao +
                ", dataDeLancamento=" + dataDeLancamento;
    }
}
