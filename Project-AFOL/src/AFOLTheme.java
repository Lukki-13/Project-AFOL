public enum AFOLTheme {
    CLASSIC("Classic", 10000, 10999), ICONIC("Iconic", 0, 999), 
    ARCHITECTURE("Architecture", 40000, 40999), STARWARS("Star Wars", 75000, 75500), 
    HARRYPOTTER("Harry Potter", 76000, 76999), MINECRAFT("Minecraft", 21000, 21999), 
    TECHNIC("Technic", 42000, 42999), DUPLO("Duplo", 0, 999);

    private String theme;
    private int numberrange_begin;
    private int numberrange_end;

    private AFOLTheme(String theme, int numberrange_begin, int numberrange_end) {
        this.theme = theme;
        this.numberrange_begin = numberrange_begin;
        this.numberrange_end = numberrange_end;
    }

    public String getTheme() {
        return theme;
    }

    public int getRangeBegin() {
        return numberrange_begin;
    }

    public int getRangeEnd() {
        return numberrange_end;
    }
}