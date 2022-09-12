package co.com.arcosoft.modelo.control;

import java.util.List;

import co.com.arcosoft.modelo.DatDiferidosAgricola;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosAgricolaDetDTO;
import co.com.arcosoft.modelo.dto.DatDiferidosCuotasAgricolasDTO;
import co.com.arcosoft.modelo.informes.dto.ListaNivel4DTO;


/**
* @author Zathura Code Generator http://code.google.com/p/zathura
* www.zathuracode.org
*
*/
public interface IDatDiferidosAgricolaLogic {
    public List<DatDiferidosAgricola> getDatDiferidosAgricola()
        throws Exception;

    /**
         * Save an new DatDiferidosAgricola entity
         */
    public void saveDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
    		List<DatDiferidosCuotasAgricolasDTO> dataCuotas)
        throws Exception;

    /**
         * Delete an existing DatDiferidosAgricola entity
         *
         */
    public void deleteDatDiferidosAgricola(DatDiferidosAgricola entity)
        throws Exception;

    /**
        * Update an existing DatDiferidosAgricola entity
        *
        */
    public void updateDatDiferidosAgricola(DatDiferidosAgricola entity, List<DatDiferidosAgricolaDetDTO> dataDet,
    		List<DatDiferidosCuotasAgricolasDTO> dataCuotas)
        throws Exception;

    /**
         * Load an existing DatDiferidosAgricola entity
         *
         */
    public DatDiferidosAgricola getDatDiferidosAgricola(
        Long datDiferidosAgricolaId) throws Exception;

    public List<DatDiferidosAgricola> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<DatDiferidosAgricola> findPageDatDiferidosAgricola(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberDatDiferidosAgricola() throws Exception;

    public List<DatDiferidosAgricolaDTO> getDataDatDiferidosAgricola()
        throws Exception;
    
    public void saveDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
    		List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception;

	public void updateDatDiferidosAgricolaVer2(DatDiferidosAgricola entity, List<ListaNivel4DTO> dataNivel4,
			List<DatDiferidosCuotasAgricolasDTO> dataCuotas) throws Exception;
}
