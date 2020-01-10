package pattern;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import main.Persona;
import main.Varco;
import main.Veicolo;

public class Multa {
	@SuppressWarnings("deprecation")
	public Multa(Persona p, Veicolo veicolo, Varco varco) throws IOException {
		long numero = Contatore_multa.getInstance().numero;
		File file = new File("C:\\Users\\lillo\\Documents\\template.pdf");		
		PDDocument document = PDDocument.load(file);
		PDPage page=document.getPage(0);
		PDPageContentStream stream=new PDPageContentStream(document, page, AppendMode.APPEND,true);
		stream.beginText();
		stream.newLineAtOffset(465, 765);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.showText(""+numero);		
		stream.endText();
		stream.beginText();
		stream.newLineAtOffset(230, 680);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		stream.showText(p.toString());		
		stream.endText();
		stream.beginText();
		stream.newLineAtOffset(112, 647);
		stream.setFont(PDType1Font.TIMES_ROMAN, 16);
		Date oggi=new Date();
		String data=""+oggi.getDate()+"   "+(oggi.getMonth()+1)+"   "+(""+oggi.getYear()).substring(1);
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
		stream.showText(veicolo.toString().toUpperCase());		
		stream.endText();
		
		stream.close();
		document.save("D:\\Users\\lillo\\Desktop\\multa_"+p.getNome()+"_"+p.getCognome()+"_"+oggi.getDate()+"_"+(oggi.getMonth()+1)+"_"+(""+oggi.getYear()).substring(1)+".pdf");
		System.out.println("PDF creato ");
		document.close();
	}
}