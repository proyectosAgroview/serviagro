package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.SistemaRiego;
import co.com.arcosoft.modelo.dto.SistemaRiegoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ISistemaRiegoLogic {
	public List<SistemaRiego> getSistemaRiego() throws Exception;

	/**
	 * Save an new SistemaRiego entity
	 */
	public void saveSistemaRiego(SistemaRiego entity) throws Exception;

	/**
	 * Delete an existing SistemaRiego entity
	 *
	 */
	public void deleteSistemaRiego(SistemaRiego entity) throws Exception;

	/**
	 * Update an existing SistemaRiego entity
	 *
	 */
	public void updateSistemaRiego(SistemaRiego entity) throws Exception;

	/**
	 * Load an existing SistemaRiego entity
	 *
	 */
	public SistemaRiego getSistemaRiego(Long sistemaRiegoId) throws Exception;

	public List<SistemaRiego> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SistemaRiego> findPageSistemaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSistemaRiego() throws Exception;

	public List<SistemaRiegoDTO> getDataSistemaRiego() throws Exception;
}
