package util;

public class RAEDailyWorld extends HttpClient{

    private static final String RAE_ROOT_URL = "http://dle.rae.es/";
    private static final String DAILY_WORLD_URL = "http://dle.rae.es/srv/wotd";

    private String dailyWorld;
    private String dailyWorldDefinition;
    private String dailyWorldUrl;

    public RAEDailyWorld(){
        loadDailyWorld();
    }

    public void loadDailyWorld(){
        // Format: <a href="id=QASpmXw">mutis.</a>
        String httpResponse = this.retireveWebContent(DAILY_WORLD_URL);
        int indexBeforeWord = httpResponse.indexOf(">");
        int indexAfterWord = httpResponse.indexOf(".");
        String word = httpResponse.substring(indexBeforeWord + 1, indexAfterWord);
        this.setDailyWorld(word);

        // Load definition
        //int indexBeforUrlDefinition = httpResponse.indexOf("\"");
        //int indexAfterUrlDefinition = httpResponse.lastIndexOf("\"");
        //String definitionUrl = RAE_ROOT_URL + httpResponse.substring(indexBeforUrlDefinition, indexAfterUrlDefinition);
        this.setDailyWorldUrl(RAE_ROOT_URL + this.getDailyWorld());
        //loadDefinition(definitionUrl);
    }

    public void loadDefinition(String definitionUrl){
        String httpResponse = this.retireveWebContent(definitionUrl);
        // TODO
    }


    // GETTERS & SETTERS
    public String getDailyWorld() {
        return dailyWorld;
    }

    public void setDailyWorld(String dailyWorld) {
        this.dailyWorld = dailyWorld;
    }

    public String getDailyWorldDefinition() {
        return dailyWorldDefinition;
    }

    public void setDailyWorldDefinition(String dailyWorldDefinition) {
        this.dailyWorldDefinition = dailyWorldDefinition;
    }

    public String getDailyWorldUrl() {
        return dailyWorldUrl;
    }

    public void setDailyWorldUrl(String dailyWorldUrl) {
        this.dailyWorldUrl = dailyWorldUrl;
    }
}
