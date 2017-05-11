/**
 * @description: 
 * @author chenshiqiang E-mail:csqwyyx@163.com
 * @date 2014年5月1日 下午3:54:23   
 * @version 1.0   
 */
package tw.com.as.sagautils.io.db;

import android.database.sqlite.SQLiteDatabase;

import tw.com.as.sagautils.db.DaoMaster;
import tw.com.as.sagautils.db.DaoSession;
import tw.com.as.sagautils.db.SceneryDao;
import tw.com.as.sagautils.db.TrackDao;
import tw.com.as.sagautils.db.TrackPointDao;


public class DbManager {

	// ------------------------ Constants ------------------------

	// ------------------------- Fields --------------------------
	
	private static volatile DbManager instance;
	public static DbManager getInstance(){
		if(instance == null){
			synchronized (DbManager.class) {
				instance = new DbManager();
			}
		}
		return instance;
	}
	
	private SQLiteDatabase db;
	private DaoMaster daoMaster;
	private DaoSession daoSession;

	// ----------------------- Constructors ----------------------
	
	private DbManager(){
		
	}

	// -------- Methods for/from SuperClass/Interfaces -----------

	// --------------------- Methods public ----------------------

    public boolean dbInited = false;
	
	public synchronized void init(){
		MyOpenHelper helper = new MyOpenHelper();
		db = helper.getWritableDatabase();
		daoMaster = new DaoMaster(db);
		daoSession = daoMaster.newSession();

        if(getTrackDao() != null){
            dbInited = true;
        }

		/*
		if(Configer.isDebugMode){
			QueryBuilder.LOG_SQL = true;
			QueryBuilder.LOG_VALUES = true;
		}
		*/
	}
	
	public TrackDao getTrackDao(){
		return daoSession.getTrackDao();
	}
	
	public SceneryDao getSceneryDao(){
		return daoSession.getSceneryDao();
	}
	
	public TrackPointDao getTrackPointDao(){
		return daoSession.getTrackPointDao();
	}

	// --------------------- Methods private ---------------------

	// --------------------- Getter & Setter ---------------------
	
	public SQLiteDatabase getDb() {
		return db;
	}
	
	public DaoMaster getDaoMaster() {
		return daoMaster;
	}
	
	// --------------- Inner and Anonymous Classes ---------------
}
