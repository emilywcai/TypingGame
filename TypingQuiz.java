import java.util.Scanner;
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

        for (int i = 0; i < 10; i++)
        {
            System.out.println("Please type in " + words[i]);
            String attempt = input.nextLine();

            if (evaluate(attempt, i))
                score++;
        }

        System.out.println("Your score is " + score + "/10");
    }
    public static void main(String[] args)
    {
        TypingQuiz game = new TypingQuiz();
        game.runGame();
    }
}