package main.java.org.lykj;

import main.java.org.lykj.Entity.CalculateWordCounterEntity;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/**
 * 计算字符串中的 字数 字符 中文 大小写 数字 符号 换行个数
 */
public class CalculateWordCounter {

    int wordCount;

    int characterCount ;

    int chineseCount;

    int upCaseCount ;

    int lowCaseCount ;

    int figureCount ;

    int spaceCount ;

    int symbolCount ;

    //换行符
    int lineCount;

    /**
     * @param str
     * @return counterEntity 数据包装类
     */
    public CalculateWordCounterEntity calculateWordCount(String str) {

        //创建实体类来包装计算的数据
        final CalculateWordCounterEntity counterEntity = new CalculateWordCounterEntity();

        wordCount = str.length();

        characterCount = 0;

         chineseCount = 0;

         upCaseCount = 0;

         lowCaseCount = 0;

         figureCount = 0;

         spaceCount = 0;

         symbolCount = 0;

        //换行符
         lineCount = 0;


        for (int i = 0; i < str.length(); i++) {

            //截取每一个字符，以便判断类型
            final String tempStr = str.substring(i, i + 1);

            try {
                //转换到Byte类型 统计有多少个Byte
                characterCount += tempStr.getBytes("GBK").length;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }

            //逻辑判断字符类型
            if (isEnter(tempStr)) {
                lineCount++;
            } else if (isChinese(tempStr)){
                chineseCount++;
            }else if(isFigure(tempStr)){
                figureCount++;
            }else if (isEnglishUpCase(tempStr)){
                upCaseCount++;
            }else if (isEnglishLowCase(tempStr)){
                lowCaseCount++;
            }else if (isSpace(tempStr)){
                spaceCount++;
            }else {
                symbolCount++;
            }
        }
        //数据set到实体类
        counterEntity.setWordCount(wordCount);
        counterEntity.setChineseCount(chineseCount);
        counterEntity.setCharacterCount(characterCount);
        counterEntity.setFigureCount(figureCount);
        counterEntity.setLineCount(lineCount);
        counterEntity.setUpCaseCount(upCaseCount);
        counterEntity.setLowCaseCount(lowCaseCount);
        counterEntity.setSpaceCount(spaceCount);
        counterEntity.setSymbolCount(symbolCount);
        return counterEntity;
    }

    /**
     * 判断是否为中文
     * @param str
     * @return boolean
     */
    private boolean isChinese(String str) {
        String pattern = "^[\\u4E00-\\u9FA5]+$";
        return Pattern.matches(pattern, str);
    }

    /**
     * 判断是否为英文小写
     * @param str
     * @return boolean
     */
    private boolean isEnglishLowCase(String str) {
        String patten = "^[a-z]+$";
        return Pattern.matches(patten, str);
    }

    /**
     * 判断是否为英文大写
     * @param str
     * @return boolean
     */
    private boolean isEnglishUpCase(String str) {
        String patten = "^[A-Z]+$";
        return Pattern.matches(patten, str);
    }

    /**
     * 判断是否为数字
     * @param str
     * @return boolean
     */
    private boolean isFigure(String str) {
        String patten = "^[0-9]+$";
        return Pattern.matches(patten, str);
    }

    /**
     * 判断是否为为空格
     * @param str
     * @return boolean
     */
    private boolean isSpace(String str) {
        String patten = "\\s";
        return Pattern.matches(patten, str);
    }

    /**
     * 判断是否为回车
     * @param str
     * @return boolean
     */
    private boolean isEnter(String str) {
        String patten = "\\r";
        return Pattern.matches(patten, str);
    }

    public CalculateWordCounterEntity calculateWordWithInterUtils(String str){

        final CalculateWordCounterEntity counterEntity = new CalculateWordCounterEntity();

        wordCount = str.length();

        figureCount = 0;

        lowCaseCount = 0;

        upCaseCount = 0;

        spaceCount = 0;

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)){
                figureCount++;
            }else if (Character.isUpperCase(c)){
                upCaseCount++;
            }else if (Character.isLowerCase(c)){
                lowCaseCount++;
            }else if (Character.isWhitespace(c)){
                spaceCount++;
            }
        }

        counterEntity.setWordCount(wordCount);
        counterEntity.setLowCaseCount(lowCaseCount);
        counterEntity.setUpCaseCount(upCaseCount);
        counterEntity.setFigureCount(figureCount);
        counterEntity.setSpaceCount(spaceCount);
        return counterEntity;
    }

}
