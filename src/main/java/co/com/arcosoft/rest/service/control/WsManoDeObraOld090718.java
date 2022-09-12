package co.com.arcosoft.rest.service.control;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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

import co.com.arcosoft.modelo.ConceptoNomina;
import co.com.arcosoft.modelo.DatPlanLaborDet;
import co.com.arcosoft.modelo.DatPlanillaNomina;
import co.com.arcosoft.modelo.Labor;
import co.com.arcosoft.modelo.Nivel2;
import co.com.arcosoft.modelo.Nivel4;
import co.com.arcosoft.modelo.PersEmpr;
import co.com.arcosoft.modelo.Trabajador;
import co.com.arcosoft.modelo.UdadMed;
import co.com.arcosoft.modelo.control.IDatPlanLaborDetLogic;
import co.com.arcosoft.modelo.control.ILaborLogic;
import co.com.arcosoft.modelo.control.ITrabajadorLogic;
import co.com.arcosoft.modelo.dto.DatPlanillaNominaDetDTO;
import co.com.arcosoft.presentation.businessDelegate.IBusinessDelegatorView;
import co.com.arcosoft.rest.service.dto.ManoDeObra;

@Controller
@RequestMapping("/transacciones")
public class WsManoDeObraOld090718 {

	private static final Logger logger = LoggerFactory.getLogger(WsManoDeObraOld090718.class);

	@Autowired
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	private DatPlanillaNomina entity = null;
	List<DatPlanillaNominaDetDTO> dataPlanillaDet = null;

	@Autowired
	IDatPlanLaborDetLogic planLaborLogic;

	@Autowired
	ILaborLogic laborlogic;

	@Autowired
	ITrabajadorLogic trabajadorLogic;
	
	boolean existeOT=false;

