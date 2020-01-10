package it.jac.javadb.esercitazione.util;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.jac.javadb.esercitazione.entity.Multe;

public class Utils {

	private static final Logger log = LogManager.getLogger(Utils.class);
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void stampaLista(List<Multe> list) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("-----------------------------------------------------------\n\n");
		for(Multe bean : list) {
/*
			sb.append("|").append(StringUtils.rightPad(bean.getId(), 10)).append("|")
			.append(StringUtils.rightPad(bean.getNome(), 45)).append("|")
			.append(StringUtils.rightPad(bean.getCognome(), 45)).append("|")
			.append(StringUtils.rightPad(bean.getCognome(), 45)).append("|")
			.append(StringUtils.rightPad(bean.getCognome(), 45)).append("|");
			sb.append("\n");
			*/
		}
		sb.append("-----------------------------------------------------------");	
		log.info(sb.toString());
		
	}

}
