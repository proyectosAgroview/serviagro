package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatAnaLaboratorioDet;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatAnaLaboratorioDetLogic {
    public List<DatAnaLaboratorioDet> getDatAnaLaboratorioDet()
        throws Exception;

    /**
         * Save an new DatAnaLaboratorioDet entity
         */
    public void saveDatAnaLaboratorioDet(DatAnaLaboratorioDet entity)
        throws Exception;

    /**
         * Delete an existing DatAnaLaboratorioDet entity
         *
         */
    public void deleteDatAnaLaboratorioDet(DatAnaLaboratorioDet entity)
        throws Exception;

    /**
        * Update an existing DatAnaLaboratorioDet entity
        *
        */
    public void updateDatAnaLaboratorioDet(DatAnaLaboratorioDet entity)
        throws Exception;

    /**
         * Load an existing DatAnaLaboratorioDet entity
         *
         */
    public DatAnaLaboratorioDet getDatAnaLaboratorioDet(
        Long datAnaLaboratorioDetId) throws Exception;

    public List<DatAnaLaboratorioDet> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatAnaLaboratorioDet> findPageDatAnaLaboratorioDet(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatAnaLaboratorioDet() throws Exception;

    public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDet()
        throws Exception;
    
    public List<DatAnaLaboratorioDetDTO> getDataDatAnaLaboratorioDetByAnalisis(Long idDatAnaLaboratorio)
            throws Exception ;
}
