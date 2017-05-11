/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年5月4日 下午10:23:38   
 * @version 1.0   
 */
package tw.com.as.sagautils.models.events;

import tw.com.as.sagautils.db.Scenery;

public class EventNewScenery {

	public Scenery scenery;

	public EventNewScenery(Scenery scenery) {
		super();
		this.scenery = scenery;
	}
	
}
