package br.com.fiap.nac.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "TB_PACIENTE")
@SequenceGenerator(name = "paciente", sequenceName = "SQ_TB_PACIENTE", allocationSize = 1)
public class Paciente {
	
	@Id
	@Column(name = "cd_paciente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente")
	private int codigoPaciente;
	
	@Column(name="nm_paciente", nullable = false, length = 255)
	private String nomePaciente;
	
//	@Column(name="ds_orgao", nullable = false, length = 255)
//	private String orgao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ds_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero", nullable = false) 
	private Genero genero;
	
	@Column(name="ds_endereco", nullable = false, length = 255)
	private String endereco;
	
//	@Column(name="ds_convenio", nullable = false, length = 255)
//	private String convenio;
	
	@Lob
	@Column(name="fl_foto")
	private byte[] foto;
	
	@OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
	private List<Orgao> orgaos = new ArrayList<Orgao>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_convenio",nullable=false)
	private Convenio convenio;
	
	//public void addOrgaos(Orgao orgaos) {
		//orgaos.setNomeOrgao(this);
	//}
	

	public Paciente() {
		super();
		
	}
	
	

	public Paciente(String nomePaciente, Calendar dataNascimento, Genero genero, String endereco, byte[] foto,
			List<Orgao> orgaos, Convenio convenio) {
		super();
		this.nomePaciente = nomePaciente;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
		this.endereco = endereco;
		this.foto = foto;
		this.orgaos = orgaos;
		this.convenio = convenio;
	}



	public int getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	

	
	
	

	

	
	

}
