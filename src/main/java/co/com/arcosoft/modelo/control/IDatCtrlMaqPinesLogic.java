package co.com.arcosoft.modelo.control;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.dto.DatCtrlMaqPinesDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatCtrlMaqPinesLogic {
    public List<DatCtrlMaqPines> getDatCtrlMaqPines() throws Exception;

    /**
         * Save an new DatCtrlMaqPines entity
         */
    public void saveDatCtrlMaqPines(DatCtrlMaqPines entity)
        throws Exception;

    /**
         * Delete an existing DatCtrlMaqPines entity
         *
         */
    public void deleteDatCtrlMaqPines(DatCtrlMaqPines entity)
        throws Exception;

    /**
        * Update an existing DatCtrlMaqPines entity
        *
        */
    public void updateDatCtrlMaqPines(DatCtrlMaqPines entity)
        throws Exception;

    /**
         * Load an existing DatCtrlMaqPines entity
         *
         */
    public DatCtrlMaqPines getDatCtrlMaqPines(Long datCtrlMaqPinesId)
        throws Exception;

    public List<DatCtrlMaqPines> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCtrlMaqPines> findPageDatCtrlMaqPines(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatCtrlMaqPines() throws Exception;

    public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPines()
        throws Exception;
    

    public List<DatCtrlMaqPinesDTO> getDataDatCtrlMaqPinesFiltroEquipo(Long equipoId) throws Exception;
  
}
