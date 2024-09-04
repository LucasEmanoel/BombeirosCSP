package main;

public class Pessoa {
	private String name;
	private int servicesQtd;
	private int assignedCount = 0;
	
	Pessoa(){}
	
	Pessoa(String name, int servicesQtd){
		this.name = name;
		this.servicesQtd = servicesQtd;
	}
	
	Pessoa(String name, String servicesQtd){
		this.name = name;
		this.servicesQtd = Integer.parseInt(servicesQtd.strip());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getServicesQtd() {
		return servicesQtd;
	}

	public void setServicesQtd(int servicesQtd) {
		this.servicesQtd = servicesQtd;
	}
	
	 public int getAssignedCount() {
	        return assignedCount;
    }

    public void incrementAssignedCount() {
        this.assignedCount++;
    }

    public void decrementAssignedCount() {
        this.assignedCount--;
    }
}
