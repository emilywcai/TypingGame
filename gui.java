import javax.swing.*;

class gui {
    public static void main(String[] args) throws Exception {
        new gui(); 
    }

    gui(){
        welcome();
    }

    public void welcome() {
        JFrame frame = new JFrame("Welcome!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);
        frame.setVisible(true);
        JLabel welcome = new JLabel("Hello! Welcome to Typing Test. You will be given 10 words to type.\n" +
        "Please type in the word after you hear it and hit \"Enter\". You will hear a sound indicating if you typed it correctly.\n" +
        "You will get your final score at the end of the game. Good luck and happy typing!");
        frame.add(welcome);
    }

}
