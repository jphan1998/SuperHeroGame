/* Class created by Jimmy
 * Most Methods Created by Jimmy
 * Item View Methods (Use,Consume,Equip) created by Kevin
 * EncounterMonster, Win, Lose, NoMonster created by Ash
 */
package View;

public class GameView {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_PURPLE = "\u001B[35m";
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

    public void lockedRoom(){
        System.out.println(ANSI_RED + "This direction is blocked off! You may need to complete a task to unlock it." + ANSI_RESET);
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

    public void displayPuzzle(String name, String desc){
        System.out.println(ANSI_BLUE + name + ANSI_RESET);
        System.out.println(ANSI_CYAN + desc.replaceAll("[.?!]\\s?", "$0\n") + ANSI_RESET);
    }
    public void displayHint(String hint){
        System.out.println(ANSI_CYAN + hint.replaceAll("[.?!]\\s?", "$0\n") + ANSI_RESET);
    }

    public void stats(int HP, int CR){
        System.out.println(ANSI_CYAN + "Current Status:" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "HP: " + HP + ANSI_RESET);
        System.out.println(ANSI_GREEN + "CR: " + CR + ANSI_RESET);
    }

    public void puzzleResults(String result){
        if(result.equalsIgnoreCase("Solved")){
            System.out.println(ANSI_GREEN + "You did it! You solved the puzzle!" + ANSI_RESET);
        }
        if(result.equalsIgnoreCase("Failed")){
            System.out.println(ANSI_RED + "You have failed the puzzle, please try it again later." + ANSI_RESET);
        }
        if(result.equalsIgnoreCase("NoItem")){
            System.out.println(ANSI_RED + "You do not have this item in your inventory! Please retrieve it before you can use it here." + ANSI_RESET);
        }
        if(result.equalsIgnoreCase("use")){
            System.out.println(ANSI_RED + "Please try use the item! (Put Use in front of the item)." + ANSI_RESET);
        }
    }

    public void noPuzzle(){
        System.out.println(ANSI_RED + "There is no puzzle here!" + ANSI_RESET);
    }
    public void isLocked(boolean locked){
        System.out.println("It is " + locked);
    }

    public void equip(String item){
        if(item.equalsIgnoreCase("Wrong")){
            System.out.println(ANSI_RED + "You cannot equip that item! Try a different one!" + ANSI_RESET);
        }else{
            System.out.println(ANSI_BLUE + "You have successfully equipped: " + item + ANSI_RESET);
        }
    }

    public void noItem(){
        System.out.println(ANSI_RED + "There is no item with that name!" + ANSI_RESET);
    }

    public void useItem(String item){
        if(item.equalsIgnoreCase("Success")){
            System.out.println(ANSI_BLUE + "You have gone to the new floor." + ANSI_RESET);
        }
        if(item.equalsIgnoreCase("Hint")){
            System.out.println(ANSI_BLUE + "This might help with the puzzle!" + ANSI_RESET);
        }
        if(item.equalsIgnoreCase("NoPuzzle")){
            System.out.println(ANSI_RED + "There is no puzzle here!" + ANSI_RESET);
        }
        if(item.equalsIgnoreCase("sneak")){
            System.out.println(ANSI_BLUE + "It looks like you can now sneak past the Banshee, use this opportunity to get to the next room!" + ANSI_RESET);
        }
    }

    public void con(String item){
        if(item.equalsIgnoreCase("Heal")){
            System.out.println(ANSI_GREEN + "You healed some HP back." + ANSI_RESET);
        }else if(item.equalsIgnoreCase("Nothing")){
            System.out.println(ANSI_RED + "Nothing happens." + ANSI_RESET);
        }
    }

    public void invHead(){
        System.out.println(ANSI_CYAN + "Inventory" + ANSI_RESET);
        System.out.println(ANSI_BLUE + "--------------------------------------------" + ANSI_RESET);
    }

    public void viewInv(String item){
        System.out.println(ANSI_BLUE + item + ANSI_RESET);
    }

    public void emptyInv(){
        System.out.println(ANSI_RED + "There is nothing in your inventory!" + ANSI_RESET);
    }

    public void pickUp(String name){
        System.out.println(ANSI_BLUE + "You have successfully picked up " + name + ANSI_RESET);
    }
    public void drop(String name){
        System.out.println(ANSI_BLUE + "You have successfully dropped " + name + ANSI_RESET);
    }
    public void examine(String name){
        System.out.println(ANSI_BLUE + "You examine the item.." + '\n' + name +  ANSI_RESET);
    }

    public void notInv(){
        System.out.println(ANSI_RED + "You do not have that item in your inventory." + ANSI_RESET);
    }
    public void noTorch(){ System.out.println(ANSI_RED + "The puzzles are too hard to decipher in this lighting, maybe you need a light source in your inventory!" + ANSI_RESET);}
    public void loadGame(){
        System.out.println(ANSI_CYAN + "The game has loaded successfully!" + ANSI_RESET);
    }
    public void saveGame(){
        System.out.println(ANSI_CYAN + "The game has successfully been saved!" + ANSI_RESET);
    }
    public void encounterMonster()
    {
        System.out.println(ANSI_PURPLE +"You encountered a " + ANSI_RESET + "!");
    }
    public void win()
    {
        System.out.println(ANSI_RED + "You won and the monster has gone!" + ANSI_RESET);
    }

    public void flee()
    {
        System.out.println(ANSI_RED + "You have fled to the previous room.\nYou can go back to the room and fight again!" + ANSI_RESET);
    }
    public void noMonster()
    {
        System.out.println(ANSI_RED + "No such monster in this room!" + ANSI_RESET);
    }
    public void selectionDefeat(){
        System.out.println("Load: Load Game to a previously saved point.\nExit: Quit Game.");
    }
    public void goodBye(){
        System.out.println(ANSI_CYAN + "Goodbye!\nThank" + ANSI_RESET);
    }
}
