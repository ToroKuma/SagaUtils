/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年4月30日 下午5:02:22   
 * @version 1.0   
 */
package tw.com.as.sagautils.models.events;

import tw.com.as.sagautils.db.Scenery;

public class EventSceneryUpdated {

	/**
	 * 如果为null，可能是更新多条风景
	 */
	public final Scenery scenery;

	public EventSceneryUpdated(Scenery scenery) {
		super();
		this.scenery = scenery;
	}
	
}
