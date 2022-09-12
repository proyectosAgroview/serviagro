package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AnaLabCultivo;
import co.com.arcosoft.modelo.dto.AnaLabCultivoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IAnaLabCultivoLogic {
	public List<AnaLabCultivo> getAnaLabCultivo() throws Exception;

	/**
	 * Save an new AnaLabCultivo entity
	 */
	public void saveAnaLabCultivo(AnaLabCultivo entity) throws Exception;

	/**
	 * Delete an existing AnaLabCultivo entity
	 *
	 */
	public void deleteAnaLabCultivo(AnaLabCultivo entity) throws Exception;

	/**
	 * Update an existing AnaLabCultivo entity
	 *
	 */
	public void updateAnaLabCultivo(AnaLabCultivo entity) throws Exception;

	/**
	 * Load an existing AnaLabCultivo entity
	 *
	 */
	public AnaLabCultivo getAnaLabCultivo(Long anaLabCultId) throws Exception;

	public List<AnaLabCultivo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnaLabCultivo> findPageAnaLabCultivo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAnaLabCultivo() throws Exception;

	public List<AnaLabCultivoDTO> getDataAnaLabCultivo() throws Exception;
}
