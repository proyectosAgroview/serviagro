package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.FactorConversion;
import co.com.arcosoft.modelo.dto.FactorConversionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFactorConversionLogic {
	public List<FactorConversion> getFactorConversion() throws Exception;

	/**
	 * Save an new FactorConversion entity
	 */
	public void saveFactorConversion(FactorConversion entity) throws Exception;

	/**
	 * Delete an existing FactorConversion entity
	 *
	 */
	public void deleteFactorConversion(FactorConversion entity) throws Exception;

	/**
	 * Update an existing FactorConversion entity
	 *
	 */
	public void updateFactorConversion(FactorConversion entity) throws Exception;

	/**
	 * Load an existing FactorConversion entity
	 *
	 */
	public FactorConversion getFactorConversion(Long factorConversionId) throws Exception;

	public List<FactorConversion> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FactorConversion> findPageFactorConversion(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFactorConversion() throws Exception;

	public List<FactorConversionDTO> getDataFactorConversion() throws Exception;
}
