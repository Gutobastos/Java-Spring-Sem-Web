package br.com.alura.screenmatch.model;

import java.time.LocalDate;

public class Episodio {

    private int temporada;
    private String titulo;
    private int numeroEpisodio;
    private int episodio;
    private double avaliacao;
    private LocalDate dataDeLancamento;

    public Episodio (int numeroTemporada, DadosEpisodio dadosEpisodio) {
        this.temporada = numeroTemporada;
        this.titulo = dadosEpisodio.titulo();
        this.numeroEpisodio = dadosEpisodio.numero();
        this.avaliacao = Double.valueOf(dadosEpisodio.avaliacao());
        this.dataDeLancamento = LocalDate.parse(dadosEpisodio.dataDeLancamento());
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

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
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
}
