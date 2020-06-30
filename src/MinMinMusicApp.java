import javax.sound.midi.*;

public class MinMinMusicApp {
    public static void main(String[] args){
        MinMinMusicApp mini = new MinMinMusicApp();
        mini.play();
    }

    public void play(){
        try{
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            Sequence seq = new Sequence(Sequence.PPQ,4);

            Track track = seq.createTrack();

            ShortMessage a = new ShortMessage();
            a.setMessage(192,1,102,0);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage(); // testing git 2
            a.setMessage(128,2,44,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);

            player.start();
        } catch (Exception ex) {
            ex.printStackTrace(); // testing github desktop
        }
    }
}
