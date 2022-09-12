package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatAnaLaboratorio;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDTO;
import co.com.arcosoft.modelo.dto.DatAnaLaboratorioDetDTO;
import co.com.arcosoft.modelo.informes.dto.ListaVariablesAnaLaboratorioDTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatAnaLaboratorioLogic {
    public List<DatAnaLaboratorio> getDatAnaLaboratorio()
        throws Exception;

    /**
         * Save an new DatAnaLaboratorio entity
         */
    public void saveDatAnaLaboratorio(DatAnaLaboratorio entity, List<ListaVariablesAnaLaboratorioDTO> dataAnalisisLabDet)
        throws Exception;

    /**
         * Delete an existing DatAnaLaboratorio entity
         *
         */
    public void deleteDatAnaLaboratorio(DatAnaLaboratorio entity)
        throws Exception;

    /**
        * Update an existing DatAnaLaboratorio entity
        *
        */
    public void updateDatAnaLaboratorio(DatAnaLaboratorio entity, List<DatAnaLaboratorioDetDTO> dataAnalisisLabDet,List<ListaVariablesAnaLaboratorioDTO> dataVariables)
        throws Exception;

    /**
         * Load an existing DatAnaLaboratorio entity
         *
         */
    public DatAnaLaboratorio getDatAnaLaboratorio(Long datAnaLabId)
        throws Exception;

    public List<DatAnaLaboratorio> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatAnaLaboratorio> findPageDatAnaLaboratorio(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatAnaLaboratorio() throws Exception;

    public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorio()
        throws Exception;

    public List<DatAnaLaboratorioDTO> getDataDatAnaLaboratorioByTipoAnalisis(Long idAnalisis)
            throws Exception;

}
