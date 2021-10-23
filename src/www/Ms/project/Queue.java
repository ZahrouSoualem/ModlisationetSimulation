package www.Ms.project;
import java.util.Vector;
public class Queue {
	Vector LesClients;
	//Client cl;
	public Queue(){
		LesClients = new Vector();
    }
    public void addClient(Client client){
    	LesClients.add(client);
    }
	//Client cl = (Client)LesClients.get(0);
	public double getTempsArriveeFirst() {
		Client cl = (Client)LesClients.get(0);
		return cl.getArrive();
	}
	public double getDureeServiceFirst() {
		Client cl = (Client)LesClients.get(0);
		return cl.getService();
	}
	public int Clientindex() {
		Client cl = (Client)LesClients.get(0);
		return cl.index();
	}
	public void DeletClient() {
		LesClients.remove(0);
	}
	

}
