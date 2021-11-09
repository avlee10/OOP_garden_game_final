import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.*;
import java.math.*;

import Plant.*;
import Insects.*;

public class gameScreen {
    public static ArrayList<String> masterLog = new ArrayList<String>();
    private static Container con;
    private static JPanel titlePanel, startButtonPanel, healthPanel, gridPanel, menuPanel, logPanel,
            statPanel, optionsPanel, setupPromptPanel, plantInfoPanel, startAndRandomize, storePanel, nextDay, storeAndLog;
    private static JLabel title, totalMoneyLabel, totalMoneyName, hpLabel, waveLabel, waveName;
    private static Font titleFont;
    private static JButton startButton, test1;
    private static ImageIcon icon;
    public static HashMap<JButton, Plant> grid = new HashMap<JButton, Plant>();
    public static Map<JButton, String[]> plantSetupOptions = new HashMap<JButton, String[]>();
    public static Map<JButton, String[]> storeOptions = new HashMap<JButton, String[]>();

    static JButton currButton;
    private static JFrame frame;

    static JProgressBar bar;

    static TitleScreenHandler tsHandler;
    static SetupScreenHandler ssHandler;
    static StoreHandler stHandler;
    static plantInfoHandler piHandler;
    static nextDayHandler ndHandler;

    static JButton Plant1 = new JButton("1");
    static JButton Plant2 = new JButton("2");
    static JButton Plant3 = new JButton("3");
    static JButton Plant4 = new JButton("4");
    static JButton Plant5 = new JButton("5");
    static JButton Plant6 = new JButton("6");
    static JButton Plant7 = new JButton("7");
    static JButton Plant8 = new JButton("8");
    static JButton Plant9 = new JButton("9");
    static JButton Plant10 = new JButton("10");
    static JButton Plant11 = new JButton("11");
    static JButton Plant12 = new JButton("12");
    static JButton Plant13 = new JButton("13");
    static JButton Plant14 = new JButton("14");
    static JButton Plant15 = new JButton("15");
    static JButton Plant16 = new JButton("16");
    static JButton Plant17 = new JButton("17");
    static JButton Plant18 = new JButton("18");
    static JButton Plant19 = new JButton("19");
    static JButton Plant20 = new JButton("20");
    static JButton Plant21 = new JButton("21");
    static JButton Plant22 = new JButton("22");
    static JButton Plant23 = new JButton("23");
    static JButton Plant24 = new JButton("24");
    static JButton Plant25 = new JButton("25");

    static JButton strawberry = new JButton();
    static JButton azalea = new JButton();
    static JButton tomato = new JButton();
    static JButton carrot = new JButton();
    static JButton cabbage = new JButton();
    static JButton beanstalk = new JButton();
    static JButton carnation = new JButton();
    static JButton cactus = new JButton();
    static JButton moneytree = new JButton();

    static JButton waspSwarm = new JButton();
    static JButton mantisSwarm = new JButton();
    static JButton gbeetleSwarm = new JButton();
    static JButton ladybugSwarm = new JButton();
    static JButton spiderSwarm = new JButton();

    static JButton randomizePlants = new JButton();
    static JButton startGame = new JButton();

    static JButton openStoreButton = new JButton();
    static JButton openLogButton = new JButton();
    static JButton nextDayButton = new JButton();

    public static int playerMoney;
    public static int playerDay = 1;
    public static int playerHealth;


    public static void main(String[] args){

        frame = new JFrame();//creates a frame
        frame.setSize(1000,800);//setting x and y dimension of the frame
        frame.setTitle("Your Garden");//title of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exist out of application
        frame.setResizable(false);// can change the dimension of the frame
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.gray);
        con = frame.getContentPane();


        titlePanel = new JPanel();//Creating a title panel for intro screen
        titlePanel.setBackground(Color.white);
        titlePanel.setBounds(100,100,600,150);


