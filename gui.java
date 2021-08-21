import javax.swing.*;

class gui {
    public void main(String[] args) throws Exception {
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
    }

}
