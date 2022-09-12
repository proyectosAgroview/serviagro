package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.AnioFiscal;
import co.com.arcosoft.modelo.dto.AnioFiscalDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IAnioFiscalLogic {
	public List<AnioFiscal> getAnioFiscal() throws Exception;

	/**
	 * Save an new AnioFiscal entity
	 */
	public void saveAnioFiscal(AnioFiscal entity) throws Exception;

	/**
	 * Delete an existing AnioFiscal entity
	 *
	 */
	public void deleteAnioFiscal(AnioFiscal entity) throws Exception;

	/**
	 * Update an existing AnioFiscal entity
	 *
	 */
	public void updateAnioFiscal(AnioFiscal entity) throws Exception;

	/**
	 * Load an existing AnioFiscal entity
	 *
	 */
	public AnioFiscal getAnioFiscal(Long anioFiscalId) throws Exception;

	public List<AnioFiscal> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AnioFiscal> findPageAnioFiscal(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAnioFiscal() throws Exception;

	public List<AnioFiscalDTO> getDataAnioFiscal() throws Exception;
}
