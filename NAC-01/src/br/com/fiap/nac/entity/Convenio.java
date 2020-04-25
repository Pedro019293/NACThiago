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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONVENIO")
@SequenceGenerator(name = "convenio", sequenceName = "SQ_TB_CONVENIO", allocationSize = 1)
public class Convenio {
	
	@Id
	@Column(name = "nr_cnpj")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "convenio")
	private int cnpj;
	
	@Column(name = "nm_convenio", nullable = false, length = 50)
	private String nomeConvenio;
	
	@Column(name = "ds_contato", nullable = false, length = 100)
	private String contato;
	
	@Column(name = "ds_plano", nullable = false, length = 100)
	private String plano;
	
	
	@OneToMany(mappedBy = "convenio", cascade = CascadeType.ALL)
	private List<Paciente> pacientes = new ArrayList<Paciente>();
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TB_HOSPITAL_CONVENIADO", joinColumns = @JoinColumn(name = "nr_cnpj", nullable = false),
	inverseJoinColumns = @JoinColumn(name = "cd_hospital", nullable = false))
	private List<Hospital> listaHospital = new ArrayList<Hospital>();
	
	

	
	public Convenio() {
		super();
		
	}
	
	public void addPaciente(Paciente paciente) {
		paciente.setConvenio(this);
		pacientes.add(paciente);
	}

	public Convenio(String nomeConvenio, String contato, String plano,
			List<Hospital> listaHospital) {
		super();
		
		this.nomeConvenio = nomeConvenio;
		this.contato = contato;
		this.plano = plano;
		this.listaHospital = listaHospital;
	}



	public int getCnpj() {
		return cnpj;
	}


	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}


	public String getNomeConvenio() {
		return nomeConvenio;
	}


	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}


	public String getContato() {
		return contato;
	}


	public void setContato(String contato) {
		this.contato = contato;
	}


	public String getPlano() {
		return plano;
	}


	public void setPlano(String plano) {
		this.plano = plano;
	}


	public List<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


	public List<Hospital> getListaHospital() {
		return listaHospital;
	}


	public void setListaHospital(List<Hospital> listaHospital) {
		this.listaHospital = listaHospital;
	}

	



	
	
	
	
	
}
