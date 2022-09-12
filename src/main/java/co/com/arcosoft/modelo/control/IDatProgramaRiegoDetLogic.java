package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatProgramaRiegoDet;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatProgramaRiegoDetLogic {
	public List<DatProgramaRiegoDet> getDatProgramaRiegoDet() throws Exception;

	/**
	 * Save an new DatProgramaRiegoDet entity
	 */
	public void saveDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception;

	/**
	 * Delete an existing DatProgramaRiegoDet entity
	 *
	 */
	public void deleteDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception;

	/**
	 * Update an existing DatProgramaRiegoDet entity
	 *
	 */
	public void updateDatProgramaRiegoDet(DatProgramaRiegoDet entity) throws Exception;

	/**
	 * Load an existing DatProgramaRiegoDet entity
	 *
	 */
	public DatProgramaRiegoDet getDatProgramaRiegoDet(Long datProgramaRiegoDetId) throws Exception;

	public List<DatProgramaRiegoDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatProgramaRiegoDet> findPageDatProgramaRiegoDet(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberDatProgramaRiegoDet() throws Exception;

	public List<DatProgramaRiegoDetDTO> getDataDatProgramaRiegoDet() throws Exception;

	public List<DatProgramaRiegoDetDTO> getDataDatProgramaRiegoDetByPrograma(Long programRiegoDet) throws Exception;
}
