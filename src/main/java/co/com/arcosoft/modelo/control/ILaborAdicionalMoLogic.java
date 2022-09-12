package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.LaborAdicionalMo;
import co.com.arcosoft.modelo.dto.LaborAdicionalMoDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface ILaborAdicionalMoLogic {
    public List<LaborAdicionalMo> getLaborAdicionalMo()
        throws Exception;

    /**
         * Save an new LaborAdicionalMo entity
         */
    public void saveLaborAdicionalMo(LaborAdicionalMo entity)
        throws Exception;

    /**
         * Delete an existing LaborAdicionalMo entity
         *
         */
    public void deleteLaborAdicionalMo(LaborAdicionalMo entity)
        throws Exception;

    /**
        * Update an existing LaborAdicionalMo entity
        *
        */
    public void updateLaborAdicionalMo(LaborAdicionalMo entity)
        throws Exception;

    /**
         * Load an existing LaborAdicionalMo entity
         *
         */
    public LaborAdicionalMo getLaborAdicionalMo(Long laborAdicionalMoId)
        throws Exception;

    public List<LaborAdicionalMo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<LaborAdicionalMo> findPageLaborAdicionalMo(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberLaborAdicionalMo() throws Exception;

    public List<LaborAdicionalMoDTO> getDataLaborAdicionalMo()
        throws Exception;
}
