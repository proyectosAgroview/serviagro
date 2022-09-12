package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ProgramaSiembraCosechaDet;
import co.com.arcosoft.modelo.dto.ProgramaSiembraCosechaDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IProgramaSiembraCosechaDetLogic {
	public List<ProgramaSiembraCosechaDet> getProgramaSiembraCosechaDet() throws Exception;

	/**
	 * Save an new ProgramaSiembraCosechaDet entity
	 */
	public void saveProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception;

	/**
	 * Delete an existing ProgramaSiembraCosechaDet entity
	 *
	 */
	public void deleteProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception;

	/**
	 * Update an existing ProgramaSiembraCosechaDet entity
	 *
	 */
	public void updateProgramaSiembraCosechaDet(ProgramaSiembraCosechaDet entity) throws Exception;

	/**
	 * Load an existing ProgramaSiembraCosechaDet entity
	 *
	 */
	public ProgramaSiembraCosechaDet getProgramaSiembraCosechaDet(Long programaSiembraCosechaDetId) throws Exception;

	public List<ProgramaSiembraCosechaDet> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ProgramaSiembraCosechaDet> findPageProgramaSiembraCosechaDet(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults) throws Exception;

	public Long findTotalNumberProgramaSiembraCosechaDet() throws Exception;

	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDet() throws Exception;

	public List<ProgramaSiembraCosechaDetDTO> getDataProgramaSiembraCosechaDetByPrograma(Long programaDetId)
			throws Exception;

}
