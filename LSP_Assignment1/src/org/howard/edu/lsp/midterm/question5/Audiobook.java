package org.howard.edu.lsp.midterm.question5;

public class Audiobook extends Streamable{
	
	public Audiobook(String mediaName) {
		this.title = mediaName; 
	}
	
	@Override
	public void play() {
		System.out.println("Playing audiobook: "+ this.title);
	};
	
	@Override
	public void pause() {
		System.out.println("Paused audiobook: "+ this.title);
	};
	
	@Override
	public void stop() {
		System.out.println("Stopped audiobook: "+ this.title);
	};

	public void setPlaybackSpeed(double speed) {
		System.out.println("Setting playback speed of audiobook: " + this.title + " " + speed);
	}

}
