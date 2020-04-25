package br.com.fiap.nac.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_HOSPITAL")
@SequenceGenerator(name = "hospital", sequenceName = "SQ_TB_HOSPITAL", allocationSize = 1)
public class Hospital {
	
	@Id
	@Column(name = "cd_hospital")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hospital")
	private int codigoHospital;
	
	@Column(name = "nm_hospital", nullable = false, length = 100)
	private String nomeHospital;
	
	@Column(name = "ds_endereco", nullable = false, length = 255)
	private String endereco;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_entrada", nullable = false)
	private Calendar dataEntrada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_saida", nullable = false)
	private Calendar dataSaida;
	
	@ManyToMany(mappedBy = "listaHospital", cascade=CascadeType.ALL)
	private List<Convenio> listaConvenio = new ArrayList<Convenio>();
	

	public Hospital() {
		super();

	}
	
	public Hospital(String nomeHospital, String endereco, Calendar dataEntrada, Calendar dataSaida) {
		super();
		this.nomeHospital = nomeHospital;
		this.endereco = endereco;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;

	}
	

	public int getCodigoHospital() {
		return codigoHospital;
	}

	public void setCodigoHospital(int codigoHospital) {
		this.codigoHospital = codigoHospital;
	}

	public String getNomeHospital() {
		return nomeHospital;
	}

	public void setNomeHospital(String nomeHospital) {
		this.nomeHospital = nomeHospital;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public List<Convenio> getListaConvenio() {
		return listaConvenio;
	}

	public void setListaConvenio(List<Convenio> listaConvenio) {
		this.listaConvenio = listaConvenio;
	}
	
	

}
