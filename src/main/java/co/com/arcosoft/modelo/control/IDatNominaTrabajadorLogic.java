package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatNominaTrabajador;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDTO;
import co.com.arcosoft.modelo.dto.DatNominaTrabajadorDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatNominaTrabajadorLogic {
	public List<DatNominaTrabajador> getDatNominaTrabajador() throws Exception;

	/**
	 * Save an new DatNominaTrabajador entity
	 */
	public void saveDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception;

	/**
	 * Delete an existing DatNominaTrabajador entity
	 *
	 */
	public void deleteDatNominaTrabajador(DatNominaTrabajador entity) throws Exception;

	/**
	 * Update an existing DatNominaTrabajador entity
	 *
	 */
	public void updateDatNominaTrabajador(DatNominaTrabajador entity,
			List<DatNominaTrabajadorDetDTO> dataNominaTrabajador) throws Exception;

	/**
	 * Load an existing DatNominaTrabajador entity
	 *
	 */
	public DatNominaTrabajador getDatNominaTrabajador(Long datNominaTrabajadorId) throws Exception;

	public List<DatNominaTrabajador> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatNominaTrabajador> findPageDatNominaTrabajador(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatNominaTrabajador() throws Exception;

	public List<DatNominaTrabajadorDTO> getDataDatNominaTrabajador() throws Exception;
}
