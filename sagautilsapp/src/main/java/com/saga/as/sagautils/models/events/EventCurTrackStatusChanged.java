/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年4月30日 下午5:08:25   
 * @version 1.0   
 */
package tw.com.as.sagautils.models.events;

import tw.com.as.sagautils.db.Track;

public class EventCurTrackStatusChanged {

	public final Track track;

	public EventCurTrackStatusChanged(Track track) {
		super();
		this.track = track;
	}
}
