/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年4月29日 上午12:00:05   
 * @version 1.0   
 */
package tw.com.as.sagautils.models.models;

import tw.com.as.sagautils.utils.CaptureMediaUtil.MediaData;
import tw.com.as.sagautils.utils.CaptureMediaUtil.MediaType;

public enum SceneryType {
	none,
	image,
	video;
	
	public static SceneryType create(MediaData data){
		if(data.mediaType == MediaType.image){
			return image;
		}else if(data.mediaType == MediaType.video){
			return video;
		}
		return none;
	}
}
