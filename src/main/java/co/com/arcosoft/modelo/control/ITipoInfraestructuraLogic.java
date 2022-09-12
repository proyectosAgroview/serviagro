package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TipoInfraestructura;
import co.com.arcosoft.modelo.dto.TipoInfraestructuraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITipoInfraestructuraLogic {
	public List<TipoInfraestructura> getTipoInfraestructura() throws Exception;

	/**
	 * Save an new TipoInfraestructura entity
	 */
	public void saveTipoInfraestructura(TipoInfraestructura entity) throws Exception;

	/**
	 * Delete an existing TipoInfraestructura entity
	 *
	 */
	public void deleteTipoInfraestructura(TipoInfraestructura entity) throws Exception;

	/**
	 * Update an existing TipoInfraestructura entity
	 *
	 */
	public void updateTipoInfraestructura(TipoInfraestructura entity) throws Exception;

	/**
	 * Load an existing TipoInfraestructura entity
	 *
	 */
	public TipoInfraestructura getTipoInfraestructura(Long tipoInfraId) throws Exception;

	public List<TipoInfraestructura> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoInfraestructura> findPageTipoInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTipoInfraestructura() throws Exception;

	public List<TipoInfraestructuraDTO> getDataTipoInfraestructura() throws Exception;
}
