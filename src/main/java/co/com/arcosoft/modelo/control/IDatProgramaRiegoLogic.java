package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatProgramaRiego;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDTO;
import co.com.arcosoft.modelo.dto.DatProgramaRiegoDetDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *         www.zathuracode.org
 *
 */
public interface IDatProgramaRiegoLogic {
	public List<DatProgramaRiego> getDatProgramaRiego() throws Exception;

	/**
	 * Save an new DatProgramaRiego entity
	 */
	public void saveDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception;

	/**
	 * Delete an existing DatProgramaRiego entity
	 *
	 */
	public void deleteDatProgramaRiego(DatProgramaRiego entity) throws Exception;

	/**
	 * Update an existing DatProgramaRiego entity
	 *
	 */
	public void updateDatProgramaRiego(DatProgramaRiego entity, List<DatProgramaRiegoDetDTO> dataProgramaRiegoDet)
			throws Exception;

	/**
	 * Load an existing DatProgramaRiego entity
	 *
	 */
	public DatProgramaRiego getDatProgramaRiego(Long datProgramaRiegoId) throws Exception;

	public List<DatProgramaRiego> findByCriteria(Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DatProgramaRiego> findPageDatProgramaRiego(String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDatProgramaRiego() throws Exception;

	public List<DatProgramaRiegoDTO> getDataDatProgramaRiego() throws Exception;
}