	@RequestMapping(value = "/guardarManodeobraOld090718", method = RequestMethod.POST)
	public ResponseEntity<String> guardarManodeobraOld090718(@RequestBody ManoDeObra manoobra) throws Exception {

		Labor labor = null;
		Nivel2 nivel2 = null;
		Nivel4 nivel4 = null;
		DatPlanillaNominaDetDTO detDto = null;
		UdadMed unidadpago = null;
		Trabajador trabajador = null;
		Date fechaFinalDateRegistro = null;
		Long consecutivo = null;
		ConceptoNomina conceptoNomina = null;
		DatPlanLaborDet idOt = null;

		if (manoobra != null) {

			entity = new DatPlanillaNomina();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat foriginal = new SimpleDateFormat("yyyy-MM-dd");

			Date fechaOriginal = foriginal.parse(manoobra.getFechaRegistro());
			String fsalida = sdf.format(fechaOriginal);

			fechaFinalDateRegistro = sdf.parse(fsalida);

			if(manoobra.getOrdenTrabajo()!=null){
				
				String codigoLabor = manoobra.getLaborId_Labor().toString().trim().toUpperCase();
				Object[] condicionlabor = {"laborId" , true , codigoLabor , "=" };
				List<Labor> listaLabor  = (codigoLabor != null)
						? businessDelegatorView.findByCriteriaInLabor(condicionlabor, null, null) : null;
	
				labor = new Labor();
				labor = listaLabor.get(0);
			}else{
				String codigoLabor = manoobra.getLaborId_Labor().toString().trim().toUpperCase();
				Object[] condicionlabor = {"codigo" , true , codigoLabor , "=" };
				List<Labor> listaLabor  = (codigoLabor != null)
						? businessDelegatorView.findByCriteriaInLabor(condicionlabor, null, null) : null;
	
				labor = new Labor();
				labor = listaLabor.get(0);
	
			}
			
			if(manoobra.getObservacion() !=null){
				entity.setObservacion(manoobra.getObservacion());
			}

			
			if(manoobra.getOrdenTrabajo()!=null){
				
			  existeOT=true;
					
				String codigoOt = manoobra.getOrdenTrabajo().toString().trim().toUpperCase();
				Object[] condicionOt = {"planLaborDetId" , true , codigoOt , "=" };
				List<DatPlanLaborDet> listaOt  = (codigoOt != null)
						? businessDelegatorView.findByCriteriaInDatPlanLaborDet(condicionOt, null, null) : null;
	
				idOt = new DatPlanLaborDet();
				idOt = listaOt.get(0);
			
			}else {
				existeOT=false;
			}

			
			nivel2 = businessDelegatorView.getNivel2(manoobra.getNivel2Id());
			nivel4 = businessDelegatorView.getNivel4(manoobra.getNivel4Id_Nivel4().longValue());

			entity.setEstado("A");
			entity.setConsecutivo(
					(businessDelegatorView.consultarConsecutivoDatPlanillaNomina(manoobra.getCompania().longValue())));
			entity.setFechaRegistro(fechaFinalDateRegistro);
			
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(fechaFinalDateRegistro);
			long anioRegistro = calendario.get(java.util.Calendar.YEAR);
			entity.setAnio(new Long(anioRegistro));
			
			entity.setCompania(manoobra.getCompania());
			
			entity.setFechaCreacion(new Date());
			entity.setUsuarioDigitacion(manoobra.getUsuarioDigitacion());

			consecutivo = entity.getConsecutivo().longValue();

			// DAT_PLANILLA_NOMINA_DET

			dataPlanillaDet = new ArrayList<DatPlanillaNominaDetDTO>();
			detDto = new DatPlanillaNominaDetDTO();

			unidadpago = businessDelegatorView.getUdadMed(manoobra.getUdadMedIdPago());

			Object[] condicion3 = { "codigo", true, manoobra.getTrabId_Trabajador(), "=" };

			List<Trabajador> listaTrabajador = businessDelegatorView.findByCriteriaInTrabajador(condicion3, null, null);

			//String c = manoobra.getCeptoNominaId_ConceptoNomina().toString();

			Object[] condicion4 = { "codigo", true, '1', "=" };

			List<ConceptoNomina> listaConceptoNomina = businessDelegatorView.findByCriteriaInConceptoNomina(condicion4,
					null, null);

			// ConceptoNomina

			trabajador = new Trabajador();
			trabajador = listaTrabajador.get(0);

			conceptoNomina = new ConceptoNomina();
			conceptoNomina = listaConceptoNomina.get(0);
			
			if(existeOT) {
				detDto.setOrdenTrabajo(idOt);
			}
			
			detDto.setLaborId(labor);
			detDto.setNivel2Id(nivel2);
			detDto.setNivel4(nivel4);
			
			detDto.setCantidadPago(manoobra.getCantidadPago());
			detDto.setUdadMedIdPago(unidadpago);
			// detDto.setUdadMedProd(
			// (manoobra.getUdadMedProd() != null) ?
			// manoobra.getUdadMedProd().longValue() : null);
			detDto.setTrabId_Trabajador(trabajador);
			Long contratista = trabajador.getContratista().getPersEmprId();
			PersEmpr persEmpr = businessDelegatorView.getPersEmpr(contratista);
			
			detDto.setPersEmprId_PersEmpr(persEmpr);
			detDto.setCeptoNominaId_ConceptoNomina(conceptoNomina);

			
			BigDecimal tarifaPago = businessDelegatorView.consultarTarifaContratista(1L, 
					trabajador.getContratista().getPersEmprId().longValue(),
					labor.getLaborId().longValue(),
					conceptoNomina.getCeptoNominaId().longValue(),
					manoobra.getUdadMedIdPago().longValue(),
					fechaFinalDateRegistro,0.0,"",manoobra.getNivel2Id().longValue(),
					manoobra.getNivel4Id_Nivel4().longValue(),"");
			
			detDto.setValorUnitario(tarifaPago.doubleValue());
			
			Double costoTotal = 0.0;
			Double pesoP = 0.0;
			
			if(nivel2.getPesoPromedio() != null){
				 pesoP = nivel2.getPesoPromedio();
			}
			
			if (manoobra.getCantidadPago() != null  && tarifaPago != null) {
					costoTotal = (manoobra.getCantidadPago().doubleValue()) * tarifaPago.doubleValue();
				}
			
			detDto.setCantidadDescontar(0.0);
			detDto.setCostoTotal(costoTotal);
			

			dataPlanillaDet.add(detDto);

			businessDelegatorView.saveDatPlanillaNomina(entity, dataPlanillaDet,null,null,null,null);

			labor = null;
			nivel2 = null;
			nivel4 = null;
			detDto = null;
			unidadpago = null;
			trabajador = null;
			dataPlanillaDet = null;
			entity = null;
			fechaFinalDateRegistro = null;
			existeOT=false;

			return new ResponseEntity<String>(
					"El registro de Mano de Obra fue crado en AgroView consecutivo: (" + consecutivo.toString() + ")",
					HttpStatus.CREATED);

		} else {

			return new ResponseEntity<String>("El objeto Mano de Obra enviado desde AgroViewMobile es nulo",
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
