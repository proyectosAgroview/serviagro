package co.com.arcosoft.rest.service.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2Clientesmq;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.PrecioPromProd;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.control.IAlmacenLogic;
import co.com.arcosoft.modelo.control.IConceptoKardexLogic;
import co.com.arcosoft.modelo.control.IDatPlanLaborDetLogic;
import co.com.arcosoft.modelo.control.IEquipoLogic;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.modelo.control.INivel2ClientesmqLogic;
import co.com.arcosoft.modelo.control.IPersEmprLogic;
import co.com.arcosoft.modelo.control.IProductoLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.SalidaCombustibleDTO;

@Controller
@RequestMapping("/transacciones")
public class WsSalidaCombustible {

	private static final Logger logger = LoggerFactory.getLogger(WsSalidaCombustible.class);

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	private PrecioPromProd entity = null;
	List<PrecioPromProdDTO> precioPromProdDTO = null;

	@Autowired
	IDatPlanLaborDetLogic planLaborLogic;

	@Autowired
	ILaborLogic laborlogic;

	@Autowired
	ITrabajadorLogic trabajadorLogic;

	@Autowired
	IProductoLogic productoLogic;

	@Autowired
	IConceptoKardexLogic conceptoKardexLogic;

	@Autowired
	INivel2ClientesmqLogic nivel2ClientesmqLogic;

	@Autowired
	IPersEmprLogic persEmprLogic;

	@Autowired
	IEquipoLogic equipoLogic;

	@Autowired
	IAlmacenLogic almacenLogic;

	boolean existeOT = false;