        title = new JLabel("Your Garden lol :)");//Creates a label for a title
        titleFont = new Font("Times New Roman",Font.PLAIN, 80);
        title.setSize(200, 50);
        title.setBackground(Color.black);
        title.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400,200,100);
        startButtonPanel.setBackground(Color.white);

        startButton = new JButton("Start");
        startButton.setSize(100, 30);
        startButton.setBackground(Color.white);
        startButton.setForeground(Color.black);
        tsHandler = new TitleScreenHandler();
        startButton.addActionListener(tsHandler);


        titlePanel.add(title);
        startButtonPanel.add(startButton, new GridBagConstraints());
        con.add(titlePanel);
        con.add(startButtonPanel);
        frame.setVisible(true);
    }

    /* -----------------------------------------------------------------------------------------------------
    ----------------------------------------- THE SETUP SCREEN ---------------------------------------------
    --------------------------------------------------------------------------------------------------------
    * This is where all the plots are set up.
    * It initializes all the JPanels and JButtons defined in the class.
    * It uses the actionListeners to implement all the user actions */

    public static void setupScreen() {
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        plantInfoPanel = new JPanel();
        plantInfoPanel.setBounds(100, 600, 500, 350);
        plantInfoPanel.setBackground(Color.white);
        con.add(plantInfoPanel);
        plantInfoPanel.setSize(500, 300);

        startAndRandomize = new JPanel();
        startAndRandomize.setBounds(200, 525, 400, 100);
        startAndRandomize.setBackground(Color.white);
        con.add(startAndRandomize);
        startAndRandomize.setSize(300, 70);

        randomizePlants.setText("Randomize Plants");
        randomizePlants.addActionListener(new SetupScreenHandler());
        startGame.setText("Start Game");
        startGame.addActionListener(new SetupScreenHandler());

        startAndRandomize.add(randomizePlants);
        startAndRandomize.add(startGame);

        setupPromptPanel = new JPanel();
        setupPromptPanel.setBounds(700,50,350,1200);
        setupPromptPanel.add(new JTextArea("Hey\nWelcome to the game"));
        setupPromptPanel.setBackground(Color.white);
        setupPromptPanel.setLayout(new GridLayout(10, 1));
        con.add(setupPromptPanel);
        setupPromptPanel.setSize(300, 600);


        // Panel for setup buttons (i.e. plant types to put in different plots)
        optionsPanel = new JPanel();
        optionsPanel.setBounds(700,50,350,1200);
        optionsPanel.setBackground(Color.white);
        optionsPanel.setLayout(new GridLayout(10, 1));
        con.add(optionsPanel);
        optionsPanel.setSize(300, 600);
        optionsPanel.setVisible(false);

        // Mapping buttons to plant types so we know where to plant stuff
        plantSetupOptions.put(strawberry, Plant.strawberry);
        plantSetupOptions.put(azalea, Plant.azalea);
        plantSetupOptions.put(cabbage, Plant.cabbage);
        plantSetupOptions.put(carnation, Plant.carnation);
        plantSetupOptions.put(carrot, Plant.carrot);
        plantSetupOptions.put(tomato, Plant.tomato);
        plantSetupOptions.put(beanstalk, Plant.beanstalk);
        plantSetupOptions.put(moneytree, Plant.moneytree);
        plantSetupOptions.put(cactus, Plant.cactus);

        // Adding text and action listeners to each of the buttons
        SetPlantHandler setPlant = new SetPlantHandler();
        strawberry.setText(plantSetupOptions.get(strawberry)[0]);
        strawberry.addActionListener(setPlant);
        azalea.setText(plantSetupOptions.get(azalea)[0]);
        azalea.addActionListener(setPlant);
        carnation.setText(plantSetupOptions.get(carnation)[0]);
        carnation.addActionListener(setPlant);
        tomato.setText(plantSetupOptions.get(tomato)[0]);
        tomato.addActionListener(setPlant);
        cactus.setText(plantSetupOptions.get(cactus)[0]);
        cactus.addActionListener(setPlant);
        cabbage.setText(plantSetupOptions.get(cabbage)[0]);
        cabbage.addActionListener(setPlant);
        carrot.setText(plantSetupOptions.get(carrot)[0]);
        carrot.addActionListener(setPlant);
        beanstalk.setText(plantSetupOptions.get(beanstalk)[0]);
        beanstalk.addActionListener(setPlant);
        moneytree.setText(plantSetupOptions.get(moneytree)[0]);

        optionsPanel.add(strawberry);
        optionsPanel.add(azalea);
        optionsPanel.add(carnation);
        optionsPanel.add(cabbage);
        optionsPanel.add(carrot);
        optionsPanel.add(beanstalk);
        optionsPanel.add(tomato);
        optionsPanel.add(cactus);

        //Creating a panel to store a grid in
        gridPanel = new JPanel();
        gridPanel.setBounds(150, 100, 420, 420);
        gridPanel.setLayout(new GridLayout(5, 5, 0, 0));
        con.add(gridPanel);

        grid = new HashMap<JButton, Plant>();
        grid.put(Plant1, null);
        grid.put(Plant2, null);
        grid.put(Plant3, null);
        grid.put(Plant4, null);
        grid.put(Plant5, null);
        grid.put(Plant6, null);
        grid.put(Plant7, null);
        grid.put(Plant8, null);
        grid.put(Plant9, null);
        grid.put(Plant10, null);
        grid.put(Plant11, null);
        grid.put(Plant12, null);
        grid.put(Plant13, new Plant(Integer.parseInt(Plant13.getText()), Plant.moneytree));
        grid.put(Plant14, null);
        grid.put(Plant15, null);
        grid.put(Plant16, null);
        grid.put(Plant17, null);
        grid.put(Plant18, null);
        grid.put(Plant19, null);
        grid.put(Plant20, null);
        grid.put(Plant21, null);
        grid.put(Plant22, null);
        grid.put(Plant23, null);
        grid.put(Plant24, null);
        grid.put(Plant25, null);


        // Setting text and action listeners for every button except Money Tree
        ssHandler = new SetupScreenHandler();
        for (JButton jb : grid.keySet()) {
            jb.addActionListener(ssHandler);
        }
        Plant13.setText(grid.get(Plant13).getName()); //This won't change
        Plant13.removeActionListener(ssHandler);



        // Add all buttons to the grid
        gridPanel.add(Plant1);
        gridPanel.add(Plant2);
        gridPanel.add(Plant3);
        gridPanel.add(Plant4);
        gridPanel.add(Plant5);
        gridPanel.add(Plant6);
        gridPanel.add(Plant7);
        gridPanel.add(Plant8);
        gridPanel.add(Plant9);
        gridPanel.add(Plant10);
        gridPanel.add(Plant11);
        gridPanel.add(Plant12);
        gridPanel.add(Plant13);
        gridPanel.add(Plant14);
        gridPanel.add(Plant15);
        gridPanel.add(Plant16);
        gridPanel.add(Plant17);
        gridPanel.add(Plant18);
        gridPanel.add(Plant19);
        gridPanel.add(Plant20);
        gridPanel.add(Plant21);
        gridPanel.add(Plant22);
        gridPanel.add(Plant23);
        gridPanel.add(Plant24);
        gridPanel.add(Plant25);

        for (JButton jb : grid.keySet()) {
            if (grid.get(jb) == null) {
                jb.setBackground(Color.RED);
                jb.setOpaque(true);
            } else {
                jb.setBackground(Color.GREEN);
                jb.setOpaque(true);
            }
        }
    }
    /* ------------------------------------------------------------------------------------------------------
     ------------------------------------- THE REAL MAIN FUNCTION -------------------------------------------
     --------------------------------------------------------------------------------------------------------
     * After setup, this is where the game is actually run */

    public static void gameplayScreen() {

        masterLog.add("hey");

        if (playerDay == 1) {
            // Remove old action listeners
            piHandler = new plantInfoHandler();
            for (JButton jb : grid.keySet()) {
                jb.removeActionListener(ssHandler);
                jb.addActionListener(piHandler);
            }

            optionsPanel.removeAll();
            plantInfoPanel.removeAll();
            setupPromptPanel.setVisible(false);
            optionsPanel.setVisible(false);
            startAndRandomize.setVisible(false);

            playerSetup();
        }

        healthPanel = new JPanel();
        healthPanel.setBounds(100, -5, 600, 50);
        healthPanel.setLayout(new GridLayout(1,4,0,0));
        con.add(healthPanel);
        //healthPanel.setSize(800,600);


        totalMoneyLabel = new JLabel("Total Money: " + playerMoney);
        //totalMoneyLabel.setHorizontalTextPosition(JLabel.LEFT);
        totalMoneyName = new JLabel();
        healthPanel.add(totalMoneyLabel);

        //Label for wave(day)
        int playaday = playerDay;
        waveLabel = new JLabel();//Needs a counter function for playerDay
        waveLabel.setText("Day: " + playerDay);
        //waveLabel.setFont(Font.getFont("normalFont"));
        waveLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        waveName = new JLabel();
        healthPanel.add(waveLabel);
        healthPanel.add(waveName);

        //Label for health points
        hpLabel = new JLabel("HP: ");
        //hpLabel.setHorizontalTextPosition(JLabel.CENTER);
        //hpLabel.setFont(Font.getFont("normalFont"));
        hpLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        healthPanel.add(hpLabel);

        //Bar to show hp value
        bar = new JProgressBar();
        //bar.setValue(100);
        bar.setBounds(0, -5, 400, 120);
        bar.setStringPainted(true);
        int plantHealth = 0;
        for (Plant i : grid.values()) {
            plantHealth += i.getHealth();
        }
        playerHealth = Math.round(plantHealth / 25);
        System.out.println(playerHealth);
        bar.setValue(plantHealth);
        healthPanel.add(bar);

        // Mapping buttons to store options for good insects & other goodies
        storeOptions.put(waspSwarm, new String[]{"wasp", "10", "20"});
        storeOptions.put(mantisSwarm, new String[]{"mantis", "10", "30"});
        storeOptions.put(gbeetleSwarm, new String[]{"ground beetle", "10", "25"});
        storeOptions.put(ladybugSwarm, new String[]{"ladybug", "10", "15"});
        storeOptions.put(spiderSwarm, new String[]{"spider", "10", "10"});

        storePanel = new JPanel();
        storePanel.setBounds(700,50,350,1200);
        storePanel.setBackground(Color.white);
        storePanel.setLayout(new GridLayout(10, 1));
        storePanel.setVisible(true);
        con.add(storePanel);
        storePanel.setSize(300, 600);

        // Setting text and action listeners for every button
        stHandler = new StoreHandler();
        waspSwarm.setText("Wasp Swarm");
        waspSwarm.addActionListener(stHandler);
        mantisSwarm.setText("Mantis Swarm");
        mantisSwarm.addActionListener(stHandler);
        gbeetleSwarm.setText("G Beetle Swarm");
        gbeetleSwarm.addActionListener(stHandler);
        ladybugSwarm.setText("Ladybug Swarm");
        ladybugSwarm.addActionListener(stHandler);
        spiderSwarm.setText("Spider Swarm");
        spiderSwarm.addActionListener(stHandler);

        // Add all buttons to the grid
        storePanel.add(waspSwarm);
        storePanel.add(mantisSwarm);
        storePanel.add(gbeetleSwarm);
        storePanel.add(ladybugSwarm);
        storePanel.add(spiderSwarm);

        logPanel = new JPanel();
        logPanel.setBounds(700,50,350,1200);
        logPanel.setBackground(Color.white);
        logPanel.setLayout(new GridLayout(1, 1, 5, 5));
        logPanel.setVisible(true);
        con.add(logPanel);
        logPanel.setSize(300, 600);


        //Creating a panel to store a grid in
        gridPanel = new JPanel();
        gridPanel.setBounds(250, 100, 250, 250);
        gridPanel.setLayout(new GridLayout(5, 5, 10, 10));
        con.add(gridPanel);

        nextDay = new JPanel();
        nextDay.setBounds(200, 525, 400, 100);
        nextDay.setBackground(Color.white);
        con.add(nextDay);
        nextDay.setSize(300, 70);

        ndHandler = new nextDayHandler();
        nextDayButton.setText("Next Day");
        nextDayButton.addActionListener(ndHandler);
        nextDay.add(nextDayButton);

        storeAndLog = new JPanel();
        storeAndLog.setBounds(700, 650, 350, 100);
        storeAndLog.setBackground(Color.white);
        storeAndLog.setLayout(new GridLayout(1,2));
        storeAndLog.setVisible(true);
        con.add(storeAndLog);
        storeAndLog.setSize(300, 100);

        openStoreButton.setText("<- Store");
        openStoreButton.addActionListener(stHandler);
        openLogButton.setText("Events ->");
        openLogButton.addActionListener(stHandler);

        storeAndLog.add(openStoreButton);
        storeAndLog.add(openLogButton);
        con.revalidate();
        con.repaint();
    }

    public static void playerSetup(){
        playerMoney = 1000;

    }

    /* ------------------------------------------------------------------------------------------------------
     --------------------------------------- THE ACTION LISTENERS -------------------------------------------
     --------------------------------------------------------------------------------------------------------*/

    public static class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setupScreen();
        }
    }

    public static class SetupScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            JButton buttonPushed = (JButton) event.getSource();

            // If user presses randomize or start, it performs the respective actions
            // When the user clicks on a plot, it brings up plant options to select from
            // The user the selects from the list and continues to fill until ready to start the game
            if (buttonPushed.equals(randomizePlants)) {
                JButton[] keys = new JButton[8];
                int count = 0;
                for (JButton jb : plantSetupOptions.keySet()) {
                    if (plantSetupOptions.get(jb).equals(Plant.moneytree)) { continue; }
                    keys[count] = jb;
                    count++;
                    System.out.println(keys);
                }

                // Put random plants in all plots except the moneytree plot
                Random rnd = new Random();
                for (JButton jb : grid.keySet()) {
                    if (grid.get(jb) == null || (grid.get(jb).getPosition() != 13)) {
                        // If plot is null, get the int from jb.getText; if not, get the position from the plant
                        grid.put(jb, new Plant(
                                        ((grid.get(jb) == null) ? Integer.parseInt(jb.getText()) : grid.get(jb).getPosition()),
                                        plantSetupOptions.get(keys[rnd.nextInt(8)])));
                        jb.setText(grid.get(jb).getName());
                    }
                }

                // Update colors
                for (JButton jb : grid.keySet()) {
                    if (grid.get(jb).getHealth() == 0) {
                        jb.setBackground(Color.RED);
                        jb.setOpaque(true);
                    } else {
                        jb.setBackground(Color.GREEN);
                        jb.setOpaque(true);
                    }
                }
            } else if (buttonPushed.equals(startGame)) {
                boolean allFilled = true;
                for (Plant p : grid.values()) {
                    if (p.getName().equals("*")) {
                        allFilled = false;
                        plantInfoPanel.removeAll();
                        plantInfoPanel.add(new JTextArea("Some plots still aren't filled! \nFill every plot with a plant to begin."));
                        plantInfoPanel.revalidate();
                        break;
                    }
                }
                if (allFilled == true) {
                    gameplayScreen();
                }

            } else {
                plantInfoPanel.removeAll();
                setupPromptPanel.setVisible(false);
                optionsPanel.setVisible(true);
                currButton = (JButton) event.getSource();
                plantInfoPanel.add(new JTextArea(grid.get(event.getSource()).getStats()));
                plantInfoPanel.revalidate();
            }
        }
    }

    public  static class SetPlantHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            JButton buttonPushed = (JButton) event.getSource();
            plantInfoPanel.removeAll();
            plantInfoPanel.add(new JTextArea(new Plant(Integer.parseInt(buttonPushed.getText()),
                    plantSetupOptions.get(buttonPushed)).getStats()));

            grid.put(currButton, new Plant(Integer.parseInt(buttonPushed.getText()), plantSetupOptions.get(buttonPushed)));
            currButton.setText(grid.get(currButton).getName());
            currButton.setBackground(Color.GREEN);
            optionsPanel.setVisible(false);
            setupPromptPanel.setVisible(true);
        }
    }

    public static class StoreHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton buttonPushed = (JButton) event.getSource();
            String[] swarmAttributes = storeOptions.get(buttonPushed);
            
            Random rnd = new Random();
            Plant[] gridPlants = grid.values().toArray(new Plant[grid.values().size()]);

            if (buttonPushed == openStoreButton) {
                logPanel.setVisible(false);
                storePanel.setVisible(true);
            } else if (buttonPushed == openLogButton) {
                storePanel.setVisible(false);
                logPanel.setVisible(true);
                logPanel.removeAll();
                JTextArea logText = new JTextArea();
                logText.setLineWrap(true);
                logText.setWrapStyleWord(true);
                logText.setMargin(new Insets(5,5,5,5));
                for (String i : masterLog) {
                    logText.append(i);
                }
                JScrollPane pane = new JScrollPane(logText);
                logPanel.add(pane);
                logPanel.repaint();
                logPanel.revalidate();
            } else if (buttonPushed == waspSwarm) {
                for(int i=0; i<Integer.parseInt(swarmAttributes[1]); i++)
                {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new Wasp(index + 1));
                }
            } else if (buttonPushed == mantisSwarm) {
                for(int i=0; i<Integer.parseInt(swarmAttributes[1]); i++)
                {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new Mantis(index + 1));
                }
            } else if (buttonPushed == gbeetleSwarm) {
                for(int i=0; i<Integer.parseInt(swarmAttributes[1]); i++)
                {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new GroundBeetle(index + 1));
                }
            } else if (buttonPushed == ladybugSwarm) {
                for(int i=0; i<Integer.parseInt(swarmAttributes[1]); i++)
                {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new LadyBug(index + 1));
                }
            } else if (buttonPushed == spiderSwarm) {
                for(int i=0; i<Integer.parseInt(swarmAttributes[1]); i++)
                {
                    int index = rnd.nextInt(25);
                    gridPlants[index].insectsOnPlant.add(new Spider(index + 1));
                }
            }
        }
    }

    public static class plantInfoHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton buttonPushed = (JButton) event.getSource();

            plantInfoPanel.removeAll();
            plantInfoPanel.add(new JTextArea("Health: " + Math.round(grid.get(buttonPushed).getHealth())));
            plantInfoPanel.add(new JTextArea(grid.get(buttonPushed).getInsectsOnPlant()));
            plantInfoPanel.repaint();
            plantInfoPanel.revalidate();
        }
    }

    public static class nextDayHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            ArrayList<Plant> plants = new ArrayList<Plant>();
            plants.addAll(grid.values());
            // loop through all the plants on the grid
            // make sure damage is dealt to plant
            // predators look for and eat other insects, and possibly die of starvation or natural causes
            // bugs move from the plant if they desire (i.e. a neighboring plant is in their diet/favPlants)
            for (Plant p : plants) {
                ArrayList<Insects> original = new ArrayList<Insects>();
                original.addAll(p.insectsOnPlant); // idk if this does anything to fix the ConcurrentModification error, but it's here anyways
                ArrayList<Insects> insectsToRemove = new ArrayList<Insects>();
                // all plant eating insects on the plant, do damage if it's in their respective diets
                for (Insects i : original) {
                    if (i.getDiet().length > 0) { // if plant eater
                        for (String s : i.diet) {
                            if (s == p.getName()) { // do damage if plant in insect diet
                                p.setHealth(p.getHealth() - i.getDamage());
                            }
                        }
                    }
                    // do eating and movement
                    // add insects to be removed to a list to remove after the loop is finished for all insects
                    Insects insect = i.eatOrDie(grid);
                    if (insect != null) {
                        if (!insectsToRemove.contains(insect)) { insectsToRemove.add(insect); }
                    }
                    if (i.daysSinceMeal > 3) {
                        if (!insectsToRemove.contains(i)) { insectsToRemove.add(i); }
                    } else if (i.Move(grid)) {
                        if (!insectsToRemove.contains(i)) { insectsToRemove.add(i); }
                    }
                }
                // to subvert the ConcurrentModification error, I'm removing everything after the loop
                p.insectsOnPlant.removeAll(insectsToRemove);

                // spawn everything in on the plant for the day
                for (int x=0; x<p.getSpawns(new Wasp(0)); x++) { p.insectsOnPlant.add(new Wasp(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new Aphid(0)); x++) { p.insectsOnPlant.add(new Aphid(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new Spider(0)); x++) { p.insectsOnPlant.add(new Spider(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new Mantis(0)); x++) { p.insectsOnPlant.add(new Mantis(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new BishBug(0)); x++) { p.insectsOnPlant.add(new BishBug(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new LadyBug(0)); x++) { p.insectsOnPlant.add(new LadyBug(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new Caterpillar(0)); x++) { p.insectsOnPlant.add(new Caterpillar(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new GroundBeetle(0)); x++) { p.insectsOnPlant.add(new GroundBeetle(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new PotatoBeetle(0)); x++) { p.insectsOnPlant.add(new PotatoBeetle(p.getPosition())); }
                for (int x=0; x<p.getSpawns(new JapaneseBeetle(0)); x++) { p.insectsOnPlant.add(new JapaneseBeetle(p.getPosition())); }

                // plants drink and take damage
                p.setWaterLevel(p.getWaterLevel() - p.getThirst());
                p.setHealth(p.getHealth() + p.getHealthRegen());
            }

            // some environmental hazard will happen
            EnvHazard.doHazard();
            System.out.println(masterLog);
            JTextArea logText = new JTextArea();
            logPanel.removeAll();
            logText.setMargin(new Insets(5,5,5,5));
            logText.setLineWrap(true);
            logText.setWrapStyleWord(true);
            for (String i : masterLog) {
                logText.append(i);
            }
            JScrollPane pane = new JScrollPane(logText);
            logPanel.add(pane);
            logPanel.repaint();
            logPanel.revalidate();

            playerDay++;
            con.revalidate();
            con.repaint();
            int plantHealth = 0;
            for (Plant i : grid.values()) {
                plantHealth += i.getHealth();
            }
            playerHealth = Math.round(plantHealth / 25);
            plantInfoPanel.repaint();
            plantInfoPanel.revalidate();
            bar.setValue(playerHealth);

            for (JButton jb : grid.keySet()) {
                if (grid.get(jb).getHealth() < 40) {
                    jb.setBackground(Color.RED);
                    jb.setOpaque(true);
                } else if (grid.get(jb).getHealth() < 70){
                    jb.setBackground(Color.YELLOW);
                    jb.setOpaque(true);
                } else {
                    jb.setBackground(Color.GREEN);
                    jb.setOpaque(true);
                }
            }

            waveLabel.setText("Day: " + playerDay);
        }
    }
}
