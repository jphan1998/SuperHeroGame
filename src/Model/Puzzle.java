package Model;

public class Puzzle {
    String name;
    String desc;
    String hint;
    String solution;
    int attempts;
    String unlockRoom;

    public Puzzle(String aName, String aDesc, String aHint, String aSolution, int aAttempts, String aUnlock){
        this.name = aName;
        this.desc = aDesc;
        this.hint = aHint;
        this.solution = aSolution;
        this.attempts = aAttempts;
        this.unlockRoom = aUnlock;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getUnlockRoom() {
        return unlockRoom;
    }

    public void setUnlockRoom(String unlockRoom) {
        this.unlockRoom = unlockRoom;
    }
}
