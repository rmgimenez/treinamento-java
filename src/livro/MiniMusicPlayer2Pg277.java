package livro;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class MiniMusicPlayer2Pg277 {

	public static void main(String[] args) {

	}

	public void go() {

	}
	
	public void controlChange(ShortMessage event){
		System.out.println("la");
	}

	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return event;
	}

}
