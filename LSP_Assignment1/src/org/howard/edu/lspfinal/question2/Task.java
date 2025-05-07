package org.howard.edu.lspfinal.question2;

public class Task{
	String name;
	String status;
	int priority;
	
	public Task(String taskName, String status, int priority) {
		this.name = taskName;
		this.status = status; 
		this.priority = priority;
	}
	public String getStatus() {
        return status;
    }
	public void setStatus(String status) {
		this.status = status;
    }

    @Override
    
    public String toString() {
    	return "Task{name='"+this.name+"', priority="+this.priority+", status='"+this.status+"'}";
    	
    }
}
