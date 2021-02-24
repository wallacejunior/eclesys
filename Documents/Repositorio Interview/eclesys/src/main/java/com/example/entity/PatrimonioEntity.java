package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity(name="patrimonio")
public class PatrimonioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable=false)
	private String descricao;
	@Column(columnDefinition="mediumblob")
	private byte imagem;
	private String localizacao;
	private double valor;
	@OneToOne(cascade = CascadeType.ALL)
	private DepartamentoEntity departamento;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte getImagem() {
		return imagem;
	}
	public void setImagem(byte image) {
		this.imagem = image;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public DepartamentoEntity getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoEntity departamento) {
		this.departamento = departamento;
	}

}
