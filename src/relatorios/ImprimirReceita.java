package relatorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ImprimirReceita {
    
    public void ImprimirRelatorio(List lista){        
        try{
            
            Map param = new HashMap();
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(lista);
            JasperDesign jdesign = JRXmlLoader.load("C:\\Users\\Vinnen\\Documents\\NetBeansProjects\\ProjetoConsultorio\\src\\relatorios\\relatorio_receita.jrxml");
            JasperReport jreport = JasperCompileManager.compileReport(jdesign);
            JasperPrint jpPrint = JasperFillManager.fillReport(jreport, param, ds);
            JasperViewer jv = new JasperViewer(jpPrint,false);
            jv.setVisible(true);
            
        }catch(JRException ex){
            JOptionPane.showMessageDialog(null, "Erro ao imprimir!"+ex.getMessage());
        }
        
    }
    
}
