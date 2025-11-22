import java.util.List;
import java.util.Map;

public class Task1 {
    static Map<Note, String> noteMap = Map.of(
            Note.DO, "./Sounds/do.wav",
            Note.RE, "./Sounds/re.wav",
            Note.MI, "./Sounds/mi.wav",
            Note.FA, "./Sounds/fa.wav",
            Note.SOL, "./Sounds/sol.wav",
            Note.LA, "./Sounds/la.wav",
            Note.SI, "./Sounds/si.wav",
            Note.DO_OCTAVE, "./Sounds/do-octave.wav");

    static class Synchronizer {
        Note activeNote;

        Synchronizer() {
        }

        public synchronized void sendNote(Note note) {
            this.activeNote = note;
            this.notifyAll();
        }

        public synchronized Note getNote() {
            return this.activeNote;
        }
    }

    static enum Note {
        DO,
        RE,
        MI,
        FA,
        SOL,
        LA,
        SI,
        DO_OCTAVE,
    }

    static class Player extends Thread {
        Synchronizer synchronizer;
        List<Note> allowedNotes;
        int id;

        Player(int id, Synchronizer synchronizer, List<Note> allowedNotes) {
            this.id = id;
            this.synchronizer = synchronizer;
            this.allowedNotes = allowedNotes;
        }

        public void run() {
            while (true) {
                try {
                    synchronized (this.synchronizer) {
                        this.synchronizer.wait();
                        Note nextNote = this.synchronizer.getNote();
                        if (this.allowedNotes.contains(nextNote)) {
                            FilePlayer.play(noteMap.get(nextNote));
                            System.out.printf("Thread %d playing note %s\n", this.id, nextNote.toString());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        Synchronizer synchronizer = new Synchronizer();
        Player t1 = new Player(1, synchronizer, List.of(Note.DO, Note.MI, Note.SOL, Note.SI, Note.DO_OCTAVE));
        Player t2 = new Player(2, synchronizer, List.of(Note.RE, Note.FA, Note.LA, Note.DO_OCTAVE));

        List<Note> notes = List.of(
                Note.DO,
                Note.RE,
                Note.MI,
                Note.FA,
                Note.SOL,
                Note.LA,
                Note.SI,
                Note.DO_OCTAVE);

        t1.start();
        t2.start();

        for (var note : notes) {
            synchronizer.sendNote(note);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
