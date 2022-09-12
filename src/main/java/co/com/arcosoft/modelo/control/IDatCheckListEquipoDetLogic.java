package co.com.arcosoft.modelo.control;

import co.com.arcosoft.modelo.DatCheckListEquipoDet;
import co.com.arcosoft.modelo.dto.DatCheckListEquipoDetDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatCheckListEquipoDetLogic {
    public List<DatCheckListEquipoDet> getDatCheckListEquipoDet()
        throws Exception;

    /**
         * Save an new DatCheckListEquipoDet entity
         */
    public void saveDatCheckListEquipoDet(DatCheckListEquipoDet entity)
        throws Exception;

    /**
         * Delete an existing DatCheckListEquipoDet entity
         *
         */
    public void deleteDatCheckListEquipoDet(DatCheckListEquipoDet entity)
        throws Exception;

    /**
        * Update an existing DatCheckListEquipoDet entity
        *
        */
    public void updateDatCheckListEquipoDet(DatCheckListEquipoDet entity)
        throws Exception;

    /**
         * Load an existing DatCheckListEquipoDet entity
         *
         */
    public DatCheckListEquipoDet getDatCheckListEquipoDet(
        Long datCheckListEquipoDetId) throws Exception;

    public List<DatCheckListEquipoDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatCheckListEquipoDet> findPageDatCheckListEquipoDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatCheckListEquipoDet()
        throws Exception;

    public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDet()
        throws Exception;

    public List<DatCheckListEquipoDetDTO> getDataDatCheckListEquipoDetByCheckList(Long datCheckListEquipoId)
        throws Exception;
}
