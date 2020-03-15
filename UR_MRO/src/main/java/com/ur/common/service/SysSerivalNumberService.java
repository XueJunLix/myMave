package com.ur.common.service;

import com.ur.common.Constants;
import com.ur.common.DateTools;
import com.ur.common.mappers.SysSerialNumberMapper;
import com.ur.common.model.SysSerialNumber;
import com.ur.common.util.ZStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lesng on 2015/7/23.
 */
@Service
public class SysSerivalNumberService extends BaseService{

    @Autowired
    SysSerialNumberMapper sysSerialNumberMapper;
    private static int jz = 10;

    public String curSerialNumber(String category) {
        return curSerialNumber(category, 1, Constants.MAX_INT, 0);
    }

    public String curSerialNumberFull(String category, int length) {
        return curSerialNumber(category, 1, Constants.MAX_INT, length);
    }

    public String curSerialNumberFull(String category, int length, int beginNum) {
        return curSerialNumberJz(category, beginNum, Constants.MAX_INT, length, jz);
    }

    public String curSerialNumberFullYYMM(String category, int length) {
        String dateYYMM = DateTools.getDateYYMM();
        return dateYYMM
                + curSerialNumber(category, 1, Constants.MAX_INT, length);
    }


    public String curSerialNumberFullYYMM(String category, int length, int beginmun) {
        String dateYYMM = DateTools.getDateYYMM();
        return dateYYMM
                + curSerialNumber(category, beginmun, Constants.MAX_INT, length);
    }

    public String curSerialNumberFullYYMMDD(String category, int length) {
        String dateYYMMDD = DateTools.getDateYYMMDD();
        return dateYYMMDD
                + curSerialNumber(category, 1, Constants.MAX_INT, length);
    }

    public String curSerialNumber(String category, int maxMum) {
        return curSerialNumber(category, 1, maxMum, 0);
    }

    public static void main(String[] args) {

    }

    public String curSerialNumber(String category, int beginNum, int maxMum,
                                  int length) {
        return curSerialNumberJz(category, beginNum, maxMum, length, jz);
    }

    public String curSerialNumberZm(String category, int beginNum, int maxMum,
                                    int length) {
        return curSerialNumberJz(category, beginNum, maxMum, length, jz);
    }
    private String curSerialNumberJz(String category, int beginNum, int maxMum,
                                     int length, int jz) {
        int lastNumber = 0;

        SysSerialNumber serialNumber = getSerialNumber(category);
        if (serialNumber == null) {
            SysSerialNumber sm = new SysSerialNumber();
            sm.setCategory(category);
            sm.setLastNumber(beginNum);
            sm.setInitialNumber(beginNum);
            sm.setMaxNumber(maxMum);
            super.setCreateFields(sm);
            sysSerialNumberMapper.insertSysSerialNumber(sm);
            lastNumber = beginNum;
        } else {
            if (serialNumber.getLastNumber().intValue() == serialNumber
                    .getMaxNumber().intValue()) {
                /*
                 * //需邮件通知到管理员 SimpleMailMessage msg = new SimpleMailMessage();
				 * msg.setFrom("jamesluo@sproconsulting.com.cn");
				 * msg.setTo("luoliuqiang@sina.com"); msg.setSubject("序列号已满通知");
				 * msg.setText(category + "为前缀的流水号已经满了。到了最大的号码:" +
				 * serialNumber.getLastNumber());
				 * simpleMailService.sendSerialNumberInfo(msg);
				 */
                return null;
            }


            lastNumber = serialNumber.getLastNumber() + 1;
            if (beginNum > lastNumber) {
                lastNumber = beginNum ;
            }

            serialNumber.setLastNumber(lastNumber);
            sysSerialNumberMapper.updateSysSerialNumberByPKSelective(serialNumber);

        }
        if (length == 0) {
            return Integer.toString(lastNumber, jz).toUpperCase();
        } else {
            return ZStringUtils.ZeroPer(Integer.toString(lastNumber, jz)
                    .toUpperCase(), length);

        }

    }

    public static String sequence(String s, int len, String s1, int lastnum) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 34; i++) {

            if (i > 9) {
                map.put(i, String.valueOf((char) (65 + i - 10)));
            } else {
                map.put(i, i + "");
            }
        }

        if (String.valueOf(lastnum).length() > len) {
            int l = 10;
            for (int i1 = 1; i1 < len - 1; i1++)
                l *= 10;

            int j1 = lastnum - l;
            char c = (char) ((65 + j1));
            String a = String.valueOf(c);
            System.out.println(a);
            return a;
        } else {
            return String.valueOf(lastnum);
        }
    }

    public SysSerialNumber getSerialNumber(String category) {

        return sysSerialNumberMapper.findByCategory(category);
    }

}
