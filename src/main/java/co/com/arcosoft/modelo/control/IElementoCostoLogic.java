package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ElementoCosto;
import co.com.arcosoft.modelo.dto.ElementoCostoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IElementoCostoLogic {
	public List<ElementoCosto> getElementoCosto() throws Exception;

	/**
	 * Save an new ElementoCosto entity
	 */
	public void saveElementoCosto(ElementoCosto entity) throws Exception;

	/**
	 * Delete an existing ElementoCosto entity
	 *
	 */
	public void deleteElementoCosto(ElementoCosto entity) throws Exception;

	/**
	 * Update an existing ElementoCosto entity
	 *
	 */
	public void updateElementoCosto(ElementoCosto entity) throws Exception;

	/**
	 * Load an existing ElementoCosto entity
	 *
	 */
	public ElementoCosto getElementoCosto(Long elemCostoId) throws Exception;

	public List<ElementoCosto> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ElementoCosto> findPageElementoCosto(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberElementoCosto() throws Exception;

	public List<ElementoCostoDTO> getDataElementoCosto() throws Exception;
}
