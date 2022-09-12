package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedProperty;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.control.IEquipoLogic;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.ImplementoDTO;
import co.com.arcosoft.rest.service.dto.MaquinariaDTO;
import co.com.arcosoft.rest.service.dto.OrdenDeTrabajoDTO;

@Controller
@RequestMapping("/catalogos")
public class WsMaquinaria {

	private static final Logger logger = LoggerFactory.getLogger(WsMaquinaria.class);

	@Autowired
	IEquipoLogic equipologic;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
	@Resource
	private SessionFactory sessionFactory;

	@RequestMapping(value = "/listarMaquinaria", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<MaquinariaDTO>> listarEquipo() throws Exception {

		List<Equipo> a = new ArrayList<Equipo>();
		List<MaquinariaDTO> ma = new ArrayList<MaquinariaDTO>();
		DatCtrlMaqPines datCtrlMaqPines= null;
		a = equipologic.getEquipo();

		if (a != null && a.size() > 0) {

			for (Equipo mEquipo : a) {

				if (mEquipo.getCategoriaEquipo() != null) {

					Long categId = mEquipo.getCategoriaEquipo().getCategEquipId();
					CategoriaEquipo categ = businessDelegatorView.getCategoriaEquipo(categId);
					
					String funcion = categ.getFuncion();
					

					

					if (mEquipo.getEstado().equals("A")  
							&& !funcion.equals("Remolques/Vagones")  && !funcion.equals("Herramienta")  && !funcion.equals("Otros")  ) {
						

						if (mEquipo.getEquipoId() != null && ( funcion.equals("Tractor") 
																||  funcion.equals("Camion") || funcion.equals("Camioneta")
																||  funcion.equals("Automóvil") || funcion.equals("Tractomula")
																||  funcion.equals("Motobomba/Electrogeno")  
																)) {
							
							Long idEquipo = mEquipo.getEquipoId();
							Object[] condicionHor = { "equipo.equipoId", true, idEquipo, "=" };
							List<DatCtrlMaqPines> listaHor= (idEquipo != null)
									? businessDelegator2View.findByCriteriaInDatCtrlMaqPines(condicionHor, null, null)
									: null;
							if (listaHor != null && listaHor.size() > 0) {
								datCtrlMaqPines = listaHor.get(0);
							}
						}
						
						MaquinariaDTO tmp = new MaquinariaDTO();
						tmp.setEquipoId(mEquipo.getEquipoId());
						tmp.setCodigo(mEquipo.getCodigo());
						tmp.setNombre(mEquipo.getNombre());
						if(datCtrlMaqPines!=null){
							if(datCtrlMaqPines.getUltHoroOdoMetro() !=null) {
								tmp.setHorometroInicial(datCtrlMaqPines.getUltHoroOdoMetro().toString());
							}else {
								tmp.setHorometroInicial("0");
							}
						}else {
							tmp.setHorometroInicial("0");
						}
							
						Trabajador trab = new Trabajador();
						
						if(mEquipo.getTrabajador() !=null) {
	
							trab = businessDelegatorView.getTrabajador(mEquipo.getTrabajador().longValue());
							String trabId = trab.getTrabId().toString();
							String nombre = trab.getNombre();
							
							tmp.setTrabajadorId(trabId);
							tmp.setNombreTrabajador(nombre);
						}else {
							
							tmp.setTrabajadorId(".");
							tmp.setNombreTrabajador(".");
						}
						
						
						tmp.setCategEquipId_CategoriaEquipo(categId);
						
						if(categ.getRangoDifHorometro() !=null) {
							tmp.setRangoDifHorometro(categ.getRangoDifHorometro().toString());
						}else {
							tmp.setRangoDifHorometro("500");
						}
						
						if (( funcion.equals("Tractor") 
								||  funcion.equals("Camion") || funcion.equals("Camioneta")
								||  funcion.equals("Automóvil") || funcion.equals("Tractomula")
								
								) ) {
						
							Session session = sessionFactory.openSession();
	
							SQLQuery q = session.createSQLQuery("call pr_ult_horo_odometro_tanqueo (:compania,  :idMaq)");
							Double horTanqueo = 0.0;
							q.setLong("compania", mEquipo.getCompania());
							q.setLong("idMaq", mEquipo.getEquipoId());
	
							List l = q.list();
							StringBuilder result = new StringBuilder();
	
							if (l.size() > 0) {
	
								for (Iterator it = l.iterator(); it.hasNext();) {
	
									BigDecimal horasTanqueo = (BigDecimal) it.next();
									horTanqueo = horasTanqueo.doubleValue() ;
	
								}
								session.close();
							}
							tmp.setHorometroTanqueo(horTanqueo.toString());
						}else {
							tmp.setHorometroTanqueo("0");
						}
						
						ma.add(tmp);
					}

				}

			}

			return new ResponseEntity<List<MaquinariaDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<MaquinariaDTO>>(HttpStatus.NO_CONTENT);
		}

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}

	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}

	
}
