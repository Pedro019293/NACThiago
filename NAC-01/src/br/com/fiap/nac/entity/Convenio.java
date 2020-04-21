package br.com.fiap.nac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
