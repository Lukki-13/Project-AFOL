public enum AFOLRegion {
    DE("de-de");

    private String regioncode_url;

    private AFOLRegion(String regioncode_url) {
        this.regioncode_url = regioncode_url;
    }

    public String getRegioncode() {
        return regioncode_url;
    }
}
