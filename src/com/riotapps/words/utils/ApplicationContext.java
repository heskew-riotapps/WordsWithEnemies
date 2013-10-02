package com.riotapps.words.utils;
 
import java.util.ArrayList;
import java.util.List;
import com.riotapps.wordbase.utils.Constants;
import com.riotapps.wordbase.utils.IntentExtra;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;

public class ApplicationContext extends com.riotapps.wordbase.utils.ApplicationContext {
	private static final String TAG = ApplicationContext.class.getSimpleName();
    private static Context context;
  //  private WordService wordService;
    	public void onCreate(){
        super.onCreate();
        ApplicationContext.context = getApplicationContext();
         }
 	public static Context getAppContext() {
        return ApplicationContext.context;
    }
 	
	public void startNewActivity(Context context, String activity){
		startNewActivity(context, activity, new ArrayList<IntentExtra>());
	}
	
	public void startNewActivity(Context context, String activity, List<IntentExtra> extras){
 		if (activity.equals(Constants.ACTIVITY_CLASS_SPLASH)){
 			openNewActivity(context, com.riotapps.words.Splash.class, extras);
 		}
 		else if (activity.equals(Constants.ACTIVITY_CLASS_MAIN)){
 			openNewActivity(context, com.riotapps.words.Main.class, extras);
 		}
 		else if (activity.equals(Constants.ACTIVITY_CLASS_ABOUT)){
 			openNewActivity(context, com.riotapps.words.About.class, extras);
 		}
 		else if (activity.equals(Constants.ACTIVITY_CLASS_GAME_HISTORY)){
 			openNewActivity(context, com.riotapps.words.GameHistory.class, extras);
		}
 		else if (activity.equals(Constants.ACTIVITY_CLASS_COMPLETED_GAMES)){
 			openNewActivity(context, com.riotapps.words.CompletedGames.class, extras);
		}
		else if (activity.equals(Constants.ACTIVITY_CLASS_FULL_RULES)){
 			openNewActivity(context, com.riotapps.words.FullRules.class, extras);
		}
		else if (activity.equals(Constants.ACTIVITY_CLASS_GAME_LOOKUP)){
 			openNewActivity(context, com.riotapps.words.GameLookup.class, extras);
		}
		else if (activity.equals(Constants.ACTIVITY_CLASS_GAME_SURFACE)){
 			openNewActivity(context, com.riotapps.words.GameSurface.class, extras);
		}
		else if (activity.equals(Constants.ACTIVITY_CLASS_STORE)){
 			openNewActivity(context, com.riotapps.words.Store.class, extras);
		}

	}
	
	private void openNewActivity(Context context, Class<?> cls, List<IntentExtra> extras){
		
		Intent intent = new Intent(context, cls);
		for (IntentExtra extra : extras){
			if (extra.getType().equals(String.class)){
				intent.putExtra(extra.getName(), (String)extra.getValue());
			}
			else if (extra.getType().equals(Boolean.class)){
				intent.putExtra(extra.getName(), (Boolean)extra.getValue());
			}
			else if (extra.getType().equals(Integer.class)){
				intent.putExtra(extra.getName(), (Integer)extra.getValue());
			}
		}
		
		context.startActivity(intent); 
	}

    
    
}
