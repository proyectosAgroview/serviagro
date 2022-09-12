package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatServRealizadosEquipoDet;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatServRealizadosEquipoDetLogic {
    public List<DatServRealizadosEquipoDet> getDatServRealizadosEquipoDet()
        throws Exception;

    /**
         * Save an new DatServRealizadosEquipoDet entity
         */
    public void saveDatServRealizadosEquipoDet(
        DatServRealizadosEquipoDet entity) throws Exception;

    /**
         * Delete an existing DatServRealizadosEquipoDet entity
         *
         */
    public void deleteDatServRealizadosEquipoDet(
        DatServRealizadosEquipoDet entity) throws Exception;

    /**
        * Update an existing DatServRealizadosEquipoDet entity
        *
        */
    public void updateDatServRealizadosEquipoDet(
        DatServRealizadosEquipoDet entity) throws Exception;

    /**
         * Load an existing DatServRealizadosEquipoDet entity
         *
         */
    public DatServRealizadosEquipoDet getDatServRealizadosEquipoDet(
        Long datServRealizadosEquipoDetId) throws Exception;

    public List<DatServRealizadosEquipoDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatServRealizadosEquipoDet> findPageDatServRealizadosEquipoDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatServRealizadosEquipoDet()
        throws Exception;

    public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDet()
        throws Exception;

	public List<DatServRealizadosEquipoDetDTO> getDataDatServRealizadosEquipoDetByServ(Long datServId) throws Exception;
    
}
