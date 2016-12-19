package controleurs;

import java.io.File;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modeles.ModConnexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import Utils.CtrlPathRapport;
import modeles.ModConnexion;



public class Ctrl_ArriveRapport {
	private static Connection laConnexion = ModConnexion.getInstance().getLaConnectionStatique();

	private static JasperDesign design = null;
	private static JasperReport report = null;
	private static JasperPrint print = null;
	private static String chemin = CtrlPathRapport.getRepertoireCourant()
			+ CtrlPathRapport.getSeparateur()
			+ "src" + CtrlPathRapport.getSeparateur()
			+ "Rapports" + CtrlPathRapport.getSeparateur();

	public static void chargeEtcompile(String rapport, String date1, String date2)
	{
		try
		{
			design = JRXmlLoader.load(chemin	+ rapport);
			
			report = JasperCompileManager.compileReport(design);

			System.out.println("Bloup0");
			HashMap<String, Object> mesParametres = new HashMap<String,Object>();
			mesParametres.put("date1", date1);
			mesParametres.put("date2", date2);

			//Affichage du rapport
			print= JasperFillManager.fillReport(report, mesParametres, laConnexion);
			System.out.println("Bloup1");
			//Pour exporter le rapport en pdf
			JFileChooser save = new JFileChooser();
			save.setSelectedFile(new File("Arrives_" + date1 + "_" + date2 + ".pdf"));
			int retour = save.showSaveDialog(save);
			System.out.println("Bloup2");
			if(retour == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					JasperExportManager.exportReportToPdfFile(print, save.getSelectedFile().getAbsolutePath());
					System.out.println("Bloup3");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Exportation impossible","Erreur",JOptionPane.ERROR_MESSAGE);
				}

			}


		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "La compilation du rapport a échoué : \n"
					+ e.getMessage() + e.getCause()+JOptionPane.ERROR_MESSAGE);
		}
	}


	public static void apercu(String rapport, String date1, String date2)
	{
		chargeEtcompile(rapport, date1, date2);
		try
		{
			JasperViewer.viewReport(print,false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de l'aperçu \n"+e.getMessage()+JOptionPane.ERROR_MESSAGE);
		}
	}

	private static Date convertirChaineEnDateJava(String laDateEnChaine) throws ParseException{
		SimpleDateFormat dsf = new SimpleDateFormat("yyyy-MM-dd");
		return dsf.parse(laDateEnChaine);
	}
}
