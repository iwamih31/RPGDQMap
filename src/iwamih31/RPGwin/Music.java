package iwamih31.RPGwin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Music {

//	private MediaPlayer mediaplayer;

	private String mediaURI;

	private Clip clip;

	private String JarName;

	public Music(String mediaName) {

		JarName = "RPGDQMap";

		String resourceName = mediaName + ".wav";

//		mediaURI = "src/media/" + mediaName + ".mp3";
//
////		JOptionPane.showMessageDialog(null, "new Music(" + mediaURI + ")	します");
//
//		new JFXPanel(); // Toolkit初期化の為
//
////		JOptionPane.showMessageDialog(null, "new JFXPanel()	しました");
//
//
//		JOptionPane.showMessageDialog(null, "mediaURI = " + mediaURI);
//
//		ClassLoader classLoader = this.getClass().getClassLoader();
//
//		mediaURI = classLoader.getResource(mediaURI).toString();

//		mediaURI = getClass().getResource(entryURI).getPath();


		mediaURI = getFilePath(resourceName);
//

//		mediaURI = ClassLoader.getSystemResource(entryURI).toString();

//		mediaURI = getClass().getResourceAsStream(mediaURI).toString();

		// the input stream object

//		JOptionPane.showMessageDialog(null, "this.URI = " + getFilePath(mediaURI));

//		JOptionPane.showMessageDialog(null, "mediaURI = " + mediaURI);
//
////		メディアファイル作成
////		Media media = new Media(new File(mediaURI).toURI().toString());
//		Media media = new Media(this.mediaURI);
////		JOptionPane.showMessageDialog(null, "new Media(" + this.mediaURI + ")	しました");
//		mediaplayer = new MediaPlayer( media );
////		JOptionPane.showMessageDialog(null, "new MediaPlayer(" + media.toString() + ")	しました");
//		mediaplayer.setVolume(0.5);

//		mediaURI = getFilePath(mediaURI);


		clip = createClip(new File(mediaURI));

//		clip = createClip(entryURI);

		if (clip == null) {
//			JOptionPane.showMessageDialog(null, "createClipJar(" + entryURI +  ") します");
//			clip = createClipJar(entryURI);

			URL resourceURL = this.getClass().getClassLoader().getResource("media/" + resourceName);
//			JOptionPane.showMessageDialog(null, "createClip(" + resourceURL +  ") します");
			clip = createClip(resourceURL);
		}

	}

//	private Clip createClipJar(String entryURI) {
//
//		String  jarUrl = System.getProperty("user.dir") + "/" + JarName + ".jar";
//
//		mediaURI = "jar:"+ jarUrl +"!/media/" + entryURI;
//
//		JOptionPane.showMessageDialog(null, "mediaURI = " + mediaURI);
//
//		File filePath = new File(mediaURI);
//
//		JOptionPane.showMessageDialog(null, "new File(" + filePath.ge tPath() + ") しました");
//
//		return createClip(filePath);
//	}

	private Clip createClipJar(String entryURI) {

//		mediaURI = this.getClass().getResourceAsStream("media/" + entryURI).toString();

		InputStream mediaResourceURI = ClassLoader.getSystemResourceAsStream("media/" + entryURI);

		mediaURI = mediaResourceURI.toString();

//		JOptionPane.showMessageDialog(null, "mediaURI = " + mediaURI);

		File filePath = new File(mediaURI);




//		JOptionPane.showMessageDialog(null, "new File(" + filePath.getPath() + ") しました");

		return createClip(filePath);
	}

//	private Clip createClipJar(String entryURI) {
//
//		entryURI = this.getClass().getClassLoader().getResource(entryURI).getPath();
//
//		File filePath = new File(entryURI);
//
//		JOptionPane.showMessageDialog(null, "new File(" + entryURI + ") しました");
//
//		return createClip(filePath);
//	}

	private String getFilePath(String mediaURI) {
		Path p1 = Paths.get("");
		Path p2 = p1.toAbsolutePath();

		String userDir = System.getProperty("user.dir");

		URL resource = this.getClass().getProtectionDomain().getCodeSource().getLocation();

		return  userDir + "/src/media/" + mediaURI;
	}

	public static Clip createClip(File path) {

		String errorMessage = "";
		//指定されたURLのオーディオ入力ストリームを取得
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(path)){

			//ファイルの形式取得
			AudioFormat af = ais.getFormat();

			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);

			//指定された Line.Info オブジェクトの記述に一致するラインを取得
			Clip c = (Clip)AudioSystem.getLine(dataLine);

			//再生準備完了
			c.open(ais);

//			JOptionPane.showMessageDialog(null, "createClip(" + path + ") しました");

			return c;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
//		JOptionPane.showMessageDialog(null, "createClip(" + path + ") 出来ませんでした");
//		JOptionPane.showMessageDialog(null, errorMessage);

		return null;
	}

	public static Clip createClip(URL resourceURL) {

		String errorMessage = "";
		//指定されたURLのオーディオ入力ストリームを取得
		try (AudioInputStream ais = AudioSystem.getAudioInputStream(resourceURL)){

			//ファイルの形式取得
			AudioFormat af = ais.getFormat();

			//単一のオーディオ形式を含む指定した情報からデータラインの情報オブジェクトを構築
			DataLine.Info dataLine = new DataLine.Info(Clip.class,af);

			//指定された Line.Info オブジェクトの記述に一致するラインを取得
			Clip c = (Clip)AudioSystem.getLine(dataLine);

			//再生準備完了
			c.open(ais);

			//		JOptionPane.showMessageDialog(null, "createClip(" + resourceURL + ") しました");

			return c;
//		try (AudioInputStream sound = AudioSystem.getAudioInputStream(url);
//			     Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, sound.getFormat()))) {
//			  SecondaryLoop loop = Toolkit.getDefaultToolkit().getSystemEventQueue().createSecondaryLoop();
//			  clip.addLineListener(e -> {
//			    LineEvent.Type t = e.getType();
//			    if (Objects.equals(t, LineEvent.Type.STOP) || Objects.equals(t, LineEvent.Type.CLOSE)) {
//			      loop.exit();
//			    }
//			  });
//			  clip.open(sound);
//
////			JOptionPane.showMessageDialog(null, "createClip(" + path + ") しました");
//
//			return clip;

		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
			errorMessage = e.getMessage();
		}
		JOptionPane.showMessageDialog(null, "createClip(" + resourceURL + ") 出来ませんでした");
		JOptionPane.showMessageDialog(null, errorMessage);

		return null;
	}

	public void play() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を再生します");
		System.out.println("");////////////////////////

//		mediaplayer.play();
		clip.start();
	}
	public void playRepeat() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " をループ再生します");
		System.out.println("");////////////////////////

//		JOptionPane.showMessageDialog(null, mediaURI + " をループ再生します");

//		mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
//		mediaplayer.play();

		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void pause() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を一時停止します");
		System.out.println("");////////////////////////

//		mediaplayer.pause();

		clip.stop();
	}
	public void stop() {

		System.out.println("");////////////////////////
		System.out.println(mediaURI + " を停止します");
		System.out.println("");////////////////////////

//		mediaplayer.stop();

		clip.stop();
		clip.flush();
		clip.setFramePosition(0);
		clip.close();
	}

	public void fade_out() {

		FloatControl ctrl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
		for ( int i = 100;i >= 0;i-- ) {
			ctrl.setValue((float)Math.log10((float)i / 100)*20);
		}
	}

}
