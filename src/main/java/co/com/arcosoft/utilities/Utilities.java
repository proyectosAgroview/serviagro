package co.com.arcosoft.utilities;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.validator.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 *         www.zathuracode.org
 * 
 */
public class Utilities {

	private static final Logger log = LoggerFactory.getLogger(Utilities.class);

	public static boolean isNumeric(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	/**
	 * 
	 * @param word
	 * @return Expresion regular "(\\d){1,10}\\.(\\d){1,10}" (\\d)digito
	 *         {1,10}de 1 a 10 caracteres \\. punto
	 * 
	 */
	public static boolean isDecimal(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("(\\d){1,8}\\.(\\d){0,2}");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
		// DoubleValidator doubleValidator = new DoubleValidator();
		// return doubleValidator.isValid(word);
	}

	public static boolean checkNumberAndCheckWithPrecisionAndScale(String fieldValue, Integer precision,
			Integer scale) {
		boolean ret = false;
		if (fieldValue != null && precision != null && scale != null) {
			if (fieldValue.contains("E") && scale != 0) {
				String dfString = "# # . # # # # # # # # # # # # # # # #";
				dfString = dfString.replace(" ", "");
				DecimalFormat df = new DecimalFormat(dfString);
				fieldValue = df.format(new Double(fieldValue));
				if (fieldValue.length() > 0 && !fieldValue.contains(".")) {
					fieldValue = fieldValue + ".0";
				}
			}
			fieldValue = fieldValue.replace(".", "%");
			String[] spitedFieldValue = fieldValue.split("%");
			if (spitedFieldValue.length == 2 && precision != 0) {
				String precisionTmp = spitedFieldValue[0];
				String scaleTmp = spitedFieldValue[1];
				if (!isNumeric(precisionTmp)) {
					return false;
				}
				if (!isNumeric(scaleTmp)) {
					return false;
				}
				if ((precisionTmp.length() <= precision) && (scaleTmp.length() <= scale)) {
					ret = true;
				}
			} else {
				if (spitedFieldValue.length == 1 && precision != 0 && scale == 0) {
					String precisionTmp = spitedFieldValue[0];
					if (!isNumeric(precisionTmp)) {
						return false;
					}
					if ((precisionTmp.length() <= precision)) {
						ret = true;
					}
				} else {
					return false;
				}
			}
		}
		return ret;
	}

	public static boolean checkWordAndCheckWithlength(String word, Integer length) {
		boolean ret = false;
		if (word.length() <= length) {
			ret = true;
		}
		return ret;
	}

	public static boolean isOnlyLetters(String word) {
		boolean ret = false;
		Pattern pat = Pattern.compile("[^A-Za-z0-9',.\\s]");
		Matcher mat = pat.matcher(word);
		if (!mat.find()) {
			ret = true;
		}
		return ret;
	}

	public static String formatDateWithoutTimeInAStringForBetweenWhere(Date fecha) {
		int year = fecha.getYear() + 1900;
		int month = fecha.getMonth() + 1;
		int day = fecha.getDate();
		String date = "" + year + "-" + month + "-" + day;
		return date;
	}

	public static boolean validationsList(List list) {
		if (list != null) {
			if (!list.isEmpty() && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean validateEmailAddress(String sEmail) {
		EmailValidator emailValidator = EmailValidator.getInstance();
		return emailValidator.isValid(sEmail);
	}

	/**
	 * 
	 * @param object
	 * @param object2
	 * @param privateFields
	 * @return
	 * @throws Exception
	 */
	public static boolean matchClasses(Object object, Object object2, boolean privateFields) throws Exception {

		boolean couldPerformTask = false;
		Object paramsObj[] = {};

		Class tmpClass = object.getClass();
		Class tmpClass2 = object2.getClass();

		Field field[] = tmpClass.getDeclaredFields();
		Field field2[] = tmpClass2.getDeclaredFields();

		Method method[] = tmpClass.getMethods();
		Method method2[] = tmpClass2.getMethods();

		String tmpName = new String();
		String tmpName2 = new String();

		Field tmpField;
		Field tmpField2;

		Method tmpMethod;
		Method tmpMethod2;

		Object tmpInfo = new Object();
		Object tmpInfo2 = new Object();

		Class[] paramTypes = null;
		Class[] paramTypes1 = null;

		if (privateFields) {

			try {
				if (method != null && method.length > 0) {

					for (int i = 0; i < method.length; i++) {
						tmpMethod = method[i];
						tmpMethod2 = method2[i];

						if (tmpMethod != null && tmpMethod2 != null) {
							paramTypes = tmpMethod.getParameterTypes();
							tmpName = tmpMethod.getName().substring(0, 3);

							paramTypes1 = tmpMethod2.getParameterTypes();
							tmpName2 = tmpMethod2.getName().substring(0, 3);

							if (tmpName.equals("get") && tmpName2.equals("get")) {

								tmpInfo = tmpMethod.invoke(object, paramsObj);
								tmpInfo2 = tmpMethod2.invoke(object2, paramsObj);

								if (tmpInfo != null && tmpInfo2 != null) {
									try {
										if (tmpInfo.equals(tmpInfo2)) {
											couldPerformTask = true;
										} else {
											return false;
										}
									} catch (Exception e) {

										if (tmpInfo == tmpInfo2) {
											couldPerformTask = true;
										} else {
											return false;
										}
									}
								}
							}
						}
					}

				} else {
					throw new Exception("One of the the Classes has no \"get\" methods please check");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			try {
				for (int j = 0; j < field.length; j++) {
					tmpField = field[j];
					tmpField2 = field2[j];

					if (tmpField != null && tmpField2 != null) {

						tmpInfo = tmpField.get(object);
						tmpInfo2 = tmpField2.get(object2);

						if (tmpInfo != null && tmpInfo2 != null) {
							try {
								if (tmpInfo.equals(tmpInfo2)) {
									couldPerformTask = true;
								} else {
									return false;
								}
							} catch (Exception e) {

								if (tmpInfo == tmpInfo2) {
									couldPerformTask = true;
								} else {
									return false;
								}
							}
						}
					} else {
						throw new Exception("One of the the Classes has no fields methods please check");
					}
				}
			} catch (IllegalAccessException ea) {
				throw new Exception(
						"One of the objects you are trying to compare has its fields private please use the method way");
			} catch (Exception e) {
				throw e;
			}
		}
		return couldPerformTask;
	}

	public String constructQuery(Object[] variables, Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null) && (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0)
								? ("(model." + variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " " + comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null) && (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null) && (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0)
							? ("(" + value + " " + comparator1 + " " + variable + " and " + variable + " " + comparator2
									+ " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1 + " " + variable + " and " + variable
									+ " " + comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null) && (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						throw e;
					}

					tempWhere = (tempWhere.length() == 0)
							? ("(model." + variable + " between \'" + value + "\' and \'" + value2 + "\')")
							: (tempWhere + " AND (model." + variable + " between \'" + value + "\' and \'" + value2
									+ "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = "";
		} else {
			where = "where (" + tempWhere + ")";
		}

		return where;
	}

}
