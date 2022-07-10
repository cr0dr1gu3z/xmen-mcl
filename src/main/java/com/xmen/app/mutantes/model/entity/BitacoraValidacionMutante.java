package com.xmen.app.mutantes.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bitacora_validacion_mutante")
public class BitacoraValidacionMutante implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    private String dna;
    
    @Column(name="create_at")
	@Temporal(TemporalType.DATE)
    private Date createAt;
    
    @Column(name="es_mutante")
    private Boolean esMutante;
    

	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Boolean getEsMutante() {
		return esMutante;
	}

	public void setEsMutante(Boolean esMutante) {
		this.esMutante = esMutante;
	}
	
	

}
