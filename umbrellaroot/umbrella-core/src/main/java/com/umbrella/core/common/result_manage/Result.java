package com.umbrella.core.common.result_manage;

public class Result<T> {

	/**
	 * 成功，无参
	 * @return
	 */
	public static ResultVO success(){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(ResultEnum.SUCCESS.getMsg());
		resultVO.setResultData(null);
		return resultVO;
	}

	/**
	 * 成功，带返回数据
	 * @param object
	 * @return
	 */
	public static ResultVO success(Object object){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(ResultEnum.SUCCESS.getMsg());
		resultVO.setResultData(object);
		return resultVO;
	}

	/**
	 * 成功，带返回信息
	 * @param message
	 * @return
	 */
	public static ResultVO success(String message){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(null == message?"":message);
		resultVO.setResultData(null);
		return resultVO;
	}

	/**
	 *成功，带返回数据，带返回信息
	 * @param object
	 * @param message
	 * @return
	 */
	public static ResultVO success(Object object,String message){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(null == message?ResultEnum.SUCCESS.getMsg():message);
		resultVO.setResultData(object);
		return resultVO;
	}

	/**
	 * 失败，无参
	 * @return
	 */
	public static ResultVO error(){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(ResultEnum.SUCCESS.getMsg());
		resultVO.setResultData(null);
		return resultVO;
	}

	/**
	 * 失败，带返回数据
	 * @param object
	 * @return
	 */
	public static ResultVO error(Object object){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(ResultEnum.SUCCESS.getMsg());
		resultVO.setResultData(object);
		return resultVO;
	}

	/**
	 * 失败，带返回信息
	 * @param message
	 * @return
	 */
	public static ResultVO error(String message){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(null == message?"":message);
		resultVO.setResultData(null);
		return resultVO;
	}

	/**
	 *失败，带返回数据，带返回信息
	 * @param object
	 * @param message
	 * @return
	 */
	public static ResultVO error(Object object,String message){
		ResultVO resultVO = new ResultVO();
		resultVO.setResultCode(ResultEnum.SUCCESS.getCode());
		resultVO.setResultMessage(null == message?ResultEnum.SUCCESS.getMsg():message);
		resultVO.setResultData(object);
		return resultVO;
	}
}
