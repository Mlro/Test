package ro.mole.ro.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class IconPreferenceScreen extends Preference {

    private Drawable mIcon;

    public IconPreferenceScreen(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public IconPreferenceScreen(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayoutResource(R.layout.preference_icon);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.IconPreferenceScreen, defStyle, 0);
        mIcon = a.getDrawable(R.styleable.IconPreferenceScreen_icon1);
    }
    @Override
    public void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon);
        if (imageView != null && mIcon != null) {
            imageView.setImageDrawable(mIcon);
        }
    }
    public void setIcon(Drawable icon) {
        if ((icon == null && mIcon != null) || (icon != null && !icon.equals(mIcon))) {
            mIcon = icon;
            notifyChanged();
        }
    }
    public Drawable getIcon() {
        return mIcon;
    }
}