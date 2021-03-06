package com.br.ifce.cantina.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
public class Almoco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 45)
  private String prato_proteico;

  @Column(nullable = false, length = 45)
  private String acompanhamento;

  @Column(nullable = false, length = 45)
  private String guarnicao;

  @Column(nullable = false, length = 45)
  private String salada;

  @Column(nullable = false, length = 45)
  private String sobremesa;

  @ManyToMany
  @JoinTable(name = "almoco_has_alimento", uniqueConstraints = @UniqueConstraint(columnNames = { "id_alimento",
      "id_almoco" }), joinColumns = @JoinColumn(name = "id_almoco"), inverseJoinColumns = @JoinColumn(name = "id_alimento"))
  private Set<Alimento> alimentos = new HashSet<>();

  @OneToMany(mappedBy = "almoco", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private Set<CardapioDiario> cardapiosDiario = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPrato_proteico() {
    return prato_proteico;
  }

  public void setPrato_proteico(String prato_proteico) {
    this.prato_proteico = prato_proteico;
  }

  public String getAcompanhamento() {
    return acompanhamento;
  }

  public void setAcompanhamento(String acompanhamento) {
    this.acompanhamento = acompanhamento;
  }

  public String getGuarnicao() {
    return guarnicao;
  }

  public void setGuarnicao(String guarnicao) {
    this.guarnicao = guarnicao;
  }

  public String getSalada() {
    return salada;
  }

  public void setSalada(String salada) {
    this.salada = salada;
  }

  public String getSobremesa() {
    return sobremesa;
  }

  public void setSobremesa(String sobremesa) {
    this.sobremesa = sobremesa;
  }
}
