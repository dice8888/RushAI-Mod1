package speech;

import org.vosk.LibVosk;
import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.LogLevel;

import java.io.IOException;
import java.nio.ByteBuffer;

public class SpeechRecognition {
    private Model model;
    private Recognizer recognizer;

    public SpeechRecognition(String modelPath) throws IOException {
        // ✅ 로그 레벨 설정 (init() 제거)
        LibVosk.setLogLevel(LogLevel.DEBUG);

        this.model = new Model(modelPath);
        this.recognizer = new Recognizer(model, 16000);
    }

    public String recognizeAudio(byte[] audioData) {
        if (recognizer.acceptWaveForm(audioData, audioData.length)) {
            return recognizer.getResult();
        } else {
            return recognizer.getPartialResult();
        }
    }

    public String recognizeAudio(ByteBuffer audioData) {
        byte[] data = new byte[audioData.remaining()];
        audioData.get(data);
        return recognizeAudio(data);
    }

    public void close() {
        recognizer.close();
        model.close();
    }
}