	@RequestMapping(value = "/guardarSalidaCombustible", method = RequestMethod.POST)
	public ResponseEntity<String> guardarSalidaCombustible(@RequestBody SalidaCombustibleDTO salidaCombustible)
			throws Exception {

		Labor labor = null;
		Nivel2Clientesmq nivNivel2Clientesmqel2 = null;
		PersEmpr persEmpr = null;
		Producto producto = null;
		ConceptoKardex conceptoKardex = null;
		PrecioPromProd precioPromProd = null;
		Compania compania = null;
		Equipo equipo = null;

		PrecioPromProdDTO detDto = null;
		UdadMed unidadpago = null;
		Trabajador bombero = null;
		Date fechaFinalDateRegistro = null;
		Long consecutivo = null;
		ConceptoNomina conceptoNomina = null;
		Almacen almacen = null;
		Trabajador operarioMaquina = null;

		if (salidaCombustible != null) {

			entity = new PrecioPromProd();
			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = salidaCombustible.getFechaInicial();// foriginal.parse(salidaCombustible.getFechaInicial());
			// String fsalida = sdf.format(fechaOriginal);
			// fechaFinalDateRegistro = sdf.parse(fsalida)

			Long companiaId = salidaCombustible.getCompania();
			compania = businessDelegatorView.getCompania(companiaId);
						
			
			

			if (salidaCombustible.getObservacion() != null) {
				entity.setInfoAdicional(salidaCombustible.getObservacion());
			}

			Double cantidadAbastecimiento = salidaCombustible.getCantidadCompra();
		

			Long idMaquina = salidaCombustible.getEquipoId().longValue();
			equipo = businessDelegatorView.getEquipo(idMaquina);
			
			Long categoriaId =equipo.getCategoriaEquipo().getCategEquipId();
			
			Long conceptoKardexSalida =null;
			CategoriaEquipo categoria = businessDelegatorView.getCategoriaEquipo(categoriaId);
			
			if(categoria.getConceptoKardexId()!=null) {
				conceptoKardexSalida= categoria.getConceptoKardexId().getConceptoKardexId();
				conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexSalida);
			}else {
				conceptoKardexSalida= 8L;//compania.getKardexSalidaEstandar();
				conceptoKardex = businessDelegator2View.getConceptoKardex(conceptoKardexSalida);
			}
			entity.setConceptoKardexId(conceptoKardex);
			
			
			
			Long productoAsociado = equipo.getProductoId();

			producto = businessDelegatorView.getProducto(productoAsociado);
			Long udadMedId = producto.getUdadMedByUdadMedProd().getUdadMedId();

			unidadpago = businessDelegatorView.getUdadMed(udadMedId);

			entity.setFechaInicial(fechaOriginal);
			entity.setProducto(producto);
			entity.setUnidadMedida(unidadpago);
			entity.setEquipoId(equipo);
			
			Double horometroAbastecimiento = salidaCombustible.getHorometroAbastecimiento();
			entity.setHorometro_abastecimiento(horometroAbastecimiento);

			Long indicador_vuelta_medidor=0L;
			if(equipo.getIndicador_vuelta_medidor()!=null) {
				indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
			}
			entity.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
			Long idAlmacen = salidaCombustible.getAlmacenId();
			almacen = businessDelegatorView.getAlmacen(idAlmacen);
			entity.setAlmacenId(almacen);

			Double costoUnitCombustible = businessDelegatorView.consultarPrecioPromProducto(productoAsociado, 1l,
					companiaId, fechaOriginal);
			Double costoCombustible = 0.0;
			if (costoUnitCombustible != null) {
				costoCombustible = costoUnitCombustible.doubleValue() * cantidadAbastecimiento;
			}
			entity.setCantidadCompra(cantidadAbastecimiento);
			entity.setValorUnitario(costoUnitCombustible);
			entity.setCostoTotal(costoCombustible);
			entity.setCompania(companiaId);
			entity.setFechaCreacion(date);

			Long idEmpresa = salidaCombustible.getPersEmprId_PersEmpr();
			persEmpr = businessDelegatorView.getPersEmpr(idEmpresa);
			entity.setPersEmpr(persEmpr);

			Long idHacienda = salidaCombustible.getNivel2_clientesmq_id();
			nivNivel2Clientesmqel2 = businessDelegator2View.getNivel2Clientesmq(idHacienda);
			entity.setNivel2_clientesmq_id(nivNivel2Clientesmqel2);

			entity.setUsuarioDigitacion(salidaCombustible.getUsuarioDigitacion());
			if (salidaCombustible.getUsuarioDigitacion() != null) {

				
				Object[] condicionBombero = { "usuario_asociado", true, salidaCombustible.getUsuarioDigitacion(), "=" };
				List<Trabajador> listaBombero = (salidaCombustible.getUsuarioDigitacion() != null)
						? businessDelegatorView.findByCriteriaInTrabajador(condicionBombero, null, null)
						: null;
				if (listaBombero != null && listaBombero.size() > 0) {
					bombero = listaBombero.get(0);
				}
			}

			// Long idBombero = salidaCombustible.getTrabajador();
			// bombero = businessDelegatorView.getTrabajador(idBombero);
			entity.setTrabajador(bombero);

			Long idOperarioMaquina = salidaCombustible.getOperario_equipo_id();
			 operarioMaquina = businessDelegatorView.getTrabajador(idOperarioMaquina);
			entity.setOperario_equipo_id(operarioMaquina);
			
			Long idLabor = salidaCombustible.getConceptoGastoId();
			
			entity.setConceptoGastoId(idLabor);
			entity.setTipoMovimiento("PROC");
			entity.setDiferido("NO");
			
			
				if(equipo.getCentCost()!=null) {
					entity.setCentCostId(equipo.getCentCost());	
				}
			

			businessDelegatorView.savePrecioPromProd(entity);

			entity = null;
			fechaFinalDateRegistro = null;
			existeOT = false;
			labor = null;
			nivNivel2Clientesmqel2 = null;
			persEmpr = null;
			producto = null;
			conceptoKardex = null;
			precioPromProd = null;
			compania = null;
			equipo = null;

			detDto = null;
			unidadpago = null;
			bombero = null;
			fechaFinalDateRegistro = null;
			consecutivo = null;
			conceptoNomina = null;
			almacen = null;
			operarioMaquina = null;

			return new ResponseEntity<String>("La sálida de combustible  fue creado en AgroView ", HttpStatus.CREATED);

		} else {

			return new ResponseEntity<String>("El objeto Sálida de combustible enviado desde AgroViewMobile es nulo",
					HttpStatus.BAD_REQUEST);
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
