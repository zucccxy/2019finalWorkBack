package org.util.excel;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;

/**
 * 导入execl工具类
 */
public class ImportExeclUtil {

    /**
     * 读取Sheet数据
     *
     * @param file
     * @return
     */
    public static Sheet readWorkbookFile(File file) {
        Sheet sheet = null;
        try {
            Workbook rwb = Workbook.getWorkbook(file);
            // 获取第一个工作区
            sheet = rwb.getSheet(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheet;
    }

}

