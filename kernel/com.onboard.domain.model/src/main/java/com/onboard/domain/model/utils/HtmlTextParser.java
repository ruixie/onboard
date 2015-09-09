package com.onboard.domain.model.utils;

import org.htmlparser.Parser;
import org.htmlparser.beans.StringBean;
import org.htmlparser.util.ParserException;

/**
 * 将HTML转化为纯文本的辅助类
 * 
 * @author lvyiqiang, yewei
 * 
 */
public class HtmlTextParser {
    public static String getPlainText(String htmlStr) {
        Parser parser = new Parser();
        String plainText = "";
        try {
            parser.setInputHTML(htmlStr);

            StringBean stringBean = new StringBean();
            // 设置不需要得到页面所包含的链接信息
            stringBean.setLinks(false);
            // 设置将不间断空格由正规空格所替代
            stringBean.setReplaceNonBreakingSpaces(true);
            // 设置将一序列空格由单一空格替代
            stringBean.setCollapse(true);

            parser.visitAllNodesWith(stringBean);
            plainText = stringBean.getStrings();

        } catch (ParserException e) {
            e.printStackTrace();
        }

        return plainText;
    }
}
