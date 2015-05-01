package Interface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import services.AgendaService;
import services.IntervenantService;
import services.NatureevenementService;
import services.PiecejoinService;
import services.ProspectService;
import services.StatutService;
import DAO.Agenda;
import DAO.Intervenant;
import DAO.Natureevenement;
import DAO.Piecejoin;
import DAO.Prospect;
import DAO.Statut;
@ManagedBean(name="AgendaBean")
@SessionScoped
public class AgendaBean {
	private Integer id;
	private Natureevenement natureevenement;
	private static Intervenant intervenant=new Intervenant();
	private Piecejoin piecejoin;
	private Statut statut;
	private static Prospect prospect=new Prospect();
	private Date dateHeuredebut;
	private Date dateHeureFin;
	private String lieu;
	private static SessionBean sessionBean=new SessionBean();
	private Prospect selectedProspect;
	private static boolean piecejoinevenement;
	
	private static Agenda selectedAgenda;
	private static Agenda agenda;
	private static AgendaService agendaservice=new AgendaService();
	private static List<Agenda> list=new ArrayList<Agenda>();
	private static List<Agenda> tmplist=new ArrayList<Agenda>();
	private static List<Agenda> tmp=new ArrayList<Agenda>();
	private static List<Agenda> filteredAgenda;
	private static List<Agenda> IntervenantList=new ArrayList<Agenda>();;
	private static List<String> listdate=new ArrayList<String>();
	public List<String> getListdate() {
		return listdate;
	}
	public void setListdate(List<String> listdate) {
		AgendaBean.listdate = listdate;
	}


	private List<Natureevenement> listNE;
	private List<Prospect> listProspect;
	private List<Intervenant> listIntervenant;
	private List<Statut> listStatut;
	private List<Piecejoin> listPiecejoin;
	
	private ArrayList<String> listeNEString=new ArrayList<String>();
	private NatureevenementService NES=new NatureevenementService();
	private String resultNE;
	
	private ArrayList<String> listeProspectString=new ArrayList<String>();
	private ProspectService prospectService=new ProspectService();
	private String resultProspect;
	
	private ArrayList<String> listeIntervenantString=new ArrayList<String>();
	private IntervenantService intervenantService=new IntervenantService();
	private String resulIntervenant;
	
	private ArrayList<String> listeStatutString=new ArrayList<String>();
	private StatutService statutService=new StatutService();
	private String resultStatut;
	
	private ArrayList<String> listePiecejoinString=new ArrayList<String>();
	private PiecejoinService piecejoinService=new PiecejoinService();
	private String resultPiecejoin;
	
	private String erreur=null;
	
	private static boolean ajouter;
	private static  boolean modifier;
	private boolean inter=false;
	private static PiecejoinBean piecejoinbean=new PiecejoinBean();
	 private ScheduleModel eventModel;  
     
	    private ScheduleModel lazyEventModel;  
	  
	    private ScheduleEvent event = new DefaultScheduleEvent();  
	      
