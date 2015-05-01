package Interface;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import services.PiecejoinService;
import DAO.Agenda;
import DAO.Piecejoin;
import DAO.Prospect;
@ManagedBean(name="PiecejoinBean")
@SessionScoped
public class PiecejoinBean {
	private Integer idPiecejoin;
	private String denomination;
	
	
	private static Prospect prospect;
	private static Agenda agenda;
	private static ProspectBean prospectBean=new  ProspectBean();
	private static AgendaBean agendaBean=new AgendaBean();
	
	private byte[] pj;
//	private Set agendas = new HashSet(0);
//	private Set prospects = new HashSet(0);
	
	private PiecejoinService piecejoinservice=new PiecejoinService();
	private static List<Piecejoin> list=new ArrayList<Piecejoin>();
	private static List<Piecejoin> tmplist=new ArrayList<Piecejoin>();
	private static List<Piecejoin> supplist=new ArrayList<Piecejoin>();
	private List<Piecejoin> tlist =new ArrayList<Piecejoin>();
	private String erreur;
	
	private Piecejoin piecejoin;
	
	
	private UploadedFile file;
	
	private StreamedContent download;
	
	public PiecejoinBean()
	{
	}
	public UploadedFile getFile() {
        return file;
    }
 
	public Prospect getProspect() {
		return prospect;
	}
	public void setProspect(Prospect prospect) {
		PiecejoinBean.prospect = prospect;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		PiecejoinBean.agenda = agenda;
	}
    public void setFile(UploadedFile file) {
        this.file = file;
    }
	public Integer getIdPiecejoin() {
		return idPiecejoin;
	}
	public void setIdPiecejoin(Integer idPiecejoin) {
		this.idPiecejoin = idPiecejoin;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	
	
	public byte[] getPj() {
		return pj;
	}
	public void setPj(byte[] pj) {
		this.pj = pj;
	}

	public PiecejoinService getPiecejoinservice() {
		return piecejoinservice;
	}

	public void setPiecejoinservice(PiecejoinService piecejoinservice) {
		this.piecejoinservice = piecejoinservice;
	}

	public List<Piecejoin> getList() {
		return list;
	}

	public void setList(List<Piecejoin> list) {
		PiecejoinBean.list = list;
	}

	public String getErreur() {
		return erreur;
	}

	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
	public StreamedContent getDownload() {
		return download;
	}
	public void setDownload(StreamedContent download) {
		this.download = download;
	}
	public List<Piecejoin> getTmplist() {
		return tmplist;
	}
	public void setTmplist(List<Piecejoin> tmplist) {
		PiecejoinBean.tmplist = tmplist;
	}
	public  List<Piecejoin> getSupplist() {
		return supplist;
	}
	public  void setSupplist(List<Piecejoin> supplist) {
		PiecejoinBean.supplist = supplist;
	}
	public static ProspectBean getProspectBean() {
		return prospectBean;
	}
	public static void setProspectBean(ProspectBean prospectBean) {
		PiecejoinBean.prospectBean = prospectBean;
	}
	public static AgendaBean getAgendaBean() {
		return agendaBean;
	}
	public static void setAgendaBean(AgendaBean agendaBean) {
		PiecejoinBean.agendaBean = agendaBean;
	}
	public String upload(ActionEvent event)  { 
		
        String fileName = file.getFileName();
        setDenomination(fileName);
        String fileType= file.getContentType();
        try{
        InputStream inputstream = file.getInputstream(); 
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Zakaria\\Desktop\\tmp\\"+fileName));
        int read = 0;
        int taille=((int) (long)file.getSize())+1;
        byte[] bytes = new byte[taille];
        while ((read = inputstream.read(bytes)) != -1) {
           fos.write(bytes, 0, read);
        }
        fos.close();
//        System.out.print(bytes);
        setPj(bytes);
        // Keep upload file 
        if(prospectBean.isPiecejoinprospect()) piecejoin=new Piecejoin(getProspect(),getAgenda(),getDenomination(),true,false, bytes,fileType);
        else piecejoin=new Piecejoin(getProspect(),getAgenda(),getDenomination(),false,true, bytes,fileType);
        AppliquerAjouterPiecejoinBis();
        }catch(Exception e){e.printStackTrace();}
       FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage("Successful! " + fileName + " is uploaded."));
       
     return null;
	}   
	 public void FileDownload(Piecejoin p) throws IOException {
		 piecejoin=p;
		 InputStream stream = new ByteArrayInputStream(piecejoin.getPj());
		 System.out.println(stream);
	        download = new DefaultStreamedContent(stream,piecejoin.getType(),piecejoin.getDenomination());
	        setDownload(download);
	    }
	 public String Telecharger()
	 {
		 if(agendaBean.isPiecejoinevenement()) return "AjouterAgenda";
		 else if(prospectBean.isPiecejoinprospect()) return "AjouterProspect";
		 else return "GestionProspect";
	 }
	 public String AfficherPiecejoinProspect(Prospect p)
	 {
		 tmplist.removeAll(getTmplist());
		 prospect=p;
		 list.removeAll(getList());
		 tlist.removeAll(tlist);
		 tlist=piecejoinservice.AfficherPiecejoins();
		 for(int i=0;i<tlist.size();i++)
		 {
			 if(tlist.get(i).getProspect()!=null){
			 try{
			 if(tlist.get(i).getProspect().getIdProspect()==prospect.getIdProspect()) list.add(tlist.get(i));
			 }catch(Exception e){e.printStackTrace();}
			 }
		 }
		 tmplist.addAll(list);
		 return null;
	 }
	 public String AfficherPiecejoinAgenda(Agenda a)
	 {
		 supplist.removeAll(getSupplist());
		 tmplist.removeAll(getTmplist());
		 agenda=a;
		 list.removeAll(getList());
		 tlist.removeAll(tlist);
		 tlist=piecejoinservice.AfficherPiecejoins();
		 for(int i=0;i<tlist.size();i++)
		 {
			 if(tlist.get(i).getAgenda()!=null){
			 try{
			 if(tlist.get(i).getAgenda().getId()==agenda.getId()) list.add(tlist.get(i));
			 }catch(Exception e ){e.printStackTrace();}
			 }
		 }
		 tmplist.addAll(list);
		 return null;
	 }
	 public String SupprimerPiecejoin(Piecejoin p)
	 {
		
		 tmplist.remove(p);
		 supplist.add(p);
		 return null;
	 }
	 public String AppliquerSupprimerPiecejoin()
	 {
		 try{
		 for(int i=0;i<supplist.size();i++) piecejoinservice.SupprimerPiecejoin(supplist.get(i).getIdPiecejoin());
				 supplist.removeAll(getSupplist());
		 }catch(Exception e ){e.printStackTrace();}
		 return null;
		 
	 }
	 public String AjouterPiecejoin()
	 {
		 return "Piecejoin";
	 }
	 public String AppliquerAjouterPiecejoin()
	 {
		 tmplist.removeAll(list);
	        for(int i=0;i<tmplist.size();i++)
			{
	        	if(tmplist.get(i).getPiecejoinprospect()==true){
	        	tmplist.get(i).setProspect(prospect);
				piecejoinservice.AjouterPiecejoin(tmplist.get(i));}
	        	else{
	        		tmplist.get(i).setAgenda(agenda);
					piecejoinservice.AjouterPiecejoin(tmplist.get(i));
	        	}
			}
		 return "AjouterProspect";
	 }
	 public String AppliquerAjouterPiecejoinBis()
	 {
		 tmplist.add(getPiecejoin());
		 if(getPiecejoin().getPiecejoinprospect()==true) return "AjouterProspect";
		 else return "AjouterAgenda";
	 }
	public Piecejoin getPiecejoin() {
		return piecejoin;
	}
	public void setPiecejoin(Piecejoin piecejoin) {
		this.piecejoin = piecejoin;
	}
	public List<Piecejoin> getTlist() {
		return tlist;
	}
	public void setTlist(List<Piecejoin> tlist) {
		this.tlist = tlist;
	}
}
