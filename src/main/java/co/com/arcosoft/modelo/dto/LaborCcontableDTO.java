package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.CuentaContable;
import co.com.arcosoft.modelo.Labor;

/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public class LaborCcontableDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LaborCcontableDTO.class);
	
	private CuentaContable ccontableId;

	private Labor laborId_Labor;
	private Long LaborCcontableId;
	private String nombreCuenta;
	
	
	
	
	public Long getLaborCcontableId() {
		return LaborCcontableId;
	}

	public void setLaborCcontableId(Long laborCcontableId) {
		LaborCcontableId = laborCcontableId;
	}

	public String getNombreCuenta() {
		return nombreCuenta;
	}

	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}

	public CuentaContable getCcontableId() {
		return ccontableId;
	}

	public void setCcontableId(CuentaContable ccontableId) {
		this.ccontableId = ccontableId;
	}


	public Labor getLaborId_Labor() {
		return laborId_Labor;
	}

	public void setLaborId_Labor(Labor laborId_Labor) {
		this.laborId_Labor = laborId_Labor;
	}
}
