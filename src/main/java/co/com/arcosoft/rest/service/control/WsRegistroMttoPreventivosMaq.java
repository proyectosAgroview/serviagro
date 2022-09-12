package co.com.arcosoft.rest.service.control;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import co.com.arcosoft.modelo.DatMantenimientoEquipo;
import co.com.arcosoft.modelo.DatMantenimientoEquipoProd;
import co.com.arcosoft.modelo.Equipo;
import co.com.arcosoft.modelo.Medidor;
import co.com.arcosoft.modelo.control.IProductoLogic;
import co.com.arcosoft.modelo.dto.DatMantenimientoEquipoProdDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.ProgMttoPreventivosMaqDTO;
import co.com.arcosoft.utilities.FacesUtils;

@Controller
@RequestMapping("/transacciones")
public class WsRegistroMttoPreventivosMaq {

	private static final Logger logger = LoggerFactory.getLogger(WsRegistroMttoPreventivosMaq.class);

	private DatMantenimientoEquipo entity = null;
	private DatMantenimientoEquipoProd entityProd = null;
	List<DatMantenimientoEquipoProdDTO> dataEquipoProd = null;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;

	@Autowired
	IProductoLogic productoLogic;
	
	@Autowired
	ServletContext servletContext;

	boolean existeOT = false;

	@RequestMapping(value = "/registroMttoPreventivosMaq", method = RequestMethod.POST)
	public ResponseEntity<String> guardarMttoPreventivosMaq(@RequestBody ProgMttoPreventivosMaqDTO mttoPreventivo)
			throws Exception {

		Long consecutivo = null;
		Equipo equipo = null;
		Long equipoId = null;
		String nombreEquipo = null;
		Long idlabor = null;
		String nombre_foto = null;
		if (mttoPreventivo != null) {

			// entity = new DatMantenimientoEquipo();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginalInicial = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat foriginalFinal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginalInicial = mttoPreventivo.getFecha_entrada_taller();
			Date fechaOriginalFinal = mttoPreventivo.getFecha_salida_taller();
			// String fsalida = sdf.format(fechaOriginal);

			// fechaFinalDateRegistro = sdf.parse(fsalida);

			if (mttoPreventivo.getId_mtto() != null) {

				Long idMtto = mttoPreventivo.getId_mtto().longValue();

				Object[] condicionOt = { "datMantenimientoEquipoId", true, idMtto, "=" };
				List<DatMantenimientoEquipo> listaOt = (idMtto != null)
						? businessDelegatorView.findByCriteriaInDatMantenimientoEquipo(condicionOt, null, null)
						: null;
				if (listaOt != null && listaOt.size() > 0) {
					entity = listaOt.get(0);

					equipoId = entity.getEquipo().getEquipoId();

					if (equipoId != null && !equipoId.toString().isEmpty()) {
						equipo = businessDelegatorView.getEquipo(equipoId);

						if (equipo.getMedidor() != null) {

							Medidor medidor = businessDelegatorView.getMedidor(equipo.getMedidor().longValue());
							if (medidor != null) {

								if (medidor.getTipoMedidor().equals("horometro")
										|| medidor.getTipoMedidor().equals("dia")) {
									
								//	Double horActual = businessDelegatorView
									//		.consultarHorometroActual(new Date(), equipoId, equipo.getMedidor().longValue(), entity.getCompania()).doubleValue();
								//	if(mttoPreventivo.getHoro_odo_entrada().doubleValue() <= horActual) {
									entity.setVidaHoras(mttoPreventivo.getHoro_odo_entrada().doubleValue());
									////}else {
									//	entity.setVidaHoras(horActual);
								//	}

								} else if (medidor.getTipoMedidor().equals("odometro")) {
								//	Double odoActual =businessDelegatorView
									//		.consultarOdometroActual(new Date(), equipoId, equipo.getMedidor().longValue(), entity.getCompania()).doubleValue();
									
								//	if(mttoPreventivo.getHoro_odo_entrada().doubleValue()<=odoActual) {
										entity.setVidaKm(mttoPreventivo.getHoro_odo_entrada().doubleValue());
									//}else {
									//	entity.setVidaKm(odoActual);
									//}
								}
							}
						}
					}

					if (mttoPreventivo.getReporteTecnico() != null) {
						entity.setReporteTecnico(mttoPreventivo.getReporteTecnico());
					}

					entity.setFechaSalidaTaller(fechaOriginalFinal);

					entity.setFechaModificacion(new Date());
					// entity.setUsuarioDigitacion(mttoPreventivo.getUsuario_digitacion());
					entity.setTipoProcedimiento("Mtto sincronizado desde la app móvil");

					if (mttoPreventivo.getFoto() != null) {

						if (mttoPreventivo.getNombre_foto() != null) {
							entity.setFoto(mttoPreventivo.getNombre_foto());
							nombre_foto = mttoPreventivo.getNombre_foto();

						}

						String valor = mttoPreventivo.getFoto();
						subirImagen(nombre_foto, valor);
					}
					
					// DAT_PLANILLA_NOMINA_DET

					if (mttoPreventivo.getId_programa() != null) {

						Long idProgramaProd = mttoPreventivo.getId_programa().longValue();

						Object[] condicionProd = { "datMantenimientoEquipoProdId", true, idProgramaProd, "=" };
						List<DatMantenimientoEquipoProd> listaProd = (idProgramaProd != null)
								? businessDelegatorView.findByCriteriaInDatMantenimientoEquipoProd(condicionProd, null,
										null)
								: null;
						if (listaProd != null && listaProd.size() > 0) {
							entityProd = listaProd.get(0);

							entityProd.setCantidad(mttoPreventivo.getCantidadReal().doubleValue());
							businessDelegatorView.updateDatMantenimientoEquipoProd(entityProd);
						}

					}
					
						
					businessDelegatorView.updateDatMantenimientoEquipo(entity, null, null, null);

					dataEquipoProd = null;
					entity = null;
					existeOT = false;
					equipo = null;
					nombre_foto = null;
				}
			}

			return new ResponseEntity<String>(
					"El registro de Mtto preventivo fue enviado correctamente" ,
					HttpStatus.CREATED);

		} else {

			return new ResponseEntity<String>("El objeto de Labores realizadas enviado desde AgroViewMobile es nulo",
					HttpStatus.BAD_REQUEST);
		}

	}
	
	
	public void subirImagen(String nombreFile, String imageString) {

		String fileName = nombreFile;
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			
			//String path =ruta;
			String path =servletContext.getRealPath("");
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] valueDecoded = decoder.decode(imageString);

			inputStream = new ByteArrayInputStream(valueDecoded);
			outputStream = new FileOutputStream(new File(path + "/imagenes_subidas/" + fileName));

			int read = 0;
			byte[] bytes = new byte[100000];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

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