	    private String theme; 
	public AgendaBean() {

		
	}
	public Intervenant getIntervenant() {
		return intervenant;
	}
	public void setIntervenant(Intervenant intervenant) {
		AgendaBean.intervenant = intervenant;
		
	}
	public Prospect getSelectedProspect() {
		return selectedProspect;
	}
	public void setSelectedProspect(Prospect selectedProspect) {
		this.selectedProspect = selectedProspect;
	}
	public Piecejoin getPiecejoin() {
		return piecejoin;
	}
	public void setPiecejoin(Piecejoin piecejoin) {
		this.piecejoin = piecejoin;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public Prospect getProspect() {
		return prospect;
	}
	public void setProspect(Prospect prospect) {
		AgendaBean.prospect = prospect;
	}

	public Date getDateHeuredebut() {
		return dateHeuredebut;
	}
	public void setDateHeuredebut(Date dateHeuredebut) {
		this.dateHeuredebut = dateHeuredebut;
	}
	public Date getDateHeureFin() {
		return dateHeureFin;
	}
	public void setDateHeureFin(Date dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Agenda getSelectedAgenda() {
		return selectedAgenda;
	}
	public void setSelectedAgenda(Agenda selectedAgenda) {
		AgendaBean.selectedAgenda = selectedAgenda;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	public void setAgenda(Agenda agenda) {
		AgendaBean.agenda = agenda;
	}
	public AgendaService getAgendaservice() {
		return agendaservice;
	}
	public void setAgendaservice(AgendaService agendaservice) {
		AgendaBean.agendaservice = agendaservice;
	}
	public boolean isPiecejoinevenement() {
		return piecejoinevenement;
	}
	public  void setPiecejoinevenement(boolean piecejoinevenement) {
		AgendaBean.piecejoinevenement = piecejoinevenement;
	}
	public List<Agenda> getFilteredAgenda() {
		return filteredAgenda;
	}
	public void setFilteredAgenda(List<Agenda> filteredAgenda) {
		AgendaBean.filteredAgenda = filteredAgenda;
	}
public Natureevenement getNatureevenement() {
		return natureevenement;
	}
	public void setNatureevenement(Natureevenement natureevenement) {
		this.natureevenement = natureevenement;
	}
public ArrayList<String> getListeProspectString() {
		return listeProspectString;
	}
	public void setListeProspectString(ArrayList<String> listeProspectString) {
		this.listeProspectString = listeProspectString;
	}
	public ProspectService getProspectService() {
		return prospectService;
	}
	public void setProspectService(ProspectService prospectService) {
		this.prospectService = prospectService;
	}
	public ArrayList<String> getListeIntervenantString() {
		return listeIntervenantString;
	}
	public void setListeIntervenantString(ArrayList<String> listeIntervenantString) {
		this.listeIntervenantString = listeIntervenantString;
	}
	public IntervenantService getIntervenantService() {
		return intervenantService;
	}
	public void setIntervenantService(IntervenantService intervenantService) {
		this.intervenantService = intervenantService;
	}
	public ArrayList<String> getListeStatutString() {
		return listeStatutString;
	}
	public void setListeStatutString(ArrayList<String> listeStatutString) {
		this.listeStatutString = listeStatutString;
	}
	public StatutService getStatutService() {
		return statutService;
	}
	public void setStatutService(StatutService statutService) {
		this.statutService = statutService;
	}
	public ArrayList<String> getListePiecejoinString() {
		return listePiecejoinString;
	}
	public void setListePiecejoinString(ArrayList<String> listePiecejoinString) {
		this.listePiecejoinString = listePiecejoinString;
	}
	public PiecejoinService getPiecejoinService() {
		return piecejoinService;
	}
	public void setPiecejoinService(PiecejoinService piecejoinService) {
		this.piecejoinService = piecejoinService;
	}
public List<Natureevenement> getListNE() {
		return listNE;
	}
	public void setListNE(List<Natureevenement> listNE) {
		this.listNE = listNE;
	}
public ArrayList<String> getListeNEString() {
		return listeNEString;
	}
	public void setListeNEString(ArrayList<String> listeNEString) {
		this.listeNEString = listeNEString;
	}
	public NatureevenementService getNES() {
		return NES;
	}
	public void setNES(NatureevenementService nES) {
		NES = nES;
	}
	public List<Prospect> getListProspect() {
		return listProspect;
	}
	public void setListProspect(List<Prospect> listProspect) {
		this.listProspect = listProspect;
	}
	public List<Intervenant> getListIntervenant() {
		return listIntervenant;
	}
	public void setListIntervenant(List<Intervenant> listIntervenant) {
		this.listIntervenant = listIntervenant;
	}
	public List<Statut> getListStatut() {
		return listStatut;
	}
	public void setListStatut(List<Statut> listStatut) {
		this.listStatut = listStatut;
	}
	public List<Piecejoin> getListPiecejoin() {
		return listPiecejoin;
	}
	public void setListPiecejoin(List<Piecejoin> listPiecejoin) {
		this.listPiecejoin = listPiecejoin;
	}
public String getResultNE() {
		return resultNE;
	}
	public void setResultNE(String resultNE) {
		this.resultNE = resultNE;
	}
	public String getResultProspect() {
		return resultProspect;
	}
	public void setResultProspect(String resultProspect) {
		this.resultProspect = resultProspect;
	}
	public String getResulIntervenant() {
		return resulIntervenant;
	}
	public void setResulIntervenant(String resulIntervenant) {
		this.resulIntervenant = resulIntervenant;
		inter=true;
	}
	public String getResultStatut() {
		return resultStatut;
	}
	public void setResultStatut(String resultStatut) {
		this.resultStatut = resultStatut;
	}
	public String getResultPiecejoin() {
		return resultPiecejoin;
	}
	public void setResultPiecejoin(String resultPiecejoin) {
		this.resultPiecejoin = resultPiecejoin;
	}
public List<Agenda> getList() {
		return list;
	}
	public void setList(List<Agenda> list) {
		AgendaBean.list = list;
	}
public String getErreur() {
		return erreur;
	}
	public void setErreur(String erreur) {
		this.erreur = erreur;
	}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
public List<Agenda> getTmplist() {
		return tmplist;
	}
	public static void setTmplist(List<Agenda> tmplist) {
		AgendaBean.tmplist = tmplist;
	}
public static List<Agenda> getTmp() {
		return tmp;
	}
	public void setTmp(List<Agenda> tmp) {
		AgendaBean.tmp = tmp;
	}
public boolean isAjouter() {
		return ajouter;
	}
	public void setAjouter(boolean ajouter) {
		AgendaBean.ajouter = ajouter;
	}
	public boolean isModifier() {
		return modifier;
	}
	public void setModifier(boolean modifier) {
		AgendaBean.modifier = modifier;
	}
public PiecejoinBean getPiecejoinbean() {
		return piecejoinbean;
	}
	public void setPiecejoinbean(PiecejoinBean piecejoinbean) {
		AgendaBean.piecejoinbean = piecejoinbean;
	}
public boolean isInter() {
		return inter;
	}
	public void setInter(boolean inter) {
		this.inter = inter;
	}
public List<Agenda> getIntervenantList() {
		return IntervenantList;
	}
	public void setIntervenantList(List<Agenda> intervenantList) {
		AgendaBean.IntervenantList = intervenantList;
	}
public ScheduleModel getEventModel() {
		return eventModel;
	}
	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}
	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}
	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}
	public ScheduleEvent getEvent() {
		return event;
	}
	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
public SessionBean getSessionBean() {
		return sessionBean;
	}
	public void setSessionBean(SessionBean sessionBean) {
		AgendaBean.sessionBean = sessionBean;
	}
public String AjouterAgenda()
{
	setResultStatut(null);
	setResulIntervenant(null);
	setResultNE(null);
	setResultProspect(null);
	setLieu(null);
	setDateHeureFin(null);
	setDateHeuredebut(null);
	setAjouter(true);
	setModifier(false);
	
	listNE=NES.AfficherNatureevenements();
	listProspect=prospectService.AfficherProspects();
	listIntervenant=intervenantService.AfficherIntervenants();
	listStatut=statutService.AfficherStatuts();
	detruireList();
	InitialiserList();
	try{
	list.removeAll(getList());
	piecejoinbean.getTmplist().removeAll(piecejoinbean.getTmplist());
	piecejoinbean.getList().removeAll(piecejoinbean.getList());
	setPiecejoinevenement(true);
	piecejoinevenement=true;
	}catch(Exception e){e.printStackTrace();}
	System.out.print(prospect);
	IntervenantChanged(null);
	
	return "AjouterAgenda";
}
public String AppliquerAjouterAgenda() {
	ChargerList();
	setAjouter(true);
	setModifier(false);
		Agenda p=new Agenda(getIntervenant(),getNatureevenement(),getStatut(),getProspect(),getDateHeuredebut(),getLieu(),getDateHeureFin(),null);
		
		agendaservice.AjouterAgenda(p);
		piecejoinbean.setAgenda(agenda);
		piecejoinbean.AppliquerAjouterPiecejoin();
		AfficherAgendas(getProspect());
		piecejoinbean.AppliquerSupprimerPiecejoin();
		setAjouter(true);
		setModifier(false);
		setResultStatut(null);
		setResulIntervenant(null);
		setResultNE(null);
		setResultProspect(null);
		setLieu(null);
		setDateHeuredebut(null);
			return null;
		}
public String AppliquerAjouterAgendaQuitter() {
	setAjouter(true);
	setModifier(false);
	ChargerList();
	Agenda p=new Agenda(getIntervenant(),getNatureevenement(),getStatut(),getProspect(),getDateHeuredebut(),getLieu(),getDateHeureFin(),null);
	
	agendaservice.AjouterAgenda(p);
	AfficherAgendas(getProspect());
	piecejoinbean.setAgenda(agenda);
	piecejoinbean.AppliquerAjouterPiecejoin();
	piecejoinbean.AppliquerSupprimerPiecejoin();
		return "GestionProspect";
	}

public String ModifierAgenda(Agenda a)
{		setModifier(true);
setAjouter(false);
	agenda = a;
setResultStatut(null);
setResulIntervenant(null);
setResultNE(null);
setResultProspect(null);
setLieu(null);
setDateHeuredebut(null);
setDateHeureFin(null);
setPiecejoinevenement(true);
piecejoinevenement=true;
dateHeuredebut=a.getDateHeuredebut();
dateHeureFin=a.getDateHeureFin();
piecejoinbean.AfficherPiecejoinAgenda(agenda);
listNE=NES.AfficherNatureevenements();
listProspect=prospectService.AfficherProspects();
listIntervenant=intervenantService.AfficherIntervenants();
listStatut=statutService.AfficherStatuts();
detruireList();
InitialiserList();
		setResultStatut(agenda.getStatut().getDenomination());
		setResultNE(agenda.getNatureevenement().getLibelle());
		setResultProspect(agenda.getProspect().getRaisonsociale());
		setLieu(a.getLieu());
		setResulIntervenant(agenda.getIntervenant().getNom()+" "+agenda.getIntervenant().getPrenom());
		
		IntervenantChanged(null);
		
		return "AjouterAgenda";
}


