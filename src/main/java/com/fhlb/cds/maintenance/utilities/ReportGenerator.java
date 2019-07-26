package com.fhlb.cds.maintenance.utilities;

/**This class used to generate report file as per selected export type**/
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import com.fhlb.commons.CustomException;
import com.fhlb.commons.beans.DigitalSignatureBean;
import com.fhlb.commons.beans.ReportFileType;
import com.fhlb.commons.utils.CSVGenerator;
import com.fhlb.commons.utils.PDFGenerator;
import com.fhlb.commons.utils.XLSGenerator;

@Component
public class ReportGenerator {

	private ClassLoader classLoader = getClass().getClassLoader();

	private final CSVGenerator csvGenerator;
	private final PDFGenerator pdfGenerator;
	private final XLSGenerator xlsGenerator;

	@Autowired
	public ReportGenerator(CSVGenerator csvGenerator, PDFGenerator pdfGenerator, XLSGenerator xlsGenerator) {
		this.csvGenerator = csvGenerator;
		this.pdfGenerator = pdfGenerator;
		this.xlsGenerator = xlsGenerator;
	}

	/***
	 * Retrieve report file
	 *
	 * @param reportData
	 *            list of records to be display in report file
	 * @param exportType
	 *            Export type
	 * @param xslFileName
	 *            XSL File name for PDF report generation
	 * @param reportTitle
	 *            Report title
	 * @param reportHeader
	 *            report data headers
	 * @return report
	 */
	public ReportFileType generateReport(String reportData, String exportType, String xslFileName, String reportTitle,
			Map<String, String> reportHeader, String workBookName) {
		File fhlbLogo;
		HttpHeaders httpHeaders = new HttpHeaders();
		File outputFile = null;
		ReportFileType report;
		JSONArray records;
		JSONObject fileData;

		try {
			if ("pdf".equals(exportType)) {
				File xslFile = new File(classLoader.getResource(xslFileName).toURI());

				fhlbLogo = new File(classLoader.getResource(File.separator + Constants.FHLB_LOGO_PATH).toURI());
				DigitalSignatureBean signatureBean = new DigitalSignatureBean();
				signatureBean.setFileName(Constants.FILE_NAME);
				signatureBean.setReportTitle(reportTitle);

				outputFile = pdfGenerator.createPDF(reportData,

						xslFile, fhlbLogo.getAbsolutePath(), Constants.REPORT_PROPERTY_FILE, null, signatureBean);

				httpHeaders.setContentType(MediaType.APPLICATION_PDF);

				if (outputFile == null) {
					throw new RuntimeException("Error in generating pdf report.");
				} else {
					httpHeaders.setContentDispositionFormData(Constants.FILE, outputFile.getName());
				}
			} else if ("xls".equals(exportType)) {
				fileData = new JSONObject(reportData);
				records = fileData.getJSONArray(fileData.keys().next());
				outputFile = xlsGenerator.createExcel(records, reportHeader, Constants.REPORT_PROPERTY_FILE,
						Constants.FILE_NAME, workBookName);

				httpHeaders.setContentType(MediaType.parseMediaType(Constants.MEDIA_TYPE_XLS));

				if (outputFile == null) {
					throw new RuntimeException("Error in generating xls report");
				} else {
					httpHeaders.setContentDispositionFormData(Constants.FILE, outputFile.getName());
				}
			} else if ("csv".equals(exportType)) {
				fileData = new JSONObject(reportData);
				records = fileData.getJSONArray(fileData.keys().next());
				outputFile = csvGenerator.createCSV(records, reportHeader, Constants.REPORT_PROPERTY_FILE,
						Constants.FILE_NAME);

				httpHeaders.setContentType(MediaType.parseMediaType(Constants.MEDIA_TYPE_CSV));

				if (outputFile == null) {
					throw new RuntimeException("Error in generating csv report");
				} else {
					httpHeaders.setContentDispositionFormData(Constants.FILE, outputFile.getName());
				}
			}

			report = new ReportFileType();
			report.setHttpHeader(httpHeaders);
			report.setReportFile(outputFile);

			return report;
		} catch (URISyntaxException | IOException | CustomException e) {
			throw new RuntimeException("Error while generating report file.", e);
		}
	}
}
