package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.RangoValor;
import co.com.arcosoft.modelo.dto.RangoValorDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IRangoValorLogic {
	public List<RangoValor> getRangoValor() throws Exception;

	/**
	 * Save an new RangoValor entity
	 */
	public void saveRangoValor(RangoValor entity) throws Exception;

	/**
	 * Delete an existing RangoValor entity
	 *
	 */
	public void deleteRangoValor(RangoValor entity) throws Exception;

	/**
	 * Update an existing RangoValor entity
	 *
	 */
	public void updateRangoValor(RangoValor entity) throws Exception;

	/**
	 * Load an existing RangoValor entity
	 *
	 */
	public RangoValor getRangoValor(Long rangoValorId) throws Exception;

	public List<RangoValor> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RangoValor> findPageRangoValor(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRangoValor() throws Exception;

	public List<RangoValorDTO> getDataRangoValor() throws Exception;

	public List<RangoValorDTO> getDataRangoValorById(Long variableId) throws Exception;
}
