import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame
{
    // Panels
    JPanel mainPnl;
    JPanel topPnl;
    JPanel middlePnl;
    JPanel bottomPnl;

    // Top panel components
    JLabel titleLbl;
    ImageIcon icon;

    // Middle panel components
    JTextArea fortuneTA;
    JScrollPane scroller;

    // Bottom panel components
    JButton readBtn;
    JButton quitBtn;

    // Separate fonts for the title, buttons and fortune display
    Font titleFont = new Font("Serif", Font.BOLD | Font.ITALIC, 48);
    Font buttonFont = new Font("SansSerif", Font.BOLD, 18);
    Font fortuneFont = new Font("Monospaced", Font.PLAIN, 16);

    // Fortunes
    ArrayList<String> fortunes = new ArrayList<>();
    Random rnd = new Random();
    int lastIndex = -1;   // index of the last fortune shown (-1 = none yet)

    public FortuneTellerFrame()
    {
        loadFortunes();

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);

        createMiddlePanel();
        mainPnl.add(middlePnl, BorderLayout.CENTER);

        createBottomPanel();
        mainPnl.add(bottomPnl, BorderLayout.SOUTH);

        add(mainPnl);
    }

    private void loadFortunes()
    {
        fortunes.add("You will find a forgotten twenty in your winter coat... in July.");
        fortunes.add("A semicolon will betray you. Check line 42.");
        fortunes.add("Your code will compile on the first try. Just kidding.");
        fortunes.add("Beware of squirrels bearing gifts.");
        fortunes.add("You will soon step on a LEGO. Brace yourself.");
        fortunes.add("A great nap is in your near future.");
        fortunes.add("Today is a good day to blame the WiFi.");
        fortunes.add("Your cat is plotting something. Stay alert.");
        fortunes.add("The pizza you order tonight will be the best of your life.");
        fortunes.add("Someone will compliment your shoes. They will be lying.");
        fortunes.add("You will spend 3 hours debugging a missing curly brace.");
        fortunes.add("An unexpected pop quiz is headed your way. Study now!");
        fortunes.add("Your phone battery will die at the worst possible moment.");
        fortunes.add("Good things come to those who commit and push.");
    }

    private void createTopPanel()
    {
        topPnl = new JPanel();

        // Load the image from the project directory and scale it to a nice size
        ImageIcon rawIcon = new ImageIcon("fortuneteller.png");
        Image scaled = rawIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaled);

        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setFont(titleFont);
        // Place the text below the image
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);

        topPnl.add(titleLbl);
    }

    private void createMiddlePanel()
    {
        middlePnl = new JPanel();
        middlePnl.setLayout(new BorderLayout());

        fortuneTA = new JTextArea(10, 50);
        fortuneTA.setFont(fortuneFont);
        fortuneTA.setEditable(false);
        fortuneTA.setMargin(new Insets(8, 8, 8, 8));

        scroller = new JScrollPane(fortuneTA);
        middlePnl.add(scroller, BorderLayout.CENTER);
    }

    private void createBottomPanel()
    {
        bottomPnl = new JPanel();
        bottomPnl.setLayout(new GridLayout(1, 2, 10, 0));

        readBtn = new JButton("Read My Fortune!");
        readBtn.setFont(buttonFont);
        readBtn.addActionListener((ae) -> showFortune());

        quitBtn = new JButton("Quit");
        quitBtn.setFont(buttonFont);
        quitBtn.addActionListener((ae) -> System.exit(0));

        bottomPnl.add(readBtn);
        bottomPnl.add(quitBtn);
    }

    private void showFortune()
    {
        int index;
        // Never return the same fortune twice in a row
        do
        {
            index = rnd.nextInt(fortunes.size());
        } while (index == lastIndex);

        lastIndex = index;
        fortuneTA.append(fortunes.get(index) + "\n");
    }
}
