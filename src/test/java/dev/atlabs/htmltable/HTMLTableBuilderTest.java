package dev.atlabs.htmltable;


import org.junit.Assert;
import org.junit.Test;

public class HTMLTableBuilderTest
{
    @Test
    public void htmlBuilderTest(){
        String html  = "<table>\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th>1H</th><th>2H</th><th>3H</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>1</td><td>2</td><td>3</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>4</td><td>5</td><td>6</td>\n" +
                "\t\t</tr>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<td>7</td><td>8</td><td>9</td>\n" +
                "\t\t</tr>\n" +
                "\t</tbody>\n" +
                "</table>";

        HTMLTableBuilder htmlBuilder = new HTMLTableBuilder(true, 3);
        htmlBuilder.addTableHeader("1H", "2H", "3H");
        htmlBuilder.addRowValues("1", "2", "3");
        htmlBuilder.addRowValues("4", "5", "6");
        htmlBuilder.addRowValues("7", "8", "9");
        String table = htmlBuilder.build();
        Assert.assertEquals(table, html);
    }
}