	public String AppliquerModifierAgenda()
	{
		setModifier(true);
		setAjouter(false);
		ChargerList();
		agenda.setIntervenant(getIntervenant());
		agenda.setStatut(getStatut());
		agenda.setNatureevenement(getNatureevenement());
		agenda.setProspect(prospect);
		agenda.setLieu(getLieu());
		agenda.setDateHeuredebut(getDateHeuredebut());
		agenda.setDateHeureFin(getDateHeureFin());
		piecejoinbean.setAgenda(agenda);
		
		piecejoinbean.AppliquerAjouterPiecejoin();
		piecejoinbean.setProspect(null);
		piecejoinbean.AppliquerSupprimerPiecejoin();
		
		agendaservice.ModifierAgenda(agenda);
		
		return"GestionProspect";
	}
	public String AfficherAgendas(Prospect pr)
	{
		tmp.removeAll(getTmp());
		prospect =pr;
		list.removeAll(list);
		tmplist=agendaservice.AfficherAgendas();
		for(int i=0;i<tmplist.size();i++)
		{
			if(pr.getIdProspect()==tmplist.get(i).getProspect().getIdProspect())
			{
				list.add(tmplist.get(i)); 
			}
		}
		
		if(sessionBean.isAdmin()==false)
		{
			tmp.addAll(list);
			list.removeAll(list);
			try{
			 intervenant=recupererIntervenant();
				for(int i=0;i<tmp.size();i++)
				{
					if(intervenant.getIdIntervenant()==tmp.get(i).getIntervenant().getIdIntervenant())
					{
						System.out.print("toto");
						list.add(tmp.get(i));
					}
				}
			}catch(Exception e ){e.printStackTrace();}
		}
//		list=tmplist;
			return "list";
	}
	public void IntervenantChanged(final AjaxBehaviorEvent event)
	{
		inter=true;
		try{
		listdate.removeAll(getListdate());
		eventModel = new DefaultScheduleModel(); 
		eventModel.clear();
		eventModel.deleteEvent(getEvent());
		}catch(Exception e){e.printStackTrace();}
		try{
		IntervenantList.removeAll(getIntervenantList());

		}catch(Exception e){e.printStackTrace();}
		List<Agenda> tmp=agendaservice.AfficherAgendas();
		
		if(sessionBean.isAdmin()){	
			
		for(int i=0;i<tmp.size();i++)
		{
			System.out.print("bobo");
			if((tmp.get(i).getIntervenant().getNom()+" "+tmp.get(i).getIntervenant().getPrenom()).equals(resulIntervenant)) IntervenantList.add(tmp.get(i));
		}
		}else{
			for(int i=0;i<tmp.size();i++)
			{
				System.out.print("nono");
				if((tmp.get(i).getIntervenant().getNom()+" "+tmp.get(i).getIntervenant().getPrenom()).equals(intervenant.getNom()+" "+intervenant.getPrenom())) IntervenantList.add(tmp.get(i));
			}
		}
		for(int i =0;i<IntervenantList.size();i++)
		{
			DefaultScheduleEvent event1 =new DefaultScheduleEvent(IntervenantList.get(i).getNatureevenement().getLibelle(), IntervenantList.get(i).getDateHeuredebut(), IntervenantList.get(i).getDateHeureFin(),IntervenantList.get(i).getNatureevenement().getLibelle());
			event1.setData(IntervenantList.get(i));
			eventModel.addEvent(event1);
	        
		}
		
		
	}
	
	
	public static String AfficherAgendasInt(Intervenant pr)
	{
		tmp.removeAll(getTmp());
		intervenant =pr;
		tmplist=agendaservice.AfficherAgendas();
		try {
			for(int i=0;i<tmplist.size();i++)
			{
				if(intervenant.getIdIntervenant()==tmplist.get(i).getIntervenant().getIdIntervenant())
				{ tmp.add(tmplist.get(i)); }
			}
			list=tmp;
		}catch(Exception e ){e.printStackTrace();}
//		list=tmplist;
			return "list";
	}
	
