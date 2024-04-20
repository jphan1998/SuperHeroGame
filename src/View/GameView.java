package View;

public class GameView {
    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_RESET = "\u001B[0m";

    public void welcome(){
        System.out.println(ANSI_CYAN + "Welcome to Dungeon Adventure!\n" + ANSI_RESET);
    }

    public void updateView(String view){
        System.out.println(view.replaceAll("[.?!]\\s?","$0\n"));
        System.out.println("--------------------------------------------");
    }

    public void wrongCommand(){
        System.out.println(ANSI_RED + "Please only enter the commands given." + ANSI_RESET);
    }

    public void hasVisited(){
        System.out.println(ANSI_BLUE + "This place seems familiar, you have been here before!" + ANSI_RESET);
    }
}
