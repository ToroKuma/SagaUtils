package tw.com.as.sagautils.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtils
{
	public static final SimpleDateFormat formaterYMD = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat formaterYMDChinese = new SimpleDateFormat("yyyy年MM月dd日");
	public static final SimpleDateFormat formaterYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat formaterYMDHM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat formaterYMDHMSChinese = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	public static final SimpleDateFormat formaterYMDHMChinese = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
	
	public static final SimpleDateFormat formaterHM = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat formaterHMS = new SimpleDateFormat("HH:mm:ss");
	public static final SimpleDateFormat formaterHMSChinese = new SimpleDateFormat("HH小时 mm分 ss秒");

	public static final SimpleDateFormat formaterYMDHMSFile = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	public static final SimpleDateFormat formaterYMDFile = new SimpleDateFormat("yyyy_MM_dd");
	
	/**
	 * @description: "yyyy-MM-dd"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDateYMD(long time)
	{
	    if(time < 1){
	        return "";
	    }
		Date data = new Date(time);
        return formaterYMD.format(data);
	}
	
	/**
	 * @description: "yyyy年MM月dd日"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDateYMDChinese(long time)
	{
	    if(time < 1){
            return "";
        }
		Date data = new Date(time);
        return formaterYMDChinese.format(data);
	}
	
	/**
	 * @description: "yyyy-MM-dd HH:mm:ss"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDateYMDHMS(long time)
	{
	    if(time < 1){
            return "";
        }
		Date data = new Date(time);
        return formaterYMDHMS.format(data);
	}
	
	/**
	 * @description: yyyy_MM_dd_HH_mm_ss
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDateYMDHMSFile(long time)
	{
	    if(time < 1){
            return "";
        }
		Date data = new Date(time);
        return formaterYMDHMSFile.format(data);
	}

	/**
	 * @description: getFormatedDateNow
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @return
	 */
	public static String getFormatedDateNow(SimpleDateFormat dateFormat)
	{
		return dateFormat.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * @description: "yyyy-MM-dd HH:mm"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDateYMDHM(long time)
	{
	    if(time < 1){
            return "";
        }
		Date data = new Date(time);
        return formaterYMDHM.format(data);
	}
	
	/**
	 * @description: "yyyy年MM月dd日  HH时mm分ss秒"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDateYMDHMSChinese(long time)
	{
	    if(time < 1){
            return "";
        }
		Date data = new Date(time);
        return formaterYMDHMSChinese.format(data);
	}
	
	/**
     * @description: "yyyy年MM月dd日  HH时mm分"
     * @author: chenshiqiang E-mail:csqwyyx@163.com
     * @param time
     * @return
     */
    public static String getFormatedDateYMDHMChinese(long time)
    {
        if(time < 1){
            return "";
        }
        Date data = new Date(time);
        return formaterYMDHMChinese.format(data);
    }
	
	/**
	 * @description: "HH:mm:ss"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDataHMS(long time)
	{
	    if(time < 1){
            return "";
        }
        return formaterHMS.format(time);
	}
	
	/**
	 * @description: "HH:mm"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDataHM(long time)
	{
	    if(time < 1){
            return "";
        }
        return formaterHM.format(time);
	}
	
	/**
	 * @description: "HH小时 mm分 ss秒"
	 * @author: chenshiqiang E-mail:csqwyyx@163.com
	 * @param time
	 * @return
	 */
	public static String getFormatedDataHMSChinese(long time)
	{
	    if(time < 1){
            return "";
        }
        return formaterHMSChinese.format(time);
	}
	
}