	public void detruireList()
	{
		listeNEString.removeAll(getListeNEString());
		listeProspectString.removeAll(listeProspectString);
		listeStatutString.removeAll(listeStatutString);
		listeIntervenantString.removeAll(listeIntervenantString);
	}
	public void ChargerList()
	{
		try{
			if(sessionBean.isAdmin()==true){
				System.out.print("admin");
		for(int i=0;i<listIntervenant.size();i++)
		{
			if(resulIntervenant.equals((listIntervenant.get(i).getNom())+" "+listIntervenant.get(i).getPrenom())) intervenant=listIntervenant.get(i);
		}
			}
			else{
				System.out.print("machiadmin");
				for(int i=0;i<listIntervenant.size();i++)
				{
					String S=listIntervenant.get(i).getPrenom().charAt(0)+"."+listIntervenant.get(i).getNom();
					S=S.toUpperCase();
					S=S.replaceAll("\\s", "");
					System.out.print(sessionBean.getNom()+"+"+S);
					if(sessionBean.getNom().equals(S)){intervenant=listIntervenant.get(i);System.out.print("kani");}
				}
			}
		for(int i=0;i<listNE.size();i++)
		{
			if(resultNE.equals(listNE.get(i).getLibelle())) natureevenement=listNE.get(i);
		}
		for(int i=0;i<listStatut.size();i++)
		{
			if(resultStatut.equals(listStatut.get(i).getDenomination())) statut=listStatut.get(i);
		}
	}catch(Exception e ){e.printStackTrace();}
		
	}
	public void InitialiserList()
	{
		for(int i=0;i<listNE.size();i++)
		{
			String tmp=(String)listNE.get(i).getLibelle();
			listeNEString.add(tmp);
		}
		for(int i=0;i<listProspect.size();i++)
		{
			String tmp=(String)listProspect.get(i).getRaisonsociale();
			listeProspectString.add(tmp);
		}
		for(int i=0;i<listStatut.size();i++)
		{
			String tmp=(String)listStatut.get(i).getDenomination();
			if(listStatut.get(i).getStatutevenement()==true)listeStatutString.add(tmp);
		}
		for(int i=0;i<listIntervenant.size();i++)
		{
			String tmp=listIntervenant.get(i).getNom()+" "+listIntervenant.get(i).getPrenom();
			System.out.print(tmp+"toto");
			listeIntervenantString.add(tmp);
		}
		if(sessionBean.isAdmin()==false)
		{
			for(int i=0;i<listIntervenant.size();i++)
			{
				String S=listIntervenant.get(i).getPrenom().charAt(0)+"."+listIntervenant.get(i).getNom();
				S=S.toUpperCase();
				String T=S.replaceAll("\\s+", "");
				System.out.print(sessionBean.getNom()+"+"+T);
				if(sessionBean.getNom().equals(T)){intervenant=listIntervenant.get(i);System.out.print("kani");}
			}
		}
	}
	public Intervenant recupererIntervenant()
	{
		try{
		listIntervenant.removeAll(listIntervenant);
		}catch(Exception e){e.printStackTrace();}
		listIntervenant=intervenantService.AfficherIntervenants();
		for(int i=0;i<listIntervenant.size();i++)
		{
			System.out.print(listIntervenant.size());
			String S=listIntervenant.get(i).getPrenom().charAt(0)+"."+listIntervenant.get(i).getNom();
			S=S.toUpperCase();
			System.out.println(S);
			String T=S.replaceAll("\\s+", "");
			System.out.println(T);
			System.out.println(sessionBean.getNom()+"+"+T);
			if(sessionBean.getNom().equals(T))
			{
				intervenant=listIntervenant.get(i);
				System.out.print("kani");
			}
		}
		return intervenant;
	}
	public Date RecupererDateSysteme()
	{
		Calendar c = Calendar.getInstance ();
		setDateHeuredebut(c.getTime ());
		return dateHeuredebut;
	}
	public void onRowSelect(SelectEvent se)
	{
		agenda=selectedAgenda;	
	}
	public void viderlist()
	{
		list.removeAll(list);
		listIntervenant.removeAll(listIntervenant);
		
	}
	
	public void addEvent(ActionEvent actionEvent) {  
        if(event.getId() == null)  
            eventModel.addEvent(event);  
        else  
            eventModel.updateEvent(event);  
          
        event = new DefaultScheduleEvent();  
    }  
      
	public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
    }
      
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
         
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public static void main(String [] args)
	{
//		AgendaBean as=new AgendaBean();
//		Calendar c = Calendar.getInstance ();
//		Date date = c.getTime ();
//		Intervenant i=new Intervenant("zakaria","zaza","0987654","sdfdfdf",null);
//		i.setIdIntervenant(1);
//		Natureevenement n=new Natureevenement("Rendez vous");
//		n.setIdevenement(1);
//		Prospect p=new Prospect();
//		p.setIdProspect(1);
//		Agenda u=new Agenda(date,i,n,p,120);
//		uDAO.Add(u);
//		as.AfficherAgendas();
//		Agenda a=(Agenda) list.get(1);		
//		System.out.println(a.getLieu());
	}
}
