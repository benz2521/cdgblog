package net.learn2develop.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	CharSequence[] items = {"Gogle", "Apple", "Microsoft"};
	boolean[] itemsChecked = new boolean[items.length];
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btn = (Button)findViewById(R.id.btn_dialog);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(0);
			}
		});
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	switch (id) {
    	case 0:
    		return new AlertDialog.Builder(this)
    		.setIcon(R.drawable.ic_launcher)
    		.setTitle("This is a dialog with some simple text...")
    		.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(), "OK clicked!", Toast.LENGTH_SHORT).show();
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(), "Cancel clicked!", Toast.LENGTH_SHORT).show();
				}
			})
			.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					// TODO Auto-generated method stub
					Toast.makeText(getBaseContext(), 
							items[which] + (isChecked ? " checked!" : " unchecked!"), Toast.LENGTH_SHORT).show();
				}
			})
			.create();
    	}
    	return null;
    }
}




