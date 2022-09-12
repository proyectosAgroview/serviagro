package co.com.arcosoft.rest.service.control;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.rest.service.dto.LaborDTO;

@Controller
@RequestMapping("/catalogos")
public class WsLabor {

	private static final Logger logger = LoggerFactory.getLogger(WsLabor.class);

	@Autowired
	ILaborLogic laborlogic;

	@RequestMapping(value = "/listarLabor", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<LaborDTO>> listarLabores() throws Exception {

		List<Labor> a = new ArrayList<Labor>();
		List<LaborDTO> ma = new ArrayList<LaborDTO>();

		a = laborlogic.getLabor();

		if (a != null && a.size() > 0) {

			for (Labor mLabor : a) {

				if (mLabor.getEstado().equals("A") && mLabor.getTipoLabor().equals("servicio_agricola")) {

					LaborDTO tmp = new LaborDTO();
					tmp.setLaborId(mLabor.getLaborId());
					tmp.setCodigo(mLabor.getCodigo());
					tmp.setNombre(mLabor.getNombre());
					tmp.setTipoLabor(mLabor.getTipoLabor());
					
					
					if(mLabor.getUdadMedByUdadMedPago() !=null) {
						tmp.setUdadMedByUdadMedPago(mLabor.getUdadMedByUdadMedPago().getUdadMedId());
					}else {
						tmp.setUdadMedByUdadMedPago(0L);
					}
					
					if(mLabor.getRendimientoMq() !=null) {
						if(mLabor.getRendimientoMq() >0) {
						   tmp.setRendimientoMq(mLabor.getRendimientoMq().toString());
						}
					}else {
						tmp.setRendimientoMq("0.0");
					}
					if(mLabor.getClaseLabor()!=null) {
					tmp.setClaseLabor(mLabor.getClaseLabor());
					}else {
						tmp.setClaseLabor("Otros");
					}
					
					
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<LaborDTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<LaborDTO>>(HttpStatus.NO_CONTENT);
		}

	}

}
