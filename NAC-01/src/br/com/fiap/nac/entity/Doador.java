package br.com.fiap.nac.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_DOADOR")
@SequenceGenerator(name = "doador", sequenceName = "SQ_TB_DOADOR", allocationSize = 1)
public class Doador {
	
	@Id
	@Column(name = "cd_doador")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doador")
	private int codigoDoador;
	
	@Column(name = "nm_doador", nullable = false, length = 100)
	private String nomeDoador;
	
	@Column(name = "ds_orgao", nullable = false, length = 255)
	private String orgao;
	
	@Column(name = "ds_localizacao", nullable = false, length = 255)
	private String localizacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_isquemia", nullable = false)
	private Calendar dataIsquemia;
	
	//mapeamento
	@OneToMany(mappedBy = "codigoDoador")
	private List<Orgao> listaOrgaos = new ArrayList<Orgao>();
	
	
	public Doador() {
		super();
	
	}


	public Doador(String nomeDoador, String orgao, String localizacao, Calendar dataIsquemia) {
		super();
		this.nomeDoador = nomeDoador;
		this.orgao = orgao;
		this.localizacao = localizacao;
		this.dataIsquemia = dataIsquemia;
		
	}




	public int getCodigoDoador() {
		return codigoDoador;
	}


	public void setCodigoDoador(int codigoDoador) {
		this.codigoDoador = codigoDoador;
	}


	public String getNomeDoador() {
		return nomeDoador;
	}


	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}


	public String getOrgao() {
		return orgao;
	}


	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}


	public String getLocalizacao() {
		return localizacao;
	}


	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}


	public Calendar getDataIsquemia() {
		return dataIsquemia;
	}


	public void setDataIsquemia(Calendar dataIsquemia) {
		this.dataIsquemia = dataIsquemia;
	}


	public List<Orgao> getListaOrgaos() {
		return listaOrgaos;
	}


	public void setListaOrgaos(List<Orgao> listaOrgaos) {
		this.listaOrgaos = listaOrgaos;
	}
	
	
	
	

}
