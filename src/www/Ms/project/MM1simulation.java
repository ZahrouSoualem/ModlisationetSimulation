package www.Ms.project;

public class MM1simulation {
	double lumbda; 
	double mu;
	public ListeEvent list;
	public Queue q;
	double ST,S,t=0;
	Client cl;
	public MM1simulation(double lumbda , double mu) {
		this.lumbda= lumbda;
		this.mu=mu;
		q= new Queue();
		list=new ListeEvent();
	}
public double expo (double taux) {
	return -Math.log(Math.random())/taux;
}
public void simulate(int simLength) {
	int n=0;
	System.out.println("Idx  | Temps arrivee  |  Duree Service | Service Commence | Service Termine  |");
	while(n<simLength) {
		S=expo(mu);
		cl = new Client(t,S);
		t=t+expo(lumbda);
		q.addClient(cl); // add client to the queue
        n++;
        
	}// so every client is in the queue
	
	while (!q.LesClients.isEmpty()) {// list of clients
		//System.out.println("try try try ");
		if (list.events.isEmpty()) {// list of events 

			Event EventArrive = new Event(0, q.getTempsArriveeFirst());
			list.addEvent(EventArrive);
			
			
			Event Eventdepart = new Event(1, q.getTempsArriveeFirst() + q.getDureeServiceFirst());
			list.addEvent(Eventdepart);
			/*System.out.println(q.Clientindex()+"    | "
                    +q.getTempsArriveeFirst()+"               | "+q.getDureeServiceFirst()+" | "+q.getTempsArriveeFirst()+"               | "
                    +(q.getTempsArriveeFirst()+q.getDureeServiceFirst())+" | ");*/
			
			System.out.println(q.Clientindex()+"\t"
                    +String.format("%.7g",q.getTempsArriveeFirst())+"\t"+String.format("%.7g",q.getDureeServiceFirst())+"\t"+String.format("%.7g",q.getTempsArriveeFirst())+"\t   "
                    +String.format("%.7g",(q.getTempsArriveeFirst()+q.getDureeServiceFirst())));
			ST = q.getTempsArriveeFirst()+q.getDureeServiceFirst();
		//	System.out.println(ST);
		} else {
			    Event arrived = new Event(0, list.lastInListeEvent());
	            list.addEvent(arrived);
	            
	           /* Event departed = new Event(1, list.lastInListeEvent()+q.getDureeServiceFirst());*/
	           if(ST<q.getTempsArriveeFirst()) {
	        	   Event departed = new Event(1, q.getTempsArriveeFirst()+q.getDureeServiceFirst());
	        	   list.addEvent(departed);
	        	   System.out.println(q.Clientindex()+"\t"
	                        +String.format("%.7g",q.getTempsArriveeFirst())+"\t"+String.format("%.7g",q.getDureeServiceFirst())+"\t"+String.format("%.7g",q.getTempsArriveeFirst())+"\t   "
	                        +String.format("%.7g",(q.getTempsArriveeFirst())+q.getDureeServiceFirst()));
	        	 ST=q.getTempsArriveeFirst()+q.getDureeServiceFirst();
	            }else {
	            	Event departed = new Event(1, ST+q.getDureeServiceFirst());
		        	   list.addEvent(departed);
		        	   System.out.println(q.Clientindex()+"\t"
		                        +String.format("%.7g",q.getTempsArriveeFirst())+"\t"+String.format("%.7g",q.getDureeServiceFirst())+"\t"+String.format("%.7g",ST)+"\t   "
		                        +String.format("%.7g",ST+q.getDureeServiceFirst()));
		        	   ST=ST+q.getDureeServiceFirst();
		        	 // System.out.println(ST);
	            }
	            
	           /* System.out.println(q.Clientindex()+"    | "
                        +q.getTempsArriveeFirst()+" | "+q.getDureeServiceFirst()+" | "+list.lastInListeEvent()+" | "
                        +(list.lastInListeEvent() + q.getDureeServiceFirst())+" | ");*/
	           /* System.out.println(q.Clientindex()+"\t"
                        +String.format("%.7g",q.getTempsArriveeFirst())+"\t"+String.format("%.7g",q.getDureeServiceFirst())+"\t"+String.format("%.7g",list.lastInListeEvent())+"\t   "
                        +String.format("%.7g",(list.lastInListeEvent()+q.getDureeServiceFirst())));*/
		}
		
		q.DeletClient();
		
	}
}
           
            
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		MM1simulation s = new MM1simulation(0.5,1);
		s.simulate(10);
	}

}
/*while(!liste.events.isEmpty()){
    if(tempsserviceprec+tempsarvprec<q.getTempsArriveeFirst()){
    liste.events.remove(0);
}
    else{
        break;
    }
}
tempsserviceprec=q.getDureeServiceFirst();
tempsarvprec=q.getTempsArriveeFirst();*/
