package co.com.arcosoft.rest.service.control;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.arcosoft.modelo.DatPluvio;
import co.com.arcosoft.modelo.EstPluvio;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.presentation.businessDelegate2.IBusinessDelegator2View;
import co.com.arcosoft.rest.service.dto.DatPluvioDTO;

@Controller
@RequestMapping("/transacciones")
public class WsDatPluviometro {

	private static final Logger logger = LoggerFactory.getLogger(WsDatPluviometro.class);

	private DatPluvio entity = null;

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegator2View}")
	private IBusinessDelegator2View businessDelegator2View;
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;


	@RequestMapping(value = "/guardarPluviometros", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> guardarPluviometros(@RequestBody DatPluvioDTO pluvio) throws Exception {

		Date fechaPrecipitacion = null;
		Long consecutivo = null;
		EstPluvio estPluvio = null;

		if (pluvio != null) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = foriginal.parse(pluvio.getFechaPrecipitacion());
			String fsalida = sdf.format(fechaOriginal);
			fechaPrecipitacion = sdf.parse(fsalida);

			entity = new DatPluvio();

			entity.setEstado("A");
			entity.setConsecutivo(
				(businessDelegator2View.consultarConsec_dat_pluvio(pluvio.getCompania().longValue())));
			consecutivo = entity.getConsecutivo().longValue();

			estPluvio = businessDelegatorView.getEstPluvio(pluvio.getEstPluvioId_EstPluvio());
			entity.setEstPluvio(estPluvio);
			entity.setFechaPrecipitacion(fechaPrecipitacion);
			entity.setPrecipitacion(pluvio.getPrecipitacion());
			entity.setCompania(pluvio.getCompania().longValue());

			businessDelegatorView.saveDatPluvio(entity);

			entity = null;
			estPluvio = null;

			return new ResponseEntity<String>("El registro de Pluviometros fue crado en AgroView consecutivo: (" + consecutivo.toString() + ")",
					HttpStatus.CREATED);

		}else {

			return new ResponseEntity<String>("No se encontró datos para grabar en AgroView Web (Pluviometros)",HttpStatus.NO_CONTENT);

		}

	}


	public IBusinessDelegator2View getBusinessDelegator2View() {
		return businessDelegator2View;
	}


	public void setBusinessDelegator2View(IBusinessDelegator2View businessDelegator2View) {
		this.businessDelegator2View = businessDelegator2View;
	}


	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}


	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	

}
