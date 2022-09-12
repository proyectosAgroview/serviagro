package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Almacen;
import co.com.arcosoft.modelo.CategoriaEquipo;
import co.com.arcosoft.modelo.Compania;
import co.com.arcosoft.modelo.ConceptoKardex;
import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatCtrlMaqPines;
import co.com.arcosoft.modelo.DatOtrosMovInventario;
import co.com.arcosoft.modelo.DatServRealizadosEquipo;
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
import co.com.arcosoft.modelo.control.IDatOtrosMovInventarioLogic;
import co.com.arcosoft.modelo.control.IDatPlanLaborDetLogic;
import co.com.arcosoft.modelo.control.IEquipoLogic;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.modelo.control.INivel2ClientesmqLogic;
import co.com.arcosoft.modelo.control.IPersEmprLogic;
import co.com.arcosoft.modelo.control.IProductoLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.dto.DatServRealizadosEquipoDetDTO;
import co.com.arcosoft.modelo.dto.PrecioPromProdDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.SalidaCombustibleDTO;

@Controller
@RequestMapping("/transacciones")
public class WsSalidaProductosMtto {

	private static final Logger logger = LoggerFactory.getLogger(WsSalidaProductosMtto.class);

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;


	private DatOtrosMovInventario entity = null;
	private PrecioPromProd entityDet = null;
	List<PrecioPromProdDTO> precioPromProdDTO = null;
	List<PrecioPromProdDTO> dataDetPrecioProductos = null;
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
	
	@Autowired
	IDatOtrosMovInventarioLogic datOtrosMovInventarioLogic;


	@Resource
	private SessionFactory sessionFactory;
	
	boolean existeOT = false;

	@RequestMapping(value = "/guardarSalidaProductosMtto", method = RequestMethod.POST)
	public ResponseEntity<String> guardarSalidaProductosMtto(@RequestBody SalidaCombustibleDTO salidasProd)
			throws Exception {


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

		Almacen almacen = null;
		Trabajador operarioMaquina = null;
		DatOtrosMovInventario datOtrosMovInventario = null;
		
		if (salidasProd != null) {
			
			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = salidasProd.getFechaInicial();// foriginal.parse(salidasProd.getFechaInicial());
			// String fsalida = sdf.format(fechaOriginal);
			// fechaFinalDateRegistro = sdf.parse(fsalida)

			Long companiaId = salidasProd.getCompania();
			compania = businessDelegatorView.getCompania(companiaId);
						
			entity = new DatOtrosMovInventario();
		
			entity.setEstado("A");
			entity.setFechaRegistro(fechaOriginal);
			entity.setCompania(companiaId);
			entity.setFechaCreacion(date);
			entity.setDetalleNota("SALIDA A MÁQUINAS DESDE APP MÓVIL");
			entity.setUsuarioDigitacion(salidasProd.getUsuarioDigitacion());
			
			Long idMaquina = salidasProd.getEquipoId().longValue();
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
			entity.setConceptoKardex(conceptoKardex);
			
			// PRECIO_PROM_PROD
			dataDetPrecioProductos = new ArrayList<PrecioPromProdDTO>();
			detDto = new PrecioPromProdDTO();
			
			detDto.setConceptoKardexId(conceptoKardex);
			
			
			if (salidasProd.getUsuarioDigitacion() != null) {

				
				Object[] condicionBombero = { "usuario_asociado", true, salidasProd.getUsuarioDigitacion(), "=" };
				List<Trabajador> listaBombero = (salidasProd.getUsuarioDigitacion() != null)
						? businessDelegatorView.findByCriteriaInTrabajador(condicionBombero, null, null)
						: null;
				if (listaBombero != null && listaBombero.size() > 0) {
					bombero = listaBombero.get(0);
				}
			}
				
			// Long idBombero = salidasProd.getTrabajador();
			// bombero = businessDelegatorView.getTrabajador(idBombero);
			detDto.setTrabajador(bombero);
			
			

			if (salidasProd.getObservacion() != null) {
				detDto.setInfoAdicional(salidasProd.getObservacion());
			}

			Double cantidadAbastecimiento = salidasProd.getCantidadCompra();
		
			
			String productoAsociado = salidasProd.getProducto().toString().substring(2);
			Long productoFinal = Long.parseLong(productoAsociado);
			producto = businessDelegatorView.getProducto(productoFinal);
			Long udadMedId = producto.getUdadMedByUdadMedProd().getUdadMedId();

			unidadpago = businessDelegatorView.getUdadMed(udadMedId);

			detDto.setFechaInicial(fechaOriginal);
			detDto.setProducto(producto);
			detDto.setUnidadMedida(unidadpago);
			detDto.setEquipoId(equipo);
			
			
			if(producto.getUbicacionesAlmacenId()!=null) {
				detDto.setUbicacionesAlmacen(producto.getUbicacionesAlmacenId());
			}
			
			
			
			Double horometroAbastecimiento=0.0;
			if(salidasProd.getHorometroAbastecimiento()!=null) {
				horometroAbastecimiento= salidasProd.getHorometroAbastecimiento();
			}
			 
			detDto.setHorometro_abastecimiento(horometroAbastecimiento);

			Long indicador_vuelta_medidor=0L;
			if(equipo.getIndicador_vuelta_medidor()!=null) {
				indicador_vuelta_medidor = equipo.getIndicador_vuelta_medidor();
			}
			detDto.setIndicador_vuelta_medidor(indicador_vuelta_medidor);
			Long idAlmacen = salidasProd.getAlmacenId();
			almacen = businessDelegatorView.getAlmacen(idAlmacen);
			detDto.setAlmacenId(almacen);

			Double costoUnitCombustible = businessDelegatorView.consultarPrecioPromProducto(productoFinal, idAlmacen,
					companiaId, fechaOriginal);
			Double costoCombustible = 0.0;
			if (costoUnitCombustible != null) {
				costoCombustible = costoUnitCombustible.doubleValue() * cantidadAbastecimiento;
			}
			detDto.setCantidadCompra(cantidadAbastecimiento);
			detDto.setValorUnitario(costoUnitCombustible);
			detDto.setCostoTotal(costoCombustible);
			detDto.setCompania(companiaId);
			detDto.setFechaCreacion(date);

			/*Long idEmpresa = salidasProd.getPersEmprId_PersEmpr();
			persEmpr = businessDelegatorView.getPersEmpr(idEmpresa);
		
			Long idHacienda = salidasProd.getNivel2_clientesmq_id();
			nivNivel2Clientesmqel2 = businessDelegator2View.getNivel2Clientesmq(idHacienda);
			detDto.setNivel2_clientesmq_id(nivNivel2Clientesmqel2);

			

			Long idOperarioMaquina = salidasProd.getOperario_equipo_id();
			 operarioMaquina = businessDelegatorView.getTrabajador(idOperarioMaquina);
			 detDto.setOperario_equipo_id(operarioMaquina);
			
			Long idLabor = salidasProd.getConceptoGastoId();
			
			detDto.setConceptoGastoId(idLabor);*/
			detDto.setTipoMovimiento("PROC");
			detDto.setDiferido("NO");
			
			

				entity.setConsecutivo(businessDelegator2View.consec_otros_mov_inventario(companiaId));
				consecutivo = entity.getConsecutivo().longValue();
				detDto.setConsecutivo(consecutivo);
				dataDetPrecioProductos.add(detDto);
				businessDelegator2View.saveDatOtrosMovInventario(entity, dataDetPrecioProductos);

			
			detDto = null;
			fechaFinalDateRegistro = null;
			existeOT = false;
			
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
