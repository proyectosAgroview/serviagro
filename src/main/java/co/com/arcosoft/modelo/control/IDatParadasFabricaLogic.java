package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatParadasFabrica;
import co.com.arcosoft.modelo.dto.DatParadasFabricaDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatParadasFabricaLogic {
    public List<DatParadasFabrica> getDatParadasFabrica()
        throws Exception;

    /**
         * Save an new DatParadasFabrica entity
         */
    public void saveDatParadasFabrica(DatParadasFabrica entity)
        throws Exception;

    /**
         * Delete an existing DatParadasFabrica entity
         *
         */
    public void deleteDatParadasFabrica(DatParadasFabrica entity)
        throws Exception;

    /**
        * Update an existing DatParadasFabrica entity
        *
        */
    public void updateDatParadasFabrica(DatParadasFabrica entity)
        throws Exception;

    /**
         * Load an existing DatParadasFabrica entity
         *
         */
    public DatParadasFabrica getDatParadasFabrica(Long datParadasFabricaId)
        throws Exception;

    public List<DatParadasFabrica> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatParadasFabrica> findPageDatParadasFabrica(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatParadasFabrica() throws Exception;

    public List<DatParadasFabricaDTO> getDataDatParadasFabrica()
        throws Exception;
}
