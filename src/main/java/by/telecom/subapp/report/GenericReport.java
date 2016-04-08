package by.telecom.subapp.report;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.stereotype.Component;

@Component
public class GenericReport implements Report {

	private static Logger logger = Logger.getLogger(Report.class);

	@Override
	public <T> void create(String pathForSaving, String pathForPattern, List<T> dataList) {
		try {
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("DATE", new Date());
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
