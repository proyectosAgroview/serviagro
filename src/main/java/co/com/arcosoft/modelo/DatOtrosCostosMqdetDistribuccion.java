package co.com.arcosoft.modelo;
// Generated 2/04/2019 05:01:54 PM by Hibernate Tools 4.0.0



/**
 * DatOtrosCostosMqdetDistribuccion generated by hbm2java
 */
public class DatOtrosCostosMqdetDistribuccion  implements java.io.Serializable {


     private Long datOtrosCostosMqdetDistrId;
     private Equipo equipo;
     private DatOtrosCostosMq datOtrosCostosMq;

    public DatOtrosCostosMqdetDistribuccion() {
    }

    public DatOtrosCostosMqdetDistribuccion(Equipo equipo, DatOtrosCostosMq datOtrosCostosMq) {
       this.equipo = equipo;
       this.datOtrosCostosMq = datOtrosCostosMq;
    }
   
    public Long getDatOtrosCostosMqdetDistrId() {
        return this.datOtrosCostosMqdetDistrId;
    }
    
    public void setDatOtrosCostosMqdetDistrId(Long datOtrosCostosMqdetDistrId) {
        this.datOtrosCostosMqdetDistrId = datOtrosCostosMqdetDistrId;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public DatOtrosCostosMq getDatOtrosCostosMq() {
        return this.datOtrosCostosMq;
    }
    
    public void setDatOtrosCostosMq(DatOtrosCostosMq datOtrosCostosMq) {
        this.datOtrosCostosMq = datOtrosCostosMq;
    }




}


