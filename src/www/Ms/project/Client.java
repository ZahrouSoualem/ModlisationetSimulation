package www.Ms.project;

public class Client {
protected double tempArrivee;
protected double dureeService;
public static int indexClient = 0 ;
public int index;
public Client(double tempArrivee,double dureeService) {
	this.dureeService=dureeService;
	this.tempArrivee=tempArrivee;
	index = indexClient++;
}
public double getArrive() {
	return tempArrivee;
}
public double getService() {
	return dureeService;
}
public int index() {
	return index;
}
}
