package org.howard.edu.lsp.midterm.question5;

public class Music extends Streamable{
	
	
	public Music(String mediaName) {
		this.title = mediaName; 
	}
	@Override
	void play() {
		System.out.println("Playing music: "+ this.title);
	};
	
	@Override
	void pause() {
		System.out.println("Paused music: "+ this.title);
	};
	
	@Override
	void stop() {
		System.out.println("Stopped music: "+ this.title);
	};
	
	public void addToPlaylist(String playlistName) {
		System.out.println("Added " + this.title + " to " + playlistName + " playlist");
	}

}
