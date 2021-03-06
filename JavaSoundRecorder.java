import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;


/**
* CREDITS:
* www.codejava.net - helped with sound recording implementation
*
*/

public class JavaSoundRecorder extends JFrame {
  // record duration, in milliseconds
  static final long RECORD_TIME = 5000;  // 1 minute


  // format of audio file
  AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

  // the line from which audio data is captured
  TargetDataLine line;

  public JavaSoundRecorder(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Test Sound Clip");
    this.setSize(300, 200);
    this.setVisible(true);

    this.addKeyListener(new MyListener());

  }

  /**
  * Defines an audio format
  */
  AudioFormat getAudioFormat() {
    float sampleRate = 16000;
    int sampleSizeInBits = 16;
    int channels = 1;
    boolean signed = true;
    boolean bigEndian = true;
    AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
    channels, signed, bigEndian);
    return format;
  }

  /**
  * Captures the sound and record into a WAV file
  */
  void start(File wavFile) {
    try {
      AudioFormat format = getAudioFormat();
      DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

      // checks if system supports the data line
      if (!AudioSystem.isLineSupported(info)) {
        System.out.println("Line not supported");
        System.exit(0);
      }
      line = (TargetDataLine) AudioSystem.getLine(info);
      line.open(format);
      line.start();   // start capturing

      System.out.println("Start capturing...");

      AudioInputStream ais = new AudioInputStream(line);

      System.out.println("Start recording...");

      // start recording
      AudioSystem.write(ais, fileType, wavFile);
      System.out.println("writing stuff\n\n\n\n");

    } catch (LineUnavailableException ex) {
      ex.printStackTrace();
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
  * Closes the target data line to finish capturing and recording
  */
  void finish() {
    line.stop();
    line.close();
    System.out.println("Finished");
  }

  /**
  * Entry to run the program
  */
  public static void main(String[] args) {
    JavaSoundRecorder recorder = new JavaSoundRecorder();



    Thread sleepyThread = new Thread(new Runnable() {
      public void run() {
        int i = 0;
        while (true){
          // path of the wav file
          String filename = "inProgressSound/loop_"+i+".wav";
          File wavFile = new File(filename);
          try {
            wavFile.createNewFile();
          } catch (IOException ex){
            ex.printStackTrace();
          }
          // start recording
          System.out.println("record");
          Thread writeThread = new Thread(new Runnable() {
            public void run() {
              recorder.start(wavFile);
            }
          });
          writeThread.start();
          System.out.println("do other things");
          try {
            System.out.println("sleep");
            Thread.sleep(RECORD_TIME);
            System.out.println("wake the hell up :)");
          } catch (InterruptedException ex){
            ex.printStackTrace();
          }
          System.out.println("stop recording");
          recorder.finish();
          recorder.playPreviousLoops();
          i++;
        }
      }
    });
    sleepyThread.start();



  }

  private void playPreviousLoops(){
    int i = 0;
    String filename = "inProgressSound/loop_"+i+".wav";

    File wavFile = new File(filename);
    while (wavFile.exists()){
      play(filename);
      i++;
      filename = "inProgressSound/loop_"+i+".wav";
      System.out.println(filename);
      wavFile = new File(filename);
    }

  }

  private void play(String filename){
    try {
      // Open an audio input stream.
      URL url = this.getClass().getClassLoader().getResource(filename);
      System.out.println(url);
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
      // Get a sound clip resource.
      Clip clip = AudioSystem.getClip();
      // Open audio clip and load samples from the audio input stream.
      clip.open(audioIn);
      clip.start();
    } catch (UnsupportedAudioFileException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (LineUnavailableException e) {
      e.printStackTrace();
    }
  }

//
//
//   private File append(String wavFile1, String wavFile2){
//     File newWav;
//     try {
//       AudioInputStream clip1 = AudioSystem.getAudioInputStream(new File(wavFile1));
//       AudioInputStream clip2 = AudioSystem.getAudioInputStream(new File(wavFile2));
//
//       AudioInputStream appendedFiles =
//       new AudioInputStream(
//       new SequenceInputStream(clip1, clip2),
//       clip1.getFormat(),
//       clip1.getFrameLength() + clip2.getFrameLength());
//
//       // new appended file
//       newWav = new File(wavFile1+"+"+wavFile2.substring(16));
//       try {
//         newWav.createNewFile();
//       } catch (IOException ex){
//         ex.printStackTrace();
//       }
//
//       AudioSystem.write(appendedFiles,
//       AudioFileFormat.Type.WAVE,
//       newWav);
//
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//
//     return newWav;
//   }
// }

/*
*   nested class for pressing keys.
*/
class MyListener implements KeyListener {
  public void keyPressed(KeyEvent e) {
    System.exit(0);
  }
  public void keyReleased(KeyEvent e){

  }
  public void keyTyped(KeyEvent e){

  }
}
}
