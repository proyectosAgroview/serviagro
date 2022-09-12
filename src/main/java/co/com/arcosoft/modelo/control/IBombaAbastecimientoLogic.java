package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.BombaAbastecimiento;
import co.com.arcosoft.modelo.dto.BombaAbastecimientoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IBombaAbastecimientoLogic {
	public List<BombaAbastecimiento> getBombaAbastecimiento() throws Exception;

	/**
	 * Save an new BombaAbastecimiento entity
	 */
	public void saveBombaAbastecimiento(BombaAbastecimiento entity) throws Exception;

	/**
	 * Delete an existing BombaAbastecimiento entity
	 *
	 */
	public void deleteBombaAbastecimiento(BombaAbastecimiento entity) throws Exception;

	/**
	 * Update an existing BombaAbastecimiento entity
	 *
	 */
	public void updateBombaAbastecimiento(BombaAbastecimiento entity) throws Exception;

	/**
	 * Load an existing BombaAbastecimiento entity
	 *
	 */
	public BombaAbastecimiento getBombaAbastecimiento(Long bombaAbastecimientoId) throws Exception;

	public List<BombaAbastecimiento> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<BombaAbastecimiento> findPageBombaAbastecimiento(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberBombaAbastecimiento() throws Exception;

	public List<BombaAbastecimientoDTO> getDataBombaAbastecimiento() throws Exception;
}
