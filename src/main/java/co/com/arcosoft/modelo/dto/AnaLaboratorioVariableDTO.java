package co.com.arcosoft.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.arcosoft.modelo.VariableLab;


/**
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public class AnaLaboratorioVariableDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(AnaLaboratorioVariableDTO.class);
    private Long anaLaboratorioVariableId;
    private Long ordenDigitacion;
    private Long anaLabId_AnaLaboratorio;
    private VariableLab variableLabId_VariableLab;
    private String codigoVariable;
    
    
    /**
	 * @return the codigoVariable
	 */
	public String getCodigoVariable() {
		return codigoVariable;
	}

	/**
	 * @param codigoVariable the codigoVariable to set
	 */
	public void setCodigoVariable(String codigoVariable) {
		this.codigoVariable = codigoVariable;
	}

	public Long getAnaLaboratorioVariableId() {
        return anaLaboratorioVariableId;
    }

    public void setAnaLaboratorioVariableId(Long anaLaboratorioVariableId) {
        this.anaLaboratorioVariableId = anaLaboratorioVariableId;
    }

    public Long getOrdenDigitacion() {
        return ordenDigitacion;
    }

    public void setOrdenDigitacion(Long ordenDigitacion) {
        this.ordenDigitacion = ordenDigitacion;
    }

    public Long getAnaLabId_AnaLaboratorio() {
        return anaLabId_AnaLaboratorio;
    }

    public void setAnaLabId_AnaLaboratorio(Long anaLabId_AnaLaboratorio) {
        this.anaLabId_AnaLaboratorio = anaLabId_AnaLaboratorio;
    }

    public VariableLab getVariableLabId_VariableLab() {
        return variableLabId_VariableLab;
    }

    public void setVariableLabId_VariableLab(VariableLab variableLabId_VariableLab) {
        this.variableLabId_VariableLab = variableLabId_VariableLab;
    }
}
