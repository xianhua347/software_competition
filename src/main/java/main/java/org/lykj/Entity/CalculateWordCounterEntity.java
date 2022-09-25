package main.java.org.lykj.Entity;

public class CalculateWordCounterEntity {
    private int wordCount;

    private int characterCount;

    private int chineseCount ;

    private int upCaseCount;

    private int lowCaseCount;

    private int figureCount;

    private int spaceCount;

    private int symbolCount;

    private int lineCount;

    public CalculateWordCounterEntity() {
    }

    public int getUpCaseCount() {
        return upCaseCount;
    }

    public void setUpCaseCount(int upCaseCount) {
        this.upCaseCount = upCaseCount;
    }

    public int getLowCaseCount() {
        return lowCaseCount;
    }

    public void setLowCaseCount(int lowCaseCount) {
        this.lowCaseCount = lowCaseCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }

    public int getChineseCount() {
        return chineseCount;
    }

    public void setChineseCount(int chineseCount) {
        this.chineseCount = chineseCount;
    }

    public int getUpCase() {
        return upCaseCount;
    }

    public void upCaseCount(int upCaseCount) {
        this.upCaseCount = upCaseCount;
    }

    public int getFigureCount() {
        return figureCount;
    }

    public void setFigureCount(int figureCount) {
        this.figureCount = figureCount;
    }

    public int getSpaceCount() {
        return spaceCount;
    }

    public void setSpaceCount(int spaceCount) {
        this.spaceCount = spaceCount;
    }

    public int getSymbolCount() {
        return symbolCount;
    }

    public void setSymbolCount(int symbolCount) {
        this.symbolCount = symbolCount;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    @Override
    public String toString() {
        return " 字符数量统计：" +"\n"+
                "wordCount=" + wordCount +"\n"+
                "characterCount=" + characterCount +"\n"+
                "chineseCount=" + chineseCount +"\n"+
                "upCaseEnglishWordCount=" + upCaseCount +"\n"+
                "lowCaseEnglishWordCount=" + lowCaseCount +"\n"+
                "figureCount=" + figureCount +"\n"+
                "spaceCount=" + spaceCount +"\n"+
                "symbolCount=" + symbolCount +"\n"+
                "lineCount=" + lineCount +"\n";
    }
}
