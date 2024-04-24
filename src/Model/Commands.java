package Model;

public class Commands {
    private int id;
    private String name;

    private String desc;

    public Commands(int aID, String aName, String aDesc){
        this.id = aID;
        this.name = aName;
        this.desc = aDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

}
