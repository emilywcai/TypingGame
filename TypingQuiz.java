//import javax.speech.*;

import java.util.Scanner;
import java.util.Locale;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TypingQuiz
{
    private Synthesizer synthesizer;
    private String[] words = 
    {"blue", "hackathon", "water", "purple", "keyboard", "telephone", "dolphin", "popsicle", "cardboard", "confetti"};
    private int score = 0;


    public boolean evaluate(String attempt, int num)
    {
        if (attempt.equalsIgnoreCase(words[num]))
             return true;
        else
            return false;
    }

    public void runGame()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Welcome to Typing Test. You will be given 10 words to type.\n" +
                            "Please type in the word after you hear it and hit \"Enter\". You will hear a sound indicating if you typed it correctly.\n" +
                            "You will get your final score at the end of the game. Good luck and happy typing!");


        for (int i = 0; i < 10; i++)
        {
            System.out.println("Please type in " + words[i]);
            synthesizer.speakPlainText(
                "Please type in " + words[i], null);
            String attempt = input.nextLine();

            if (evaluate(attempt, i))
            {
                score++;
                synthesizer.speakPlainText("Correct", null);
                System.out.println("Correct!");
            }
            else
            {
                synthesizer.speakPlainText("Incorrect", null);
                System.out.println("Incorrect!");
            }
        }

        synthesizer.speakPlainText("Your score is " + score + " out of 10.", null);
        System.out.println("Your score is " + score + "/10.");
    }
    public static void main(String[] args)
    {
        try {
            // Set property as Kevin Dictionary
            System.setProperty(
                "freetts.voices",
                "com.sun.speech.freetts.en.us"
                    + ".cmu_us_kal.KevinVoiceDirectory");
  
            // Register Engine
            Central.registerEngineCentral(
                "com.sun.speech.freetts"
                + ".jsapi.FreeTTSEngineCentral");
  
            TypingQuiz game = new TypingQuiz();
            game.synthesizer=Central.createSynthesizer(
                    new SynthesizerModeDesc(Locale.US));
  
            // Allocate synthesizer
            game.synthesizer.allocate();
  
            // Resume Synthesizer
            game.synthesizer.resume();
  
            // Speaks the given text
            // until the queue is empty.
            game.runGame();
            game.synthesizer.waitEngineState(
                Synthesizer.QUEUE_EMPTY);
  
            // Deallocate the Synthesizer.
            game.synthesizer.deallocate();
        }
  
        catch (Exception e) {
            e.printStackTrace();
        }  
        
    }
}