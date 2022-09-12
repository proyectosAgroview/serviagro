package co.com.arcosoft.rest.service.control;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.arcosoft.modelo.AnaSanVeg;
import co.com.arcosoft.modelo.DatSanVeg;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.dto.ValorVarDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.SanidadVegetal;

@Controller
@RequestMapping("/transacciones")
public class WsAnalisisCensoPalma {

	private static final Logger logger = LoggerFactory.getLogger(WsAnalisisCensoPalma.class);

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;


	private DatSanVeg entity = null;

	List<ValorVarDTO> dataValor = null;

	
	@RequestMapping(value = "/guardarCensoPalma", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> guardarCensoPalma(@RequestBody SanidadVegetal sanidad) throws Exception {
		ValorVarDTO detDto = null;
		Nivel2 nivel2 = null;
		Nivel4 nivel4 = null;
		Date fechaFinalDateRegistro = null;
		Long consecutivo = null;
		String nombre_foto = null;
		AnaSanVeg tipoAnalisis =null;
		
		if (sanidad != null) {

			entity = new DatSanVeg();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = foriginal.parse(sanidad.getFechaAnalisis());
			String fsalida = sdf.format(fechaOriginal);
			fechaFinalDateRegistro = sdf.parse(fsalida);
			
			nivel2 = businessDelegatorView.getNivel2(sanidad.getNivel2Id_Nivel2().longValue());      
			nivel4 =  businessDelegatorView.getNivel4(sanidad.getNivel4Id().longValue()); 

			entity.setEstado("A");
			entity.setConsecutivo(
					(businessDelegatorView.consultarConsecutivoDatSanVeg(sanidad.getCompania().longValue())));
			
			consecutivo=entity.getConsecutivo().longValue();
			
			entity.setFechaAnalisis(fechaFinalDateRegistro);
			entity.setCompania(1l);// sanidad.getCompania());
			entity.setNivel1Id(sanidad.getNivel1Id().longValue());
			entity.setNivel2(nivel2);
			entity.setNivel3Id(sanidad.getNivel3Id());
			entity.setNivel4(nivel4);
			entity.setTrabajador(sanidad.getTrabId_Trabajador().longValue());
			tipoAnalisis = businessDelegatorView.getAnaSanVeg(6l);  
			entity.setAnaSanVeg(tipoAnalisis);
			
			entity.setLongitud(sanidad.getLongitud());
			entity.setLatitud(sanidad.getLatitud());
			
			if (sanidad.getObservacion() != null) {
				entity.setObservacion(sanidad.getObservacion());
			}

			entity.setUsuarioDigitacion(
					((sanidad.getUsuarioDigitacion() != null) ? sanidad.getUsuarioDigitacion() : null));

			
			
			/*if (sanidad.getFoto() != null) {
				
				if(sanidad.getNombre_foto() !=null) {
					entity.setFoto(sanidad.getNombre_foto());
					nombre_foto=sanidad.getNombre_foto();
					
				}
				
				String valor = sanidad.getFoto().replaceAll("\n", "");
				subirImagen(nombre_foto, valor);
			}else {
				entity.setFoto(null);
			}*/

			//fitosanidad detalle

			dataValor = new ArrayList<ValorVarDTO>();
			detDto = new ValorVarDTO();
			
			
			//Fitosanidad fito = businessDelegatorView.getFitosanidad(sanidad.getFitosanidad());
			
			//entity.set(fito);
			
			detDto.setVariable1(sanidad.getVariable1());
			detDto.setVariable2(sanidad.getVariable2());
			detDto.setVariable3(sanidad.getVariable3());
			
			dataValor.add(detDto);
			
			businessDelegatorView.saveDatSanVeg(entity, dataValor);

			entity = null;
			fechaFinalDateRegistro = null;
			nombre_foto = null;
			nivel2 = null;
			nivel4 = null;
			fechaFinalDateRegistro = null;
			nombre_foto = null;
			tipoAnalisis =null;
			dataValor  = null;

			

			
			return new ResponseEntity<String>(
					"El registro Censo de Palmas fue crado en AgroView consecutivo: (" + consecutivo.toString() + ")",
					HttpStatus.CREATED);

		} else {

			return new ResponseEntity<String>("No se encontró datos para grabar en AgroView Web (Censo de Palmas)",
					HttpStatus.NO_CONTENT);

		}

	}

	public void subirImagen(String nombreFile, String imageString) {

		String fileName = nombreFile;
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
            
			FacesContext context =  FacesContext.getCurrentInstance();
			ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
			String path = servletContext.getRealPath("");

			Base64.Decoder decoder = Base64.getDecoder();
			byte[] valueDecoded = decoder.decode(imageString);

			inputStream = new ByteArrayInputStream(valueDecoded);
			outputStream = new FileOutputStream(new File(path + "imagenes_subidas/" + fileName));

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

		
}
