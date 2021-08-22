import java.speech.*;

import java.util.Scanner;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TypingQuiz
{
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

        // Set property as Kevin Dictionary
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");

        // Register Engine
        Central.registerEngineCentral("com.sun.speech.freetts"+ ".jsapi.FreeTTSEngineCentral");

        // Create a Synthesizer
        Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));

        // Allocate synthesizer
        synthesizer.allocate();

        // Resume Synthesizer
        synthesizer.resume();

        // Speaks the given text
        // until the queue is empty.
        //synthesizer.speakPlainText("", null);
        //synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);

        // Deallocate the Synthesizer.
        synthesizer.deallocate();


        for (int i = 0; i < 10; i++)
        {
            //System.out.println("Please type in " + words[i]);
            synthesizer.speakPlainText(("Please type in " + words[i]), null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
            String attempt = input.nextLine();

            if (evaluate(attempt, i))
            {
                score++;
                System.out.println("Correct!");
            }
            else
                System.out.println("Incorrect!");
        }

        System.out.println("Your score is " + score + "/10.");
    }
    public static void main(String[] args)
    {
        TypingQuiz game = new TypingQuiz();
        game.runGame();
    }
}