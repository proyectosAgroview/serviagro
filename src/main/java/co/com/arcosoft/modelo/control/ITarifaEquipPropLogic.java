package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.TarifaEquipProp;
import co.com.arcosoft.modelo.dto.TarifaEquipPropDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface ITarifaEquipPropLogic {
	public List<TarifaEquipProp> getTarifaEquipProp() throws Exception;

	/**
	 * Save an new TarifaEquipProp entity
	 */
	public void saveTarifaEquipProp(TarifaEquipProp entity) throws Exception;

	/**
	 * Delete an existing TarifaEquipProp entity
	 *
	 */
	public void deleteTarifaEquipProp(TarifaEquipProp entity) throws Exception;

	/**
	 * Update an existing TarifaEquipProp entity
	 *
	 */
	public void updateTarifaEquipProp(TarifaEquipProp entity) throws Exception;

	/**
	 * Load an existing TarifaEquipProp entity
	 *
	 */
	public TarifaEquipProp getTarifaEquipProp(Long tarifaEquipPropId) throws Exception;

	public List<TarifaEquipProp> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TarifaEquipProp> findPageTarifaEquipProp(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTarifaEquipProp() throws Exception;

	public List<TarifaEquipPropDTO> getDataTarifaEquipProp() throws Exception;

	public List<TarifaEquipPropDTO> getDataEquipoByTarifaEquipPropId(Long equipoId) throws Exception;
}
