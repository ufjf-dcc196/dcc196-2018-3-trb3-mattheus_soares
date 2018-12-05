package com.example.mattheus.trabalho03dcc196;

import java.util.ArrayList;

public class Aventura {
    private Integer id;
    private String nome;
    private String descricao;
    private String forca;
    private String destreza;
    private String nervos;
    private String constituicao;
    private String mente;
    private String synth;
    private String sabedoria;
    private String carisma;
    private ArrayList<Jogador> jogadores;

    public Aventura() {
    }

    public Aventura(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Aventura(Integer id, String nome, String descricao, String forca, String destreza, String nervos, String constituicao, String mente, String synth, String sabedoria, String carisma) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.forca = forca;
        this.destreza = destreza;
        this.nervos = nervos;
        this.constituicao = constituicao;
        this.mente = mente;
        this.synth = synth;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.jogadores = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getForca() {
        return forca;
    }

    public String getDestreza() {
        return destreza;
    }

    public String getNervos() {
        return nervos;
    }

    public String getConstituicao() {
        return constituicao;
    }

    public String getMente() {
        return mente;
    }

    public String getSynth() {
        return synth;
    }

    public String getSabedoria() {
        return sabedoria;
    }

    public String getCarisma() {
        return carisma;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setForca(String forca) {
        this.forca = forca;
    }

    public void setDestreza(String destreza) {
        this.destreza = destreza;
    }

    public void setNervos(String nervos) {
        this.nervos = nervos;
    }

    public void setConstituicao(String constituicao) {
        this.constituicao = constituicao;
    }

    public void setMente(String mente) {
        this.mente = mente;
    }

    public void setSynth(String synth) {
        this.synth = synth;
    }

    public void setSabedoria(String sabedoria) {
        this.sabedoria = sabedoria;
    }

    public void setCarisma(String carisma) {
        this.carisma = carisma;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}

