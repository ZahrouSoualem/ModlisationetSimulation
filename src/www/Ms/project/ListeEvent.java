package www.Ms.project;
import java.util.Vector;
public class ListeEvent {

	Vector events;
	
	public ListeEvent() {
		events = new Vector();
	}
	
	public void addEvent(Event newEvent) {
		int insertIndex=0;
		
		while(insertIndex < events.size()) {
			Event e = (Event) events.elementAt(insertIndex);
			if(e.getInstant() > newEvent.getInstant()) {
				break;
			}
			insertIndex++;
		}
		events.insertElementAt(newEvent, insertIndex);
		
	}
	public double lastInListeEvent(){
        Event ev = (Event) events.lastElement();
       return  ev.getInstant();
        
    }
}
