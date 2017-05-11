/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年5月2日 下午6:33:47   
 * @version 1.0   
 */
package tw.com.as.sagautils.models.events;

import tw.com.as.sagautils.db.TrackPoint;

public class EventNewTrackPoint {

	public TrackPoint newPoint;

	public EventNewTrackPoint(TrackPoint newPoint) {
		super();
		this.newPoint = newPoint;
	}
	
}
