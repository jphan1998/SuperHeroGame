package View;

public class GameView {
    public static final String ANSI_RED = "\u001B[31m";

    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_RESET = "\u001B[0m";
    String view;

    public void printView(){
        System.out.println("--------------------------------------------\n");
        System.out.println(view);
        System.out.println("--------------------------------------------\n");
    }
    public void welcome(){
        System.out.println(ANSI_CYAN + "Welcome to Dungeon Adventure!\n" + ANSI_RESET);
    }

    public void updateView(String view){
        if(view.equalsIgnoreCase("No room")){
            System.out.println(ANSI_RED + "There is nowhere to go in that direction, try another direction." + ANSI_RESET);
        }
        else {
            this.view = view.replaceAll("[.?!]\\s?", "$0\n");
        }
    }

    public void wrongCommand(){
        System.out.println(ANSI_RED + "Please only enter the commands given." + ANSI_RESET);
    }

    public void hasVisited(){
        System.out.println(ANSI_BLUE + "This place seems familiar, you have been here before!" + ANSI_RESET);
    }

    public void updateSearch(String search){
        System.out.println(ANSI_BLUE + search + ANSI_RESET);
    }
}
