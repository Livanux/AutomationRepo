package avanzado;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorder {

    private void startRecording(String videoPath){
        /*this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey,MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                        QualityKey,1.0f, KeyFrameIntervalKey, 15*60),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",FrameRateKey, Rational.valueOf(30)),
                null, file, "ScreenRecorded");*/
    }

    @Test
    public void videoTest(){

    }
}