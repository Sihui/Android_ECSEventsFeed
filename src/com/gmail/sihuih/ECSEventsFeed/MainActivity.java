package com.gmail.sihuih.ECSEventsFeed;

import com.gmail.sihuih.ECSEventsFeed.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
/**
 * 
 * @author sihui
 * This is the launch class, which will be called when the app is first opened.
 * What this class do: 1.launch animations (slide down, fade in, and slide up).
 *                     2.start FragmentActivity when the animations are finished.
 */
public class MainActivity extends Activity {

	ImageView imgPoster;
	ImageView withWords;
	ProgressBar pb;
	
	// Animation
	Animation animSlideDown;
	Animation animFadein;
	Animation animSlideUp;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_slide_down);
		
		imgPoster = (ImageView) findViewById(R.id.imgLogo);
		withWords= (ImageView) findViewById(R.id.withwords);
		pb=(ProgressBar)findViewById(R.id.progressBar1);
		// load the animation
		animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);						
		animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
		animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);	
		imgPoster.setVisibility(View.VISIBLE);
		imgPoster.startAnimation(animSlideDown);
		animSlideDown.setAnimationListener(new AnimationListener(){

		@Override
		public void onAnimationEnd(Animation animation) {
		withWords.setVisibility(View.VISIBLE);
		withWords.startAnimation(animFadein);
		pb.setVisibility(View.VISIBLE);}

		@Override
		public void onAnimationRepeat(Animation animation) {}
		@Override
		public void onAnimationStart(Animation animation) {}				
			});	
		
		animFadein.setAnimationListener(new AnimationListener(){
        
			@Override
			public void onAnimationEnd(Animation animation) {
				/**Start slideup animation when the fadein animation is end**/
				imgPoster.startAnimation(animSlideUp);				
				withWords.startAnimation(animSlideUp);
				pb.setVisibility(View.INVISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationStart(Animation animation) {}	
			});
		
		animSlideUp.setAnimationListener(new AnimationListener(){

			@Override
			public void onAnimationEnd(Animation animation) {
			
			/**Start FragmentActivity after slide-up animation is end**/
			Intent i = new Intent( MainActivity.this, MyFragmentActivity.class );
			MainActivity.this.startActivity( i );	
			MainActivity.this.finish();
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			@Override
			public void onAnimationStart(Animation animation) {}				
				});	
					
		}		
}
