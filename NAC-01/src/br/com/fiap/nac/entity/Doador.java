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

}
