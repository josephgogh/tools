package com.custom.wps;

import org.apache.poi.xwpf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * word操作
 */
public class Word {

    protected XWPFDocument doc;
    protected String wordName;

    public Word(String wordName, String path) throws IOException {
        this.wordName = wordName;
        importWord(path);
    }

    protected void importWord(String filePath) throws IOException {
        InputStream is = null;
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        is = new FileInputStream(file);
        createWork(is, isWord2003(filePath) ? true : false);
        is.close();
        if (is != null) {
            is.close();
        }
    }

    protected void createWork(InputStream inputStream, boolean isWord2003) throws IOException {
        doc = new XWPFDocument(inputStream);
    }

    //检查是否为word格式
    protected void validateExcel(String filePath) {
        if (filePath == null
                || !(isWord2003(filePath) || isWord2007(filePath))) {
            throw new RuntimeException("文件名不是word格式");
        }
    }

    protected boolean isWord2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(doc)$");
    }
    protected boolean isWord2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(docx)$");
    }


    public void exportText() {
        for(XWPFParagraph p : doc.getParagraphs())//遍历段落
        {
            System.out.println(p.getParagraphText());
        }
    }

    public void changeWord(Map<String, String> map) {
        /**
         * 替换段落中的指定文字
         */
        Iterator<XWPFParagraph> itPara = doc.getParagraphsIterator();
        while (itPara.hasNext()) {
            XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                List<XWPFRun> run=paragraph.getRuns();
                for(int i=0;i<run.size();i++)
                {
                    if(run.get(i).getText(run.get(i).getTextPosition())!=null)
                    {
                        String value = run.get(i).getText(run.get(i).getTextPosition());
                        run.get(i).setText(value.replace(key, map.get(key)),0);
                    }
                }
            }
        }

        /**
         * 替换表格中的指定文字
         */
        Iterator<XWPFTable> itTable = doc.getTablesIterator();
        while (itTable.hasNext()) {
            XWPFTable table = (XWPFTable) itTable.next();
            int count = table.getNumberOfRows();
            for (int i = 0; i < count; i++) {
                XWPFTableRow row = table.getRow(i);
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    for (Map.Entry<String, String> e : map.entrySet()) {
                        if (cell.getText().equals(e.getKey())) {
                            cell.removeParagraph(0);
                            cell.setText(e.getValue());
                        }
                    }
                }
            }
        }
    }

    public void exportWord(String filePath) throws IOException {
        //生成新的word
        File file = new File(filePath);
        FileOutputStream stream = new FileOutputStream(filePath);
        doc.write(stream);
        stream.close();
    }

    public void exportWord(HttpServletResponse response) throws IOException{
        response.reset();
        response.setContentType("application/vnd.ms-word"); // 改成输出word文件
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(wordName.getBytes("gb2312"), "ISO-8859-1") + ".docx");
        OutputStream ouputStream = response.getOutputStream();
        doc.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

}
