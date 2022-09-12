package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaInfraestructura;
import co.com.arcosoft.modelo.dto.TarifaInfraestructuraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaInfraestructuraLogic {
	public List<TarifaInfraestructura> getTarifaInfraestructura() throws Exception;

	/**
	 * Save an new TarifaInfraestructura entity
	 */
	public void saveTarifaInfraestructura(TarifaInfraestructura entity) throws Exception;

	/**
	 * Delete an existing TarifaInfraestructura entity
	 *
	 */
	public void deleteTarifaInfraestructura(TarifaInfraestructura entity) throws Exception;

	/**
	 * Update an existing TarifaInfraestructura entity
	 *
	 */
	public void updateTarifaInfraestructura(TarifaInfraestructura entity) throws Exception;

	/**
	 * Load an existing TarifaInfraestructura entity
	 *
	 */
	public TarifaInfraestructura getTarifaInfraestructura(Long tarInfraId) throws Exception;

	public List<TarifaInfraestructura> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaInfraestructura> findPageTarifaInfraestructura(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberTarifaInfraestructura() throws Exception;

	public List<TarifaInfraestructuraDTO> getDataTarifaInfraestructura() throws Exception;

	public List<TarifaInfraestructuraDTO> getDataInfraestructuraByTarifaId(Long Id) throws Exception;
}
