package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoRecursosOtros;
import co.com.arcosoft.modelo.dto.TipoRecursosOtrosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoRecursosOtrosLogic {
	public List<TipoRecursosOtros> getTipoRecursosOtros() throws Exception;

	/**
	 * Save an new TipoRecursosOtros entity
	 */
	public void saveTipoRecursosOtros(TipoRecursosOtros entity) throws Exception;

	/**
	 * Delete an existing TipoRecursosOtros entity
	 *
	 */
	public void deleteTipoRecursosOtros(TipoRecursosOtros entity) throws Exception;

	/**
	 * Update an existing TipoRecursosOtros entity
	 *
	 */
	public void updateTipoRecursosOtros(TipoRecursosOtros entity) throws Exception;

	/**
	 * Load an existing TipoRecursosOtros entity
	 *
	 */
	public TipoRecursosOtros getTipoRecursosOtros(Long tipoRecursosOtrosId) throws Exception;

	public List<TipoRecursosOtros> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoRecursosOtros> findPageTipoRecursosOtros(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoRecursosOtros() throws Exception;

	public List<TipoRecursosOtrosDTO> getDataTipoRecursosOtros() throws Exception;

	public List<TipoRecursosOtrosDTO> getDataTipoRecursosOtrosByOtros(Long tipoRecursosOtrosId) throws Exception;

}
