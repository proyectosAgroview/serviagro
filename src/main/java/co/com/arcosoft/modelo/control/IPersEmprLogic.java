package co.com.arcosoft.modelo.control;

import java.util.List;
import java.util.Map;

import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.dto.PersEmprDTO;
import co.com.arcosoft.modelo.dto.TarifaContratistaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IPersEmprLogic {
	public List<PersEmpr> getPersEmpr() throws Exception;

	/**
	 * Save an new PersEmpr entity
	 */
	public void savePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception;

	/**
	 * Delete an existing PersEmpr entity
	 *
	 */
	public void deletePersEmpr(PersEmpr entity) throws Exception;

	/**
	 * Update an existing PersEmpr entity
	 *
	 */
	public void updatePersEmpr(PersEmpr entity, List<TarifaContratistaDTO> dataTarifaContratista) throws Exception;

	/**
	 * Load an existing PersEmpr entity
	 *
	 */
	public PersEmpr getPersEmpr(Long persEmprId) throws Exception;

	public List<PersEmpr> findByCriteria(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<PersEmpr> findPagePersEmpr(String sortColumnName, boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPersEmpr() throws Exception;

	public List<PersEmprDTO> getDataPersEmpr() throws Exception;

	public List<PersEmprDTO> findByCriteriaPageEmpresa(int startRow, int pageSize, String sortField, boolean sortOrder,
			Map<String, Object> filters) throws Exception;

	public Long findTotalNumberEmpresa(Map<String, Object> filters) throws Exception;
}
