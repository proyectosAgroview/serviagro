package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatServicioDet;
import co.com.arcosoft.modelo.dto.DatServicioDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatServicioDetLogic {
	public List<DatServicioDet> getDatServicioDet() throws Exception;

	/**
	 * Save an new DatServicioDet entity
	 */
	public void saveDatServicioDet(DatServicioDet entity) throws Exception;

	/**
	 * Delete an existing DatServicioDet entity
	 *
	 */
	public void deleteDatServicioDet(DatServicioDet entity) throws Exception;

	/**
	 * Update an existing DatServicioDet entity
	 *
	 */
	public void updateDatServicioDet(DatServicioDet entity) throws Exception;

	/**
	 * Load an existing DatServicioDet entity
	 *
	 */
	public DatServicioDet getDatServicioDet(Long datServicioDetId) throws Exception;

	public List<DatServicioDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatServicioDet> findPageDatServicioDet(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatServicioDet() throws Exception;

	public List<DatServicioDetDTO> getDataDatServicioDet() throws Exception;

	public List<DatServicioDetDTO> getDataDatServicioDetByServicio(Long datServicioId) throws Exception;
	public List<DatServicioDetDTO> getDataDatServicioDetByPlanillaNomina(Long planillaNominaId) throws Exception;

}
