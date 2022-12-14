package co.com.arcosoft.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 *         www.zathuracode.org
 * 
 */
public class ZMessManager extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(ZMessManager.class);

	public final static String ALL = "All ";
	public final static String ENTCHILD = "related tables(childs)";
	public final static String FOREIGNDATA = "foreign classes data: ";
	public static String ENTITY_SUCCESFULLYSAVEDEIMPORTACION = "La información se ha guardado, Ahora puede indicar valores en las variables del análisis";
	public static String ENTITY_SUCCESFULLYSAVED = "La información se ha guardado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYDELETED = "La información se ha eliminado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYMODIFIED = "La información se ha modificado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYANULADE = "El registro se ha anulado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYCLOSEOT = "La O.T se ha cerrado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYOPENOT = "La O.T se ha cerrado satisfactoriamente";
	
	public static String ENTITY_SUCCESFULLYCLOSESOLICITUD = "La solicitud se ha cerrado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYOPENSOLICITUD = "La solicitud se ha cerrado satisfactoriamente";
	public static String ENTITY_ERRORSOLICITUD = "La solicitud no se ha cerrado satisfactoriamente";
	
	public static String ENTITY_WITHSAMEKEY = "Another Entity with the same key was found";
	public static String ENTITY_NOENTITYTOUPDATE = "No Entity was found, with the typed key ";
	public static String ENTITY_SUCCESFULLYSAVEDPESOBRUTO = "El peso bruto fue grabado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYSAVEDPESOTARA = "El peso tara(sin carga) fue grabado satisfactoriamente";
	public static String ENTITY_SUCCESFULLYSAVEDPESONETO = "El peso neto fue grabado satisfactoriamente";

	public ZMessManager() {
	}

	public ZMessManager(String exception) {
		super(exception);
	}

	public class NotValidFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFieldException(String info) {
			super("The value for the field: \"" + info + "\" is not valid");
		}
	}

	public class NullEntityExcepcion extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NullEntityExcepcion(String info) {
			super("The " + info + " Entity can not be null or empty");
		}
	}

	public class EmptyFieldException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public EmptyFieldException(String info) {
			super("The value for the field: \"" + info + "\" can not be null or empty");
		}
	}

	public class NotValidFormatException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public NotValidFormatException(String info) {
			super("The Format or length for the field: \"" + info + "\" is not valid");
		}
	}

	public class DeletingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public DeletingException(String info) {
			super("The Entity you are trying to delete " + "may have related information, "
					+ "please before trying again, " + "check the data on the entity, \"" + info + "\"");
		}
	}

	public class ForeignException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public ForeignException(String info) {
			super("There was no data related with the input \"" + info + "\"");
		}
	}

	public class GettingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public GettingException(String info) {
			super("There was an exception getting " + info);
		}
	}

	public class FindingException extends ZMessManager {
		private static final long serialVersionUID = 1L;

		public FindingException(String info) {
			super("There was an exception trying to find " + info);
		}
	}

}
