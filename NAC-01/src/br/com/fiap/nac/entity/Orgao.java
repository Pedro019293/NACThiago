package br.com.fiap.nac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
