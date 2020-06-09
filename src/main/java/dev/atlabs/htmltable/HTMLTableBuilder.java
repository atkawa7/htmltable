package dev.atlabs.htmltable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class HTMLTableBuilder {
    private static final String TABLE_START = "<table>\n";
    private static final String TABLE_END = "</table>";
    private static final String HEADER_START = "<th>";
    private static final String HEADER_END = "</th>";
    private static final String ROW_START = "\t\t<tr>\n\t\t\t";
    private static final String ROW_END = "\n\t\t</tr>\n";
    private static final String COLUMN_START = "<td>";
    private static final String COLUMN_END = "</td>";
    private static final String THEAD_START = "\t<thead>\n";
    private static final String THEAD_END = "\t</thead>\n";
    private static final String TBODY_START = "\t<tbody>\n";
    private static final String TBODY_END = "\t</tbody>\n";

    private static final Logger logger = Logger.getLogger(HTMLTableBuilder.class.getSimpleName());
    private final StringBuilder table = new StringBuilder();
    private final int columns;

    public HTMLTableBuilder(boolean border, int columns) {
        this.columns = columns;
        table.append(TABLE_START);
        table.append(TABLE_END);
    }

    /**
     * @param values
     */
    public void addTableHeader(String... values) {
        if (Objects.isNull(values) || values.length != columns) {
            logger.warning("Column length is not the same as values length");
        } else {
            addTableHeader(Arrays.asList(values));
        }
    }

    public void addTableHeader(List<String> values) {
        if (Objects.isNull(values) || values.size() != columns) {
            logger.warning("Column length is not the same as values length");
        } else {
            int lastIndex = table.lastIndexOf(TABLE_END);
            if (lastIndex >= 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(THEAD_START);
                sb.append(ROW_START);
                for (String value : values) {
                    sb.append(HEADER_START);
                    sb.append(value);
                    sb.append(HEADER_END);
                }
                sb.append(ROW_END);
                sb.append(THEAD_END);
                sb.append(TBODY_START);
                sb.append(TBODY_END);
                table.insert(lastIndex, sb.toString());
            }
        }
    }

    public void addRowValues(String... values) {
        if (Objects.isNull(values) || values.length != columns) {
            logger.warning("Column length is not the same as values length");
        } else {
            addRowValues(Arrays.asList(values));
        }
    }

    public void addRowValues(List<String> values) {
        if (Objects.isNull(values) || values.size() != columns) {
            logger.warning("Column length is not the same as values length");
        } else {
            int lastIndex = table.lastIndexOf(TBODY_END);
            if (lastIndex > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(ROW_START);
                for (String value : values) {
                    sb.append(COLUMN_START);
                    sb.append(value);
                    sb.append(COLUMN_END);
                }
                sb.append(ROW_END);
                table.insert(lastIndex, sb.toString());
            }
        }
    }
    public String build() {
        return table.toString();
    }

}
