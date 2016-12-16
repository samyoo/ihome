package com.ihome.common.utils;

import com.ihome.common.constant.Common;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ExcelUtil {
    /**
     * read the Excel file
     *
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public static List<List<String[]>> readExcel(String path, String DateType) throws IOException {
        if (path == null || Common.EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = FileUtil.getFileExt(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(path, DateType);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(path, DateType);
                }
            } else {
                System.out.println(path + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    /**
     * Read the Excel 2010
     *
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unused")
    public static List<List<String[]>> readXlsx(String path, String DateType) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<List<String[]>> list = new ArrayList<List<String[]>>();
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            List<String[]> listSheet = new ArrayList<String[]>();
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            System.out.println("numSheet = " + numSheet);
            System.out.println("sheetValue = " + xssfSheet.getLastRowNum());
            if (xssfSheet == null) {
                continue;
            }
            if (xssfSheet.getLastRowNum() > 0) {//判断sheet是否为空
                //获取数据信息

                for (int rowCell = 1; rowCell < xssfSheet.getLastRowNum() + 1; rowCell++) {//遍历行

                    XSSFRow xsData = xssfSheet.getRow(rowCell);
                    String[] rowData = new String[xsData.getLastCellNum()];

                    for (int cellNum = 0; cellNum < xsData.getLastCellNum(); cellNum++) {//遍历列

                        XSSFCell datas = xsData.getCell(cellNum);
                        String data = "";
                        if (datas != null) {
                            if (datas.toString() != "" && isDecimal(datas.toString())) {//datas为数值类型
                                datas.setCellType(Cell.CELL_TYPE_NUMERIC);
                            }
                            data = getCellValue(datas, DateType);
                            rowData[cellNum] = data;
                        } else {
                            rowData[cellNum] = "";
                        }
                    }

                    //System.out.println("开始添加第"+rowCell+"行数据");
                    listSheet.add(rowData);
                    //System.out.println("添加第"+rowCell+"行数据完毕!  该行asin="+rowData[0]);
                }

                list.add(listSheet);
            }
        }
        return list;
    }

    //浮点型判断          整数或小数返回true
    public static boolean isDecimal(String str) {
        if (str == null || "".equals(str))
            return false;
        Pattern pattern = Pattern.compile("^(-?\\d+)(\\.\\d+)?");
        return pattern.matcher(str).matches();
    }

    /**
     * Read the Excel 2003-2007
     *
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    @SuppressWarnings("unused")
    public static List<List<String[]>> readXls(String path, String webType) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<List<String[]>> list = new ArrayList<List<String[]>>();
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            List<String[]> listSheet = new ArrayList<String[]>();
            HSSFSheet xssfSheet = hssfWorkbook.getSheetAt(numSheet);
            System.out.println("numSheet = " + numSheet);
            System.out.println("sheetValue = " + xssfSheet.getLastRowNum());
            if (xssfSheet == null) {
                continue;
            }
            if (xssfSheet.getLastRowNum() > 0) {//判断sheet是否为空
                //获取数据信息
                for (int rowCell = 1; rowCell < xssfSheet.getLastRowNum() + 1; rowCell++) {//遍历行
                    HSSFRow xsData = xssfSheet.getRow(rowCell);
                    String[] rowData = new String[xsData.getLastCellNum()];
                    //System.out.println(" 此时的asin为:" +xsData.getCell(2));
                    for (int cellNum = 0; cellNum < xsData.getLastCellNum(); cellNum++) {//遍历列

                        //System.out.println("rowCell= "+rowCell+"  cellNum=  "+cellNum);
                        if (rowCell == 84) {
                            System.out.println("~");
                        }
                        HSSFCell datas = xsData.getCell(cellNum);
                        /*datas.setCellType(Cell.CELL_TYPE_STRING);
	        			String data = datas.getStringCellValue();*/
                        if (isDecimal(datas.toString())) {//datas为数值类型
                            datas.setCellType(Cell.CELL_TYPE_NUMERIC);
                        }
                        String data = getCellValue(datas, webType);
                        rowData[cellNum] = data;
                    }
                    listSheet.add(rowData);
                }
                list.add(listSheet);
            }
        }
        return list;
    }

    @SuppressWarnings({"static-access", "unused"})
    private static String getValue(Cell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    /**
     * @param startDate
     * @param DateType  (美国   月日年"MM/dd/yyyy HH:mm"; 英国   日月年"dd/MM/yyyy HH:mm")
     * @return String 如"2015-01-01"
     */
    public  static String MMddyyTransformyyyyMMdd(String startDate, String DateType) {
        SimpleDateFormat format = new SimpleDateFormat(DateType);
        Date date = null;
        try {
            date = format.parse(startDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//有异常要捕获
        format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


    public static void main(String[] args) {
    	/*System.out.println("/11/19/2015 0:00".toString().replace("/", "").substring(0,8));
    	System.out.println(	isDecimal("/11/19/2015 0:00".toString().replace("/", "").substring(0,8)));
    	*/
        String testStr = "-11,26";
        System.out.println(isDecimal(testStr.replace(",", ".")));
    }

    //解决excel类型问题，获得数值
    public static String getCellValue(Cell cell, String DateType) {
        String value = "";
        if (null == cell) {
            return value;
        }
        switch (cell.getCellType()) {
            //数值型
            case Cell.CELL_TYPE_NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //如果是date类型则 ，获取该cell的date值
                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = format.format(date);
                    ;
                } else {// 纯数字
                    BigDecimal big = new BigDecimal(cell.getNumericCellValue());
                    value = big.toString();
                    if (null != value && !"".equals(value.trim())) {
                        if (value.indexOf(".") == -1) {
                            //解决1234.0  去掉后面的.0
                            if (null != value && !"".equals(value.trim())) {
                                String[] item = value.split("[.]");
                                if (1 < item.length && "0".equals(item[1])) {
                                    value = item[0];
                                }
                            }
                        } else {
                            //四舍五入保留四位小数点
                            value = new java.text.DecimalFormat("0.0000").format(Double.parseDouble(value));
                        }
                    }
                }
                break;
            //字符串类型
            case Cell.CELL_TYPE_STRING:
                if (cell.getStringCellValue().toString().length() == 15
                        && isDecimal(cell.getStringCellValue().toString().replace("/", "").substring(0, 8))
                        && cell.getStringCellValue().toString().indexOf("/") > 0) {//11/19/2015 0:00  是否为此类日期
                    if (DateType.equals("MMddyyyy")) {
                        DateType = "MM/dd/yyyy HH:mm";
                    } else if (DateType.equals("ddMMyyyy")) {
                        DateType = "dd/MM/yyyy HH:mm";
                    } else if (DateType.equals("yyyyMMdd")) {
                        DateType = "yyyy/MM/dd HH:mm";
                    } else {
                        DateType = "";
                        System.out.println("===========  ReadExcel case Cell.CELL_TYPE_STRING: 日期类型异常  ===========");
                    }
                    value = MMddyyTransformyyyyMMdd(cell.getStringCellValue().toString(), DateType);
                } else {
                    String initValue = cell.getStringCellValue().toString();
                    if (isDecimal(initValue.replace(",", "."))) {//法,德两国货币小数点用逗号代替
                        value = initValue.replace(",", ".");
                    } else if ("Nicht zutreffend".equals(initValue)
                            || "N/A".equals(initValue) || "該当なし".equals(initValue)
                            || "s/o".equals(initValue) || "N/D".equals(initValue)) {//为空处理
                        cell.setCellValue(0);//赋值0
                        cell.setCellType(1);//设置为数字类型
                        value = getCellValue(cell, DateType);
                        break;
                    } else {
                        value = initValue;
                    }
                }
                break;
            // 公式类型
            case Cell.CELL_TYPE_FORMULA:
                //读公式计算值
                try {
                    value = String.valueOf(cell.getNumericCellValue());
                } catch (Exception e) {
                    try {
                        value = cell.getStringCellValue().toString();
                        System.out.println("有坑货将字符串进行运算..机智的我无视了这种行为.");
                    } catch (Exception e1) {
                        System.out.println("完全看不懂的一种类型");
                        e1.printStackTrace();
                        return null;
                    }
                }
                if (value.equals("NaN")) {// 如果获取的数据值为非法值,则转换为获取字符串
                    value = cell.getStringCellValue().toString();
                }
                break;
            // 布尔类型
            case Cell.CELL_TYPE_BOOLEAN:
                value = " " + cell.getBooleanCellValue();
                break;
            // 空值
            case Cell.CELL_TYPE_BLANK:
                value = "";
                //LogUtil.getLogger().error("excel出现空值");
                break;
            // 故障
            case Cell.CELL_TYPE_ERROR:
                value = "";
                //LogUtil.getLogger().error("excel出现故障");
                break;
            default:
                value = cell.getStringCellValue().toString();
        }
        if ("null".endsWith(value.trim())) {
            value = "";
        }
        return value;
    }
}
