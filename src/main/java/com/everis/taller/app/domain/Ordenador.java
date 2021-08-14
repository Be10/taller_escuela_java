package com.everis.taller.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_ordenador")

public class Ordenador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ordenador", length = 5)
	private Long idOrdenador;
	
	@Column(name = "marca_ordenador", length = 25, nullable = false)
	@NotNull
	@Min(value = 2)
	@Pattern(regexp="^[A-Za-z]*$")
	private String marca_ordenador;
	
	@Column(name = "modelo_ordenador", length = 10, nullable = false)
	@NotNull
	@Min(value = 2)
	private String modelo_ordenador;
	
	@Column(name = "nro_serie", length = 15, unique = true, nullable = false)
	@NotNull
	@Min(value = 8)
	private String nro_serie;
	
	@Column(name = "nro_parte", length = 15, unique = true, nullable = false)
	@NotNull
	@Min(value = 8)
	private String nro_parte;
	
	@Column(name = "categoria_ordenador", length = 25, nullable = true)
	@Min(value = 2)
	@Pattern(regexp="^[A-Za-z]*$")
	private String categoria_ordenador;

}