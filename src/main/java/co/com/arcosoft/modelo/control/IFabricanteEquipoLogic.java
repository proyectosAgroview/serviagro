package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.FabricanteEquipo;
import co.com.arcosoft.modelo.dto.FabricanteEquipoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IFabricanteEquipoLogic {
	public List<FabricanteEquipo> getFabricanteEquipo() throws Exception;

	/**
	 * Save an new FabricanteEquipo entity
	 */
	public void saveFabricanteEquipo(FabricanteEquipo entity) throws Exception;

	/**
	 * Delete an existing FabricanteEquipo entity
	 *
	 */
	public void deleteFabricanteEquipo(FabricanteEquipo entity) throws Exception;

	/**
	 * Update an existing FabricanteEquipo entity
	 *
	 */
	public void updateFabricanteEquipo(FabricanteEquipo entity) throws Exception;

	/**
	 * Load an existing FabricanteEquipo entity
	 *
	 */
	public FabricanteEquipo getFabricanteEquipo(Long fabricEquipId) throws Exception;

	public List<FabricanteEquipo> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FabricanteEquipo> findPageFabricanteEquipo(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFabricanteEquipo() throws Exception;

	public List<FabricanteEquipoDTO> getDataFabricanteEquipo() throws Exception;
}
