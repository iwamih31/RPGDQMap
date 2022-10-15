package iwamih31.RPGwin;

import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {

	private MediaPlayer mediaplayer;

	private String mediaURI;

	public Music(String mediaURI) {

		new JFXPanel(); // Toolkit初期化の為

		this.mediaURI = mediaURI;
		Media media = new Media(new File(mediaURI).toURI().toString());
		mediaplayer = new MediaPlayer( media );
		mediaplayer.setVolume(0.5);
	}

	public void play() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を再生します");
		System.out.println("");////////////////////////

		mediaplayer.play();
	}
	public void playRepeat() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を再生します");
		System.out.println("");////////////////////////

		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaplayer.play();
	}
	public void pause() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を一時停止します");
		System.out.println("");////////////////////////

		mediaplayer.pause();
	}
	public void stop() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を再生します");
		System.out.println("");////////////////////////

		mediaplayer.stop();
	}

}
