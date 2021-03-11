package util;

/**
 * Classe auziliar para armazenar m�todos de convers�o de daods
 * 
 * @author Jo�o Victor
 * @since 09/03/2021
 * @version 1.0
 */
public class Util {

	/*
	 * m�todo para converter uma String em inteiro
	 */
	public static Integer getInt(String args) {
		return Integer.parseInt(args);
	}

	/*
	 * m�todo para converter uma String em double
	 */
	public static Double getDouble(String args) {
		return Double.parseDouble(args);
	}

	public static Boolean getBoolean(String args) {
		return Boolean.parseBoolean(args);
	}

}