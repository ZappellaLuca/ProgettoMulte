package pattern;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import it.jac.javadb.esercitazione.entity.Multe;
import it.jac.javadb.esercitazione.service.MulteService;

public class Multa {
	@SuppressWarnings("deprecation")
	public Multa(String nome, String cognome, String targa, int idvarco, String varco) throws IOException {
		long numero = Contatore_multa.getInstance().numero;
		MulteService service = new MulteService();
		File file = new File(System.getProperty("user.dir") + "/template.pdf");
		PDDocument document = PDDocument.load(file);
		PDPage page = document.getPage(0);
		PDPageContentStream stream = new PDPageContentStream(document, page, AppendMode.APPEND, true);
		stream.beginText();
		stream.newLineAtOffset(465, 765);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.showText("" + numero);
		stream.endText();
		stream.beginText();
		stream.newLineAtOffset(230, 680);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.showText(nome.toUpperCase() + " " + cognome.toUpperCase());
		stream.endText();
		stream.beginText();
		stream.newLineAtOffset(112, 647);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		Date oggi = new Date();
		String data = "" + oggi.getDate() + "   " + (oggi.getMonth() + 1) + "   " + ("" + oggi.getYear()).substring(1);
		stream.showText(data);
		stream.endText();
		stream.beginText();
		stream.newLineAtOffset(312, 647);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.showText(varco.toString());
		stream.endText();
		stream.beginText();
		stream.newLineAtOffset(292, 617);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.showText(targa.toUpperCase());
		stream.endText();
		stream.close();
		new File(System.getProperty("user.home") + "/Desktop/multe").mkdir();
		document.save(System.getProperty("user.home") + "/Desktop/multa_" + numero + "_" + nome + "_" + cognome + "_"
				+ oggi.getDate() + "_" + (oggi.getMonth() + 1) + "_" + ("" + oggi.getYear()).substring(1) + ".pdf");
		System.out.println("PDF creato ");
		document.close();

		Multe multa = new Multe();
		multa.setNome(nome);
		multa.setCognome(cognome);
		multa.setTarga(targa);
		multa.setIdVarco(idvarco);

		service.creaDocumento(multa);

	}
}