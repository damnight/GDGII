package controller;

import ddf.minim.AudioPlayer;
import ddf.minim.analysis.FFT;
import ddf.minim.Minim;
import processing.core.PApplet;

/**
 * Created by Tobias Lahmann on 25.03.2017.
 */
public class Player {
    private AudioPlayer song;
    private FFT fft;

    public Player(PApplet _parent, String _file) {
        Minim minim = new Minim(_parent);
        song = minim.loadFile(_file);
        fft = new FFT(song.bufferSize(), song.sampleRate());
    }

    public void TogglePlaying() {
        if (!song.isPlaying()) {
            song.play();
        } else {
            song.pause();
            song.cue(0);
        }
    }

    public FFT getFFT() {
        return this.fft;
    }

    public AudioPlayer getSong() {
        return this.song;
    }
}
