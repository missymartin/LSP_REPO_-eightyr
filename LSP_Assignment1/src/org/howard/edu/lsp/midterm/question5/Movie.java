package org.howard.edu.lsp.midterm.question5;

public class Movie extends Streamable{
	
	public Movie(String mediaName) {
		this.title = mediaName; 
	}
	
	@Override
	void play() {
		System.out.println("Playing movie: "+ this.title);
	};
	
	@Override
	void pause() {
		System.out.println("Paused movie: "+ this.title);
	};
	
	@Override
	void stop() {
		System.out.println("Stopped movie: "+ this.title);
	};

	public void rewind(int minutes) {
		System.out.println("Rewinding movie: " + this.title + " by " + minutes + " minutes");
	}

}
