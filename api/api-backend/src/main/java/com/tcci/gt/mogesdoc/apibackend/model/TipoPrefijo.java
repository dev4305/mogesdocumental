package com.tcci.gt.mogesdoc.apibackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TIPO_PREFIJO", schema = "MOGESDOC")
public class TipoPrefijo {
    
    @Id
	@SequenceGenerator(name = "tipo_prefijo_seq",schema = "MOGESDOC",sequenceName = "SEQ_TIPO_PREFIJO",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipo_prefijo_seq")
	@Column(name = "ID_TIPO_PREFIJO")
	private Integer id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "ESTADO")
	private String estado;
    
}
