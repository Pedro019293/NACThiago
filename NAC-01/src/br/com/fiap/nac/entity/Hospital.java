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

}
