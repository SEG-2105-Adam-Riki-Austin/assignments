import java.util.List;
import java.util.Map;

public class Assignment {
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

    static class PlayerThread extends Thread {
        Synchronizer synchronizer;
        List<Note> allowedNotes;
        int id;

        PlayerThread(int id, Synchronizer synchronizer, List<Note> allowedNotes) {
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
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Note> notes = null;

        if (args.length != 1) {
            System.err.println("Must provide either 1 or 2 (for tasks 1 and 2 respectively) as an argument.");
            System.exit(2);
        }

        switch (args[0]) {
            case "1":
                notes = List.of(
                        Note.DO,
                        Note.RE,
                        Note.MI,
                        Note.FA,
                        Note.SOL,
                        Note.LA,
                        Note.SI,
                        Note.DO_OCTAVE);
                break;
            case "2":
                notes = List.of(
                        Note.DO, Note.DO, Note.SOL, Note.SOL, Note.LA, Note.LA, Note.SOL, Note.FA, Note.FA, Note.MI,
                        Note.MI, Note.RE, Note.RE, Note.DO, Note.SOL, Note.SOL, Note.FA, Note.FA, Note.MI, Note.MI,
                        Note.RE, Note.SOL, Note.SOL, Note.FA, Note.FA, Note.MI, Note.MI, Note.RE, Note.DO, Note.DO,
                        Note.SOL, Note.SOL, Note.LA, Note.LA, Note.SOL, Note.FA, Note.FA, Note.MI, Note.MI, Note.RE,
                        Note.RE, Note.DO);
                break;
            default:
                System.err.println("Invalid argument");
                System.exit(1);
        }

        Synchronizer synchronizer = new Synchronizer();
        PlayerThread t1 = new PlayerThread(1, synchronizer,
                List.of(Note.DO, Note.MI, Note.SOL, Note.SI, Note.DO_OCTAVE));
        PlayerThread t2 = new PlayerThread(2, synchronizer, List.of(Note.RE, Note.FA, Note.LA, Note.DO_OCTAVE));

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

        t1.interrupt();
        t2.interrupt();
    }
}
