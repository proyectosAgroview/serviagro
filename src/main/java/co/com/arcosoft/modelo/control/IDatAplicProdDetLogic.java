package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatAplicProdDet;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatAplicProdDetLogic {
	public List<DatAplicProdDet> getDatAplicProdDet() throws Exception;

	/**
	 * Save an new DatAplicProdDet entity
	 */
	public void saveDatAplicProdDet(DatAplicProdDet entity) throws Exception;

	/**
	 * Delete an existing DatAplicProdDet entity
	 *
	 */
	public void deleteDatAplicProdDet(DatAplicProdDet entity) throws Exception;

	/**
	 * Update an existing DatAplicProdDet entity
	 *
	 */
	public void updateDatAplicProdDet(DatAplicProdDet entity) throws Exception;

	/**
	 * Load an existing DatAplicProdDet entity
	 *
	 */
	public DatAplicProdDet getDatAplicProdDet(Long datProdDetId) throws Exception;

	public List<DatAplicProdDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatAplicProdDet> findPageDatAplicProdDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatAplicProdDet() throws Exception;

	public List<DatAplicProdDetDTO> getDataDatAplicProdDet() throws Exception;

	public List<DatAplicProdDetDTO> getDataDetProductosByDatAplicProdId(Long datAplicProdId) throws Exception;
	public List<DatAplicProdDetDTO> getDataDetProductosByPlanillaNomina(Long planillaNominaId) throws Exception;

}
