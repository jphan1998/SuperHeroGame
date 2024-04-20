package View;

public class GameView {

    public void welcome(){
        System.out.println("Welcome to Dungeon Adventure!");
    }

    public void updateView(String view){
        System.out.println(view.replaceAll("[.?!]\\s?","$0\\n"));
    }
}
