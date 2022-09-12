package co.com.arcosoft.modelo;
// Generated 16/08/2019 09:52:36 AM by Hibernate Tools 4.0.0



/**
 * DatCheckListEquipoLabor generated by hbm2java
 */
public class DatCheckListEquipoLabor  implements java.io.Serializable {


     private Long datCheckListEquipoLaborId;
     private DatCheckListEquipoDet datCheckListEquipoDet;
     private Labor labor;
     private String resultado;
     private String observacion;

    public DatCheckListEquipoLabor() {
    }

    public DatCheckListEquipoLabor(DatCheckListEquipoDet datCheckListEquipoDet, Labor labor, String resultado, String observacion) {
       this.datCheckListEquipoDet = datCheckListEquipoDet;
       this.labor = labor;
       this.resultado = resultado;
       this.observacion = observacion;
    }
   
    public Long getDatCheckListEquipoLaborId() {
        return this.datCheckListEquipoLaborId;
    }
    
    public void setDatCheckListEquipoLaborId(Long datCheckListEquipoLaborId) {
        this.datCheckListEquipoLaborId = datCheckListEquipoLaborId;
    }
    public DatCheckListEquipoDet getDatCheckListEquipoDet() {
        return this.datCheckListEquipoDet;
    }
    
    public void setDatCheckListEquipoDet(DatCheckListEquipoDet datCheckListEquipoDet) {
        this.datCheckListEquipoDet = datCheckListEquipoDet;
    }
    public Labor getLabor() {
        return this.labor;
    }
    
    public void setLabor(Labor labor) {
        this.labor = labor;
    }
    public String getResultado() {
        return this.resultado;
    }
    
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }




}


