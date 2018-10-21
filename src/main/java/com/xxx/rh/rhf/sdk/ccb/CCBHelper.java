package com.xxx.rh.rhf.sdk.ccb;

import com.xxx.rh.rhf.sdk.ccb.internal.utils.StringUtils;

/**
 * @author lihy
 * @version 1.0  2018/8/9
 */
public final class CCBHelper {

    private CCBHelper() {
    }

    /***********************************
    | 建行状态  | 保融状态   |    解释    |
    | :------: | :------: | :--------: |
    |   0      |    3     | 失败       |
    |   1      |    2     | 成功       |
    |   2      |    4     | 待银行确认  |
    |   3      |    5     | 已部分退款  |
    |   4      |    6     | 已全额退款  |
    |   5      |    4     | 待银行确认  |
    ************************************/
    public static String mappingState(String status) {
        String result = "4";
        if (StringUtils.isBlank(status)) {
            return result;
        }
        switch (status) {
            case "1": // 成功
                result = "2";
                break;
            case "0": // 失败
                result = "3";
                break;
            case "99": // 流水不存在
                result = "99";
                break;
            case "2": // 待银行确认
            case "5":
                result = "4";
                break;
            case "3": // 已部分退款
                result = "5";
                break;
            case "4": // 已全部退款
                result = "6";
                break;
            default:
                return result;
        }
        return result;
    }
}
