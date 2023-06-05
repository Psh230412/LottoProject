import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ResourceSoundPack {


	static Clip lottoBallClip;

<<<<<<< HEAD
	static void stratSound() {
		try {
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/start.wav"); // 시작
			// 사운드 파일 경로 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}
=======
   static void startSound() {
      try {
         URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/start.wav");
         // 사운드 파일 경로 설정
         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
         Clip clip = AudioSystem.getClip();
         clip.open(audioInputStream);
         clip.start();
      } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
         ex.printStackTrace();
      }
   }
>>>>>>> branch 'master' of https://github.com/Psh230412/LottoProject.git

	static void removeSound() {
		try {//지우기
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/remove.wav");
			// // 사운드 파일 경로 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	static void slotPickSound() {
		try {//슬롯 선택 
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/slotPick.wav");
			// 사운드 파일 경로 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	static void btnSound() {
		try {//버튼 누를떄
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/btnPick.wav");
			// 사운드 파일 경로 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	static void numSound() {
		try {
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/numPick.wav");

			// 사운드 파일 경로
			// 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	static void lottoBallSound() {
		try {
			// URL soundFile =
			// ResourceSoundPack.class.getClassLoader().getResource("soundResourses/ballSpinning.wav");
			File soundFile = new File(
					"C:\\Users\\0onmi\\git\\LottoProject\\LottoProject\\src\\soundResourses\\ballSpinning.wav"); // 사운드
																													// 파일
																													// 경로
																													// 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			lottoBallClip = AudioSystem.getClip();
			lottoBallClip.open(audioInputStream);
			lottoBallClip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	static public void stopLoopSound() {
		lottoBallClip.stop();
		lottoBallClip.flush();
	}
}