package co.com.arcosoft.modelo;
// Generated 23-jul-2017 14:00:29 by Hibernate Tools 4.0.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PlanRevisionEquipo generated by hbm2java
 */
public class PlanRevisionEquipo  implements java.io.Serializable {


     private Long planRevisionEquipoId;
     private String codigo;
     private String nombre;
     private String observacion;
     private Long compania;
     private Date fechaCreacion;
     private Date fechaModificacion;
     private String estado;
     private String tipoProcedimiento;
     private String tipoPlan;
     private Set<DatMantenimientoEquipo> datMantenimientoEquipos = new HashSet<DatMantenimientoEquipo>(0);
     private Set<PlanRevisionEquipoActiv> planRevisionEquipoActivs = new HashSet<PlanRevisionEquipoActiv>(0);
     private Set<PlanRevisionEquipoDet> planRevisionEquipoDets = new HashSet<PlanRevisionEquipoDet>(0);
     private String origenDatos;
     private Medidor medidorId;
    public PlanRevisionEquipo() {
    }

    public PlanRevisionEquipo(String codigo, String nombre, String observacion, Long compania, Date fechaCreacion, 
    		Date fechaModificacion, String estado, String tipoProcedimiento, String tipoPlan, 
    		Set<DatMantenimientoEquipo> datMantenimientoEquipos, Set<PlanRevisionEquipoActiv> planRevisionEquipoActivs, 
    		Set<PlanRevisionEquipoDet> planRevisionEquipoDets, String origenDatos, Medidor medidorId) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.observacion = observacion;
       this.compania = compania;
       this.fechaCreacion = fechaCreacion;
       this.fechaModificacion = fechaModificacion;
       this.estado = estado;
       this.tipoProcedimiento = tipoProcedimiento;
       this.tipoPlan = tipoPlan;
       this.datMantenimientoEquipos = datMantenimientoEquipos;
       this.planRevisionEquipoActivs = planRevisionEquipoActivs;
       this.planRevisionEquipoDets = planRevisionEquipoDets;
       this.origenDatos=origenDatos;
       this.medidorId=medidorId;
      }
    
    
     
      public Medidor getMedidorId() {
		return medidorId;
	}

	public void setMedidorId(Medidor medidorId) {
		this.medidorId = medidorId;
	}

	public String getOrigenDatos() {
  		return origenDatos;
  	}

  	public void setOrigenDatos(String origenDatos) {
  		this.origenDatos = origenDatos;
  	}

    public Long getPlanRevisionEquipoId() {
        return this.planRevisionEquipoId;
    }
    
    public void setPlanRevisionEquipoId(Long planRevisionEquipoId) {
        this.planRevisionEquipoId = planRevisionEquipoId;
    }
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Long getCompania() {
        return this.compania;
    }
    
    public void setCompania(Long compania) {
        this.compania = compania;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Date getFechaModificacion() {
        return this.fechaModificacion;
    }
    
    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getTipoProcedimiento() {
        return this.tipoProcedimiento;
    }
    
    public void setTipoProcedimiento(String tipoProcedimiento) {
        this.tipoProcedimiento = tipoProcedimiento;
    }
    public String getTipoPlan() {
        return this.tipoPlan;
    }
    
    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
    public Set<DatMantenimientoEquipo> getDatMantenimientoEquipos() {
        return this.datMantenimientoEquipos;
    }
    
    public void setDatMantenimientoEquipos(Set<DatMantenimientoEquipo> datMantenimientoEquipos) {
        this.datMantenimientoEquipos = datMantenimientoEquipos;
    }
    public Set<PlanRevisionEquipoActiv> getPlanRevisionEquipoActivs() {
        return this.planRevisionEquipoActivs;
    }
    
    public void setPlanRevisionEquipoActivs(Set<PlanRevisionEquipoActiv> planRevisionEquipoActivs) {
        this.planRevisionEquipoActivs = planRevisionEquipoActivs;
    }
    public Set<PlanRevisionEquipoDet> getPlanRevisionEquipoDets() {
        return this.planRevisionEquipoDets;
    }
    
    public void setPlanRevisionEquipoDets(Set<PlanRevisionEquipoDet> planRevisionEquipoDets) {
        this.planRevisionEquipoDets = planRevisionEquipoDets;
    }




}

