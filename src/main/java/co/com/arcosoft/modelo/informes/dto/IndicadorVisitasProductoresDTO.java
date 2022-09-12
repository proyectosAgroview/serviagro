package co.com.arcosoft.modelo.informes.dto;

import java.math.BigDecimal;

public class IndicadorVisitasProductoresDTO {

	private String nomCompania;
	private BigDecimal asociacionesImpactadas;
	private BigDecimal productoresImpactados;
	private BigDecimal valumenProducto;

	public String getNomCompania() {
		return nomCompania;
	}

	public void setNomCompania(String nomCompania) {
		this.nomCompania = nomCompania;
	}

	public BigDecimal getAsociacionesImpactadas() {
		return asociacionesImpactadas;
	}

	public void setAsociacionesImpactadas(BigDecimal asociacionesImpactadas) {
		this.asociacionesImpactadas = asociacionesImpactadas;
	}

	public BigDecimal getProductoresImpactados() {
		return productoresImpactados;
	}

	public void setProductoresImpactados(BigDecimal productoresImpactados) {
		this.productoresImpactados = productoresImpactados;
	}

	public BigDecimal getValumenProducto() {
		return valumenProducto;
	}

	public void setValumenProducto(BigDecimal valumenProducto) {
		this.valumenProducto = valumenProducto;
	}

}
