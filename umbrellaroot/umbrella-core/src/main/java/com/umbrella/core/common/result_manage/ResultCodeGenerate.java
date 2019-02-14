package com.umbrella.core.common.result_manage;


import com.umbrella.core.common.common_constant.ExceptionCodeConstant;

public class ResultCodeGenerate {

    /**
     * 生成异常码工具
     * @param prefix
     * @param suffix
     * @return
     */
    public static int generateCode(int prefix,int suffix){
        if(prefix<0 || suffix<0){
            return ExceptionCodeConstant.NULLPOINT_SYSTEM_ERROR_CODE;
        }
        return prefix * ExceptionCodeConstant.ERROR_CODE_SUFFIX_LENGTH + suffix;
    }
}
