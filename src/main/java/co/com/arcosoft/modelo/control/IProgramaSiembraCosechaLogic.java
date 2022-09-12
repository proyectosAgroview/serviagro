package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.ProgramaSiembraCosecha;
import co.com.arcosoft.modelo.dto.ProgramaSiembraCosechaDTO;
import co.com.arcosoft.modelo.dto.ProgramaSiembraCosechaDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IProgramaSiembraCosechaLogic {
	public List<ProgramaSiembraCosecha> getProgramaSiembraCosecha() throws Exception;

	/**
	 * Save an new ProgramaSiembraCosecha entity
	 */
	public void saveProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception;

	/**
	 * Delete an existing ProgramaSiembraCosecha entity
	 *
	 */
	public void deleteProgramaSiembraCosecha(ProgramaSiembraCosecha entity) throws Exception;

	/**
	 * Update an existing ProgramaSiembraCosecha entity
	 *
	 */
	public void updateProgramaSiembraCosecha(ProgramaSiembraCosecha entity,
			List<ProgramaSiembraCosechaDetDTO> dataProgramaDet) throws Exception;

	/**
	 * Load an existing ProgramaSiembraCosecha entity
	 *
	 */
	public ProgramaSiembraCosecha getProgramaSiembraCosecha(Long programaSiembraCosechaId) throws Exception;

	public List<ProgramaSiembraCosecha> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ProgramaSiembraCosecha> findPageProgramaSiembraCosecha(String sortColumnName, boolean sortAscending,
			int startRow, int maxResults) throws Exception;

	public Long findTotalNumberProgramaSiembraCosecha() throws Exception;

	public List<ProgramaSiembraCosechaDTO> getDataProgramaSiembraCosecha() throws Exception;
}
