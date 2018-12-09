package com.example.mattheus.trabalho03dcc196;

public class Jogador {
    private Integer id;
    private String nome;
    private String classe;
    private String forca;
    private String destreza;
    private String nervos;
    private String constituicao;
    private String mente;
    private String synth;
    private String sabedoria;
    private String carisma;


    private String id_aventura;

    public Jogador() {
    }

    public Jogador(Integer id, String nome, String classe, String forca, String destreza, String nervos, String constituicao, String mente, String synth, String sabedoria, String carisma, String id_aventura) {
        this.id = id;
        this.nome = nome;
        this.classe = classe;
        this.forca = forca;
        this.destreza = destreza;
        this.nervos = nervos;
        this.constituicao = constituicao;
        this.mente = mente;
        this.synth = synth;
        this.sabedoria = sabedoria;
        this.carisma = carisma;
        this.id_aventura = id_aventura;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
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

    public String getId_aventura() {
        return id_aventura;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClasse(String classe) {
        this.classe = classe;
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

    public void setId_aventura(String id_aventura) {
        this.id_aventura = id_aventura;
    }


}
