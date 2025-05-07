package org.howard.edu.lspfinal.question2;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TaskManager {
	
	private HashMap<String, Task> taskMap;
	
	public TaskManager() {
		this.taskMap = new HashMap<String, Task>();
	}
	/**
	 *  This uses a hash map to keep the task information together. the value is a taskInfo class.
	 * @param taskName this is the key value in the map
	 * @param priority this gets saved to a task info class
	 * @param status this also get saved to a task info class.
	 * @throws DuplicateTaskException this is thrown if the taskName is already a key
	 */
	public void addTask(String taskName, int priority, String status) throws DuplicateTaskException{
		//add new task no duplicates
		if (taskMap.containsKey(taskName)) {
			throw new DuplicateTaskException(" Task " + taskName+ " already exists");
		}
		else {
			Task task = new Task(taskName,status, priority);
			taskMap.put(taskName, task);
		};}
	
		/**
		 * This prompted my set up of the hash map since we are required to retrive task by name.
		 * @param taskName this is what we use to access the task
		 * @return this returns a task object which holds the task info. It is preformated within the task class.
		 * @throws TaskNotFoundException this is thrown if the task does not exist in the map
		 */
	public Task getTaskByName(String taskName) throws TaskNotFoundException{
		if (taskMap.containsKey(taskName)) {
			Task task = taskMap.get(taskName);
			return task;
			}
		else {
			 throw new TaskNotFoundException(" Task " + taskName+ " not found");
		}
		
	};
	
	/**
	 * This updates the status in the task object with the setStatus method
	 * @param taskName this is what is used to access the task
	 * @param status there is a check to ensure the status is a valid status to use
	 * @throws TaskNotFoundException if the task does not exist this is thrown
	 */
	public void updateStatus(String taskName, String status) throws TaskNotFoundException{
		if(taskMap.containsKey(taskName)) {
			if (status.equals("TODO")|| status.equals("IN_Progess")|| status.equals("DONE")) {
				taskMap.get(taskName).setStatus(status);
			}
		}
		else {
			throw new TaskNotFoundException(" Task " + taskName+ " not found");
		}
	
		
	};
	
	/**
	 * I used chatGPT to help with this one. It creates a new map that organizes it by status. It itteratis through the task map
	 * then iteraties throw the new map to print out all of the tasks with the status header.
	 */
	
	public void printTasksGroupedByStatus() {
		 HashMap<String, List<String>> grouped = new HashMap<>();
		 
		 for (HashMap.Entry<String, Task> entry : taskMap.entrySet()) {
		        String taskName = entry.getKey();
		        Task task = entry.getValue();
		        String status = task.getStatus();

		        // Step 3: Group tasks by status
		        grouped.putIfAbsent(status, new ArrayList<>());
		        grouped.get(status).add(task.toString());
		    }

		    // Step 4: Print tasks grouped by status
		    for (String status : grouped.keySet()) {
		        System.out.println(status+":");
		        for (String taskDetails : grouped.get(status)) {
		            System.out.println(taskDetails);
		        }
		
	};}
}

