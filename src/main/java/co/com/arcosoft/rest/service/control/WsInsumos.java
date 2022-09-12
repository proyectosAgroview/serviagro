package co.com.arcosoft.rest.service.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.DatAplicProducto;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.Producto;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.dto.DatAplicProdDetDTO;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.Insumos;

@Controller
@RequestMapping("/transacciones")
public class WsInsumos {

	private static final Logger logger = LoggerFactory.getLogger(WsInsumos.class);

	// private DatPlanillaNomina entity = null;
	List<DatPlanillaNominaDetDTO> dataPlanillaDet = null;

	private DatAplicProducto entity = null;
	List<DatAplicProdDetDTO> dataAplicProductoDet = null;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@RequestMapping(value = "/guardarInsumo", method = RequestMethod.POST)
	public ResponseEntity<String> guardarInsumo(@RequestBody Insumos insumos) throws Exception {

		Labor labor = null;
		Nivel2 nivel2 = null;
		Nivel4 nivel4 = null;
		DatAplicProdDetDTO detDto = null;
		Producto producto = null;
		Date fechaFinalDateRegistro = null;
		Long consecutivo = null;
		UdadMed unidadAplicacion = null;

		if (insumos != null) {

			entity = new DatAplicProducto();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = foriginal.parse(insumos.getFechaRegistro());
			String fsalida = sdf.format(fechaOriginal);

			fechaFinalDateRegistro = sdf.parse(fsalida);

			// DAT_APLIC_PRODUCTO

			Object[] condicion2 = { "codigo", true, insumos.getLaborId_Labor(), "=" };

			List<Labor> listaLabor = businessDelegatorView.findByCriteriaInLabor(condicion2, null, null);

			labor = new Labor();
			labor = listaLabor.get(0);

			nivel2 = businessDelegatorView.getNivel2(insumos.getNivel2Id());
			nivel4 = businessDelegatorView.getNivel4(insumos.getNivel4Id_Nivel4());

			entity.setEstado("A");
			entity.setConsecutivo(
					(businessDelegatorView.consultarConsecutivoDatAplicProducto(insumos.getCompania().longValue())));
			entity.setFechaRegistro(fechaFinalDateRegistro);
			entity.setCompania(insumos.getCompania());
			entity.setLabor(labor);
			entity.setNPases(1L);
			entity.setNivel1Id(insumos.getNivel1Id());
			entity.setNivel2Id(nivel2);
			entity.setNivel3Id(insumos.getNivel3Id());
			entity.setNivel4(nivel4);
			entity.setAlmacen(insumos.getAlmacenId_Almacen().longValue());
			entity.setNumTinas((insumos.getNumTinas() != null) ? insumos.getNumTinas().doubleValue() : null);
			entity.setNPases((insumos.getNPases() != null) ? insumos.getNPases().longValue() : null);
			entity.setFechaCreacion(new Date());
			entity.setUsuarioDigitacion(insumos.getUsuarioDigitacion());

			consecutivo = entity.getConsecutivo().longValue();

			Long idUnicoMo = (businessDelegatorView
					.consultarConsecutivoUnicoDatPlanillaNomina(insumos.getCompania().longValue()));
			entity.setDatPlanillaNominaId(idUnicoMo);

			// DAT_APLIC_PROD_DET

			dataAplicProductoDet = new ArrayList<DatAplicProdDetDTO>();
			detDto = new DatAplicProdDetDTO();

			Object[] condicion3 = { "codigo", true, insumos.getProductoId_Producto().toString(), "=" };

			List<Producto> listaProducto = businessDelegatorView.findByCriteriaInProducto(condicion3, null, null);

			producto = new Producto();
			producto = listaProducto.get(0);

			unidadAplicacion = businessDelegatorView.getUdadMed(producto.getUdadMedByUdadMedProd().getUdadMedId());

			detDto.setProductoId_Producto(producto);
			detDto.setUdadMedId_UdadMed(unidadAplicacion);
			detDto.setCantidadAplicada(insumos.getDosis().doubleValue());
			// detDto.setDosis(insumos.getDosis().doubleValue());
			detDto.setCompania(insumos.getAlmacenId_Almacen().longValue());

			dataAplicProductoDet.add(detDto);

			businessDelegatorView.saveDatAplicProducto(entity, dataAplicProductoDet);

			labor = null;
			nivel2 = null;
			nivel4 = null;
			detDto = null;
			producto = null;
			dataAplicProductoDet = null;
			entity = null;
			fechaFinalDateRegistro = null;

			return new ResponseEntity<String>(
					"El registro de insumos fue creado en AgroView consecutivo: (" + consecutivo + ")",
					HttpStatus.CREATED);

		} else {

			return new ResponseEntity<String>("El objeto Insumos fue enviado desde AgroViewMobile nulo",
					HttpStatus.BAD_REQUEST);
		}

	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

}
