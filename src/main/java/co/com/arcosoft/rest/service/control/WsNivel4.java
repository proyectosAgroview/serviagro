package co.com.arcosoft.rest.service.control;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import co.com.arcosoft.modelo.Nivel1;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel3;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.control.INivel2Logic;
import co.com.arcosoft.modelo.control.INivel3Logic;
import co.com.arcosoft.modelo.control.INivel4Logic;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.Nivel4DTO;

@Controller
@RequestMapping("/catalogos")
public class WsNivel4 {

	private static final Logger logger = LoggerFactory.getLogger(WsNivel4.class);
	
	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	@Autowired
	INivel4Logic nivellogic;
	
	@Autowired
	INivel3Logic nivel3logic;
	
	@Autowired
	INivel2Logic nivel32logic;
	
	

	@RequestMapping(value = "/listarNivel4", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Nivel4DTO>> listarNivel4() throws Exception {

		List<Nivel4> a = new ArrayList<Nivel4>();
		List<Nivel4DTO> ma = new ArrayList<Nivel4DTO>();
		Nivel3 n3 = null;
		Nivel2 n2 = null;
		Nivel1 n1 = null;

		a = nivellogic.getNivel4();

		if (a != null && a.size() > 0) {

			for (Nivel4 mNivel4 : a) {

				if (mNivel4.getEstado().equals("A")) {

					Nivel4DTO tmp = new Nivel4DTO();
					
					tmp.setCodigo(mNivel4.getCodigo());
					tmp.setNombre(mNivel4.getNombre());
					tmp.setCompania(mNivel4.getCompania());

					String nivel3Id = mNivel4.getNivel3().getNivel3Id().toString();
					Object[] condicionN3 = {"nivel3Id" , true , nivel3Id , "=" };
					List<Nivel3> lista3  = (nivel3Id != null)
							? businessDelegatorView.findByCriteriaInNivel3(condicionN3, null, null) : null;
							
					n3 = new Nivel3();
					n3=lista3.get(0); 
					
					String nivel2Id = n3.getNivel2().getNivel2Id().toString();
					Object[] condicionN2 = {"nivel2Id" , true , nivel2Id , "=" };
					List<Nivel2> lista2  = (nivel2Id != null)
							? businessDelegatorView.findByCriteriaInNivel2(condicionN2, null, null) : null;
					
					n2= new Nivel2();
					n2=lista2.get(0); 
					
					String nivel1Id = n2.getNivel1().getNivel1Id().toString();
					Object[] condicionN1 = {"nivel1Id" , true , nivel1Id , "=" };
					List<Nivel1> lista1  = (nivel1Id != null)
							? businessDelegatorView.findByCriteriaInNivel1(condicionN1, null, null) : null;
	                
					n1= new Nivel1();
					n1=lista1.get(0); 
					
					tmp.setNivel1(n1.getNivel1Id());//finca
					tmp.setNivel2(n2.getNivel2Id());//siembra
					
					tmp.setNivel3(n3.getNivel3Id()); //subsector
					tmp.setNivel4Id(mNivel4.getNivel4Id());//lote
					tmp.setAreaNeta((mNivel4.getAreaNeta() != null) ? mNivel4.getAreaNeta() : null);
					// tmp.setAreaBruta((mNivel4.getAreaBruta() != null) ?
					// mNivel4.getAreaBruta().doubleValue(): null);
					tmp.setNumPlantasSembradas(
							(mNivel4.getNumPlantasSembradas() != null) ? mNivel4.getNumPlantasSembradas() : 0); // Preguntar
																												// NUMERO_PALMA
					ma.add(tmp);
				}

			}

			return new ResponseEntity<List<Nivel4DTO>>(ma, HttpStatus.OK);

		} else {

			return new ResponseEntity<List<Nivel4DTO>>(HttpStatus.NO_CONTENT);
		}

	}



	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}



	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	

}
