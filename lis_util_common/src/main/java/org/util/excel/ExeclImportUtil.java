package org.util.excel;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * excel解析工具类 
 * @author Administrator
 *
 */
public class ExeclImportUtil {  
    private static Logger logger  = Logger.getLogger(ExeclImportUtil.class);
    private final static String xls = "xls";  
    private final static String xlsx = "xlsx";  
       
    /**
     * 读入excel文件，解析后返回 
     * @Title readExcel 
     * @param file
     * @return
     * @throws IOException  
     * @return List<List<String[]>> 第一個位置返回正常的数据 第二个位置返回错误的位置
     * @author xulf
     * @date 2018年6月25日 下午5:01:20
     */
    public static List<List<String[]>> readExcel(MultipartFile file) throws IOException{
        //检查文件  
        checkFile(file);  
        //获得Workbook工作薄对象  
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回  
        List<List<String[]>> allList = new ArrayList<>();
        List<String[]> trueList = new ArrayList<String[]>();
        //检测错误行
        List<String[]> errorList = new ArrayList<>();
        Integer totalSize = 0;
        if(workbook != null){  
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){  
                //获得当前sheet工作表  
                Sheet sheet = workbook.getSheetAt(sheetNum);
                if(sheet == null){  
                    continue;  
                }
                //获得当前sheet的开始行  
                int firstRowNum  = sheet.getFirstRowNum();
                //获得第一行的列数
            	int firstRowCellNum  = 0;
                //获得当前sheet的结束行  
                int lastRowNum = sheet.getLastRowNum();
                if (lastRowNum > firstRowNum) {
                	//获得第一行的列数
                	firstRowCellNum = sheet.getRow(firstRowNum).getPhysicalNumberOfCells();
				}
                boolean flag = false;
                //循环除了第一行的所有行  
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){
                    //获得当前行  
                	flag = false;
                    Row row = sheet.getRow(rowNum);
                    if(row == null || "".equals(getCellValue(row.getCell(0)))){  
                        continue;  
                    }  
                    totalSize++;
                    //获得当前行的开始列  
                    int firstCellNum = row.getFirstCellNum();  
                    //获得当前行的列数  
                    int lastCellNum = row.getPhysicalNumberOfCells();
                    String[] cells = new String[firstRowCellNum];  
                    //循环当前行  
                    for(int cellNum = firstCellNum; cellNum < firstRowCellNum;cellNum++){
                        Cell cell = row.getCell(cellNum);
                        cells[cellNum] = getCellValue(cell);
                        if ("".equals(cells[cellNum])) {
							flag = true;
						}
                    }
                    if (flag) {
                    	errorList.add(cells);
						continue;
					}
                    trueList.add(cells);
                }  
            }  
            //workbook.close();
        }  
        String[] str = new String[1];
        str[0] = totalSize.toString();
        trueList.add(str);
        allList.add(trueList);
        allList.add(errorList);
        return allList;
    }  
    public static void checkFile(MultipartFile file) throws IOException{
        //判断文件是否存在  
        if(null == file){  
            logger.error("文件不存在！");  
            throw new FileNotFoundException("文件不存在！");  
        }  
        //获得文件名  
        String fileName = file.getOriginalFilename();  
        //判断文件是否是excel文件  
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){  
            logger.error(fileName + "不是excel文件");  
            throw new IOException(fileName + "不是excel文件");  
        }  
    }  
    public static Workbook getWorkBook(MultipartFile file) {
        //获得文件名  
        String fileName = file.getOriginalFilename();  
        //创建Workbook工作薄对象，表示整个excel  
        Workbook workbook = null;
        try {  
            //获取excel文件的io流  
            InputStream is = file.getInputStream();  
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象  
            if(fileName.endsWith(xls)){  
                //2003  
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith(xlsx)){  
                //2007  
                workbook = new XSSFWorkbook(is);
            }  
        } catch (IOException e) {  
            logger.info(e.getMessage());  
        }  
        return workbook;  
    }  
    public static String getCellValue(Cell cell){
        String cellValue = "";  
        if(cell == null){  
            return cellValue;  
        }  
        //把数字当成String来读，避免出现1读成1.0的情况  
        /*if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){  
            cell.setCellType(Cell.CELL_TYPE_STRING);  
        }*/
        //判断数据的类型  
        switch (cell.getCellType()){  
            case Cell.CELL_TYPE_NUMERIC: //数字
                cellValue = String.valueOf(Long.valueOf((long) cell.getNumericCellValue()));  
                break;  
            case Cell.CELL_TYPE_STRING: //字符串
                cellValue = String.valueOf(cell.getStringCellValue());  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: //Boolean
                cellValue = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_FORMULA: //公式
                cellValue = String.valueOf(cell.getCellFormula());  
                break;  
            case Cell.CELL_TYPE_BLANK: //空值
                cellValue = "";  
                break;  
            case Cell.CELL_TYPE_ERROR: //故障
                cellValue = "非法字符";  
                break;  
            default:  
                cellValue = "未知类型";  
                break;  
        }  
        return cellValue;  
    }  
}
