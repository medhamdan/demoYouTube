package android.suyash.com.demoyoutube.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.suyash.com.demoyoutube.R;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class CommentDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private TextView commentTextView, cancelTextView;


    public CommentDialog(@NonNull Context context) {
        super(context);
        mContext = context;
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.promotions_diaolog);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = getWindow();
        if (window != null) {
            lp.copyFrom(window.getAttributes());
            // This makes the dialog take up the full width
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }

        commentTextView = (TextView) findViewById(R.id.comment);
        cancelTextView = (TextView) findViewById(R.id.cancel);

        commentTextView.setOnClickListener(this);
        cancelTextView.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comment:
                dismiss();
                break;
            case R.id.cancel:
                dismiss();
                break;

        }
    }
}