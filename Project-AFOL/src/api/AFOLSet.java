public class AFOLSet {
    
    private int setnumber;
    private String setname;
    private AFOLTheme theme;
    private int parts;

    private boolean exclusive = false;
    
    private short age;
    private int vippoints;

    public AFOLSet(int setnumber, String setname, AFOLTheme theme, int parts, 
                   boolean exclusive, short age, int vippoints) {
        this.setnumber = setnumber;
        this.setname = setname;
        this.theme = theme;
        this.parts = parts;
        this.exclusive = exclusive;
        this.age = age;
        this.vippoints = vippoints;
    }

    public int getSetnumber() {
        return setnumber;
    }

    public String getSetname() {
        return setname;
    }

    public AFOLTheme getTheme() {
        return theme;
    }
    
    public int getParts() {
        return parts;
    }

    public boolean isExclusive() {
        return exclusive;
    }

    public short getAge() {
        return age;
    }

    public int getVIPpoints() {
        return vippoints;
    }

}