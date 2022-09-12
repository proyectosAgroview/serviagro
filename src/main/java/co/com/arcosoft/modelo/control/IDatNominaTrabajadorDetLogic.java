package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatNominaTrabajadorDet;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatNominaTrabajadorDetLogic {
	public List<DatNominaTrabajadorDet> getDatNominaTrabajadorDet() throws Exception;

	/**
	 * Save an new DatNominaTrabajadorDet entity
	 */
	public void saveDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception;

	/**
	 * Delete an existing DatNominaTrabajadorDet entity
	 *
	 */
	public void deleteDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception;

	/**
	 * Update an existing DatNominaTrabajadorDet entity
	 *
	 */
	public void updateDatNominaTrabajadorDet(DatNominaTrabajadorDet entity) throws Exception;

	/**
	 * Load an existing DatNominaTrabajadorDet entity
	 *
	 */
	public DatNominaTrabajadorDet getDatNominaTrabajadorDet(Long datNominaTrabajadorDetId) throws Exception;

	public List<DatNominaTrabajadorDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatNominaTrabajadorDet> findPageDatNominaTrabajadorDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatNominaTrabajadorDet() throws Exception;

	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDet() throws Exception;

	public List<DatNominaTrabajadorDetDTO> getDataDatNominaTrabajadorDetByNomina(Long idNomina) throws Exception;
}
