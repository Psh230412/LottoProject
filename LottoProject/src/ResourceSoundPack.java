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
	static Clip BackgrundSoundClip;


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
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/ballSpinning.wav");  // 사운드
																													// 파일
																													// 경로
																													// 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			lottoBallClip = AudioSystem.getClip();
			lottoBallClip.open(audioInputStream);
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

	static public void stopSound() {
		lottoBallClip.stop();
		lottoBallClip.flush();
	}
	
	static public void drowSound() {
		try {//버튼 누를떄
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/tada-fanfare-a-6313.wav");
			// 사운드 파일 경로 설정
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}
	
	
	static void backgrundsound() {
		try {
			URL soundFile = ResourceSoundPack.class.getClassLoader().getResource("soundResourses/pixel-song-22-72581.wav"); // 배경음 사운드 파일 경로 설정
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            BackgrundSoundClip = AudioSystem.getClip();
            BackgrundSoundClip.open(audioInputStream);
            BackgrundSoundClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
            ex.printStackTrace();
        }

		
	}
	
	static public void stopLoopSound() {
	        BackgrundSoundClip.stop();
	        BackgrundSoundClip.flush();
	    }
	   
	 public boolean isLoopSoundPlaying() {
	        return BackgrundSoundClip.isActive();
	       }
}