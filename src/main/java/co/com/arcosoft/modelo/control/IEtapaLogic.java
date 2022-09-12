package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.Etapa;
import co.com.arcosoft.modelo.dto.EtapaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IEtapaLogic {
	public List<Etapa> getEtapa() throws Exception;

	/**
	 * Save an new Etapa entity
	 */
	public void saveEtapa(Etapa entity) throws Exception;

	/**
	 * Delete an existing Etapa entity
	 *
	 */
	public void deleteEtapa(Etapa entity) throws Exception;

	/**
	 * Update an existing Etapa entity
	 *
	 */
	public void updateEtapa(Etapa entity) throws Exception;

	/**
	 * Load an existing Etapa entity
	 *
	 */
	public Etapa getEtapa(Long etapaId) throws Exception;

	public List<Etapa> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Etapa> findPageEtapa(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEtapa() throws Exception;

	public List<EtapaDTO> getDataEtapa() throws Exception;
}
