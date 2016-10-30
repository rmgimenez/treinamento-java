package livro;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

// precisamos escutar os ControllerEvents, portanto implementamos a interface de escuta
public class MiniMusicPlayer2Pg277 implements ControllerEventListener {

	public static void main(String[] args) {
		MiniMusicPlayer2Pg277 mini = new MiniMusicPlayer2Pg277();
		mini.go();
	}

	public void go() {
		try {
			Sequencer sequencer = MidiSystem.getSequencer();
			sequencer.open();

			/*
			 * Registra eventos no sequenciador. O método de registro de eventos
			 * usará o ouvinte e uma matriz int representando a lista de
			 * ControllerEvents que você quiser. Queremos somente um evento,
			 * #127
			 */
			int[] eventsIWant = { 127 };
			sequencer.addControllerEventListener(this, eventsIWant);

			Sequence seq = new Sequence(Sequence.PPQ, 4);
			Track track = seq.createTrack();

			for (int i = 5; i < 60; i += 4) {
				track.add(makeEvent(144, 1, i, 100, i));

				/*
				 * Veja como identificamos a batida - inserimos nosso próprio
				 * ControllerEvent (176 segnifica que o evento é do tipo
				 * ControllerEvent) com um argumento para o número do evento que
				 * é 127. Esse evento não fará nada! Nós o inserimos apenas para
				 * podermos capturar um evento sempre que uma nota for
				 * reproduzida. Em outras palavras, sua única finalidade é que
				 * algo que possamos escutar seja acionado (não podemos escutar
				 * eventos nota ON/OFF). Observe que estamos fazendo esse evento
				 * ocorrer no mesmo momento de note ON. Portanto quando o evento
				 * note ON ocorrer, saberemos disso porque nosso evento será
				 * acionadoao mesmo tempo
				 */
				track.add(makeEvent(176, 1, 127, 0, i));

				track.add(makeEvent(128, 1, i, 100, i + 2));

			} // fim do loop for
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * @see javax.sound.midi.ControllerEventListener#controlChange(javax.sound.midi.ShortMessage)
	 * 
	 * O método manipulador de eventos (da interface que escuta ControllerEvent). Sempre que capturarmos
	 * o evento, exibiremos la na linha de comendo 
	 */
	public void controlChange(ShortMessage event) {
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
