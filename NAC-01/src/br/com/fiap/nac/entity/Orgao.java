package br.com.fiap.nac.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ORGAO")
@SequenceGenerator(name = "orgao", sequenceName = "SQ_TB_ORGAO", allocationSize = 1)
public class Orgao {
	
	@Id
	@Column(name = "cd_orgao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgao")
	private int codigoOrgao;
	
	@Column(name = "nm_orgao", nullable = false, length = 50)
	private String nomeOrgao;	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_doador", nullable = false)
	private Doador codigoDoador;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_paciente", nullable =false)
	private Paciente paciente;
	
	
	public Orgao() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Orgao(String nomeOrgao, Doador codigoDoador ) {
		super();
		this.nomeOrgao = nomeOrgao;
		this.codigoDoador = codigoDoador;
		
	}



	public int getCodigoOrgao() {
		return codigoOrgao;
	}


	public void setCodigoOrgao(int codigoOrgao) {
		this.codigoOrgao = codigoOrgao;
	}


	public String getNomeOrgao() {
		return nomeOrgao;
	}


	public void setNomeOrgao(String nomeOrgao) {
		this.nomeOrgao = nomeOrgao;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	

	
	
	
}
