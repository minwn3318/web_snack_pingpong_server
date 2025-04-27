package shooting_miner.example.web_snack_pingpong_server.controller;

public class MaxRankTireRecord {
    private String userId;
    private String maxRank;
    private String maxScore;
    private String maxStage;

    public MaxRankTireRecord(String userId, String maxRank2, String maxScore2, String maxStage2) {
        this.userId = userId;
        this.maxRank = maxRank2;
        this.maxScore = maxScore2;
        this.maxStage = maxStage2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMaxRank() {
        return maxRank;
    }

    public void setMaxRank(String maxRank) {
        this.maxRank = maxRank;
    }

    public String getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    public String getMaxStage() {
        return maxStage;
    }

    public void setMaxStage(String maxStage) {
        this.maxStage = maxStage;
    }
}
