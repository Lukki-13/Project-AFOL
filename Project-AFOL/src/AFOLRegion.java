public enum AFOLRegion {
    DE("Deutschland", "de-de");

    private String region;
    private String regioncode_url;

    private AFOLRegion(String region, String regioncode_url) {
        this.region = region;
        this.regioncode_url = regioncode_url;
    }

    public String getRegion() {
        return region;
    }

    public String getRegioncode() {
        return regioncode_url;
    }
}
