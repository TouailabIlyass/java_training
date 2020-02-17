
package jdom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import static org.jdom2.filter.Filters.document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;



public class Main {
  private String id,mark,nom;

    public Main(String id, String mark, String nom) {
        this.id = id;
        this.mark = mark;
        this.nom = nom;
    }
    public Main()
    {
        
    }
  public static void afficher() throws JDOMException, IOException
  {  
      SAXBuilder sax= new SAXBuilder();
      Document doc=sax.build(new File("Labo.xml"));
      Element racine = doc.getRootElement();
      System.out.println("racine "+racine.toString());
      List l =racine.getChildren();
      Iterator i=l.iterator();
      Element elm = new Element("Objet");
//      while(i.hasNext())
//      {
//           elm=(Element) i.next();
//        System.out.println("id = "+elm.getAttributeValue("id"));
//          System.out.println("test"+elm.getChild("test").getText());
//      }
 TEST t = new TEST();
elm.setAttribute("Nom","ok");
elm.setAttribute("couleur","rouge");
  racine.addContent(elm);
  if(racine.getChild("Objet")!=null)
  {
      System.out.println("jdom.Main.afficher()");
      elm=racine.getChild("Objet");
      t.Nom=elm.getAttributeValue("Nom");
      t.coulour=elm.getAttributeValue("couleur");
      System.out.println("t  "+t);
      
  }
      
      
       
              
     
       XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(doc, new FileOutputStream("Labo.xml"));
      
  }
  
  static void enregistreFichier(String fichier) throws Exception
   {   SAXBuilder sax= new SAXBuilder();
       Document doc=sax.build(new File("Labo.xml"));
       
       
       
         XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
         sortie.output(doc, new FileOutputStream(fichier));
   }
    public static void main(String[] args) throws JDOMException, IOException {
      
       System.out.println("debut");
        afficher();
        System.out.println("fin");
        
       TEST t = new TEST("ok","rouge");
        
    }
    
}
