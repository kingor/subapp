package by.telecom.subapp.report.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Logger;

import by.telecom.subapp.report.Report;

public class GenericReport<T> implements Report<T> {

	private static Logger logger = Logger.getLogger(Report.class);

	@Override
	public void create(String pathForSaving, String pathForPattern, List<T> dataList, Map<String, Object> parameters) {
		try {
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
			File reportPattern = new File(pathForPattern);
			JasperDesign jasperDesign = JRXmlLoader.load(reportPattern);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

			JasperExportManager.exportReportToPdfFile(jasperPrint, pathForSaving);
			logger.info("REPORT - Report was generated");
		} catch (Exception e) {
			logger.error("REPORT - Report was not be generated! There are some errors: " + e);
		}
	}

}
