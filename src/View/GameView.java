package View;

public class GameView {
    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_RESET = "\u001B[0m";

    public void welcome(){
        System.out.println("Welcome to Dungeon Adventure!");
    }

    public void updateView(String view){
        System.out.println(view.replaceAll("[.?!]\\s?","$0\n"));
    }

    public void wrongCommand(){
        System.out.println(ANSI_RED + "Please only enter the commands given." + ANSI_RESET);
    }
}
