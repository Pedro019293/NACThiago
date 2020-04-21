package br.com.fiap.nac.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="ds_orgao", nullable = false, length = 255)
	private String orgao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ds_nascimento", nullable = false)
	private Calendar dataNascimento;
	
	@Column(name="ds_endereco", nullable = false, length = 255)
	private String endereco;
	
	@Column(name="ds_convenio", nullable = false, length = 255)
	private String convenio;
	
	@Column(name="fl_foto")
	private byte[] foto;

}
