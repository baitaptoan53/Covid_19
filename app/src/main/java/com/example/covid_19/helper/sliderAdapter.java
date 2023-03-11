package com.example.covid_19.helper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.covid_19.R;

import org.w3c.dom.Text;

public class sliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
//    context là một đối tượng của lớp Context, nó được sử dụng để truy cập tài nguyên và lớp, cũng như giao tiếp với các ứng dụng và các thành phần khác.
    public sliderAdapter(Context context) {
        this.context = context;
    }
    int images[] = {
            R.drawable.undraw_social_distancing_2g0u_1,
            R.drawable.undraw_wash_hands_nwl2_1,
            R.drawable.undraw_medical_care_movn_1,
    };
int headings[] = {
            R.string.slide_1_heading,
            R.string.slide_2_heading,
            R.string.slide_3_heading,
    };
int descriptions[] = {
            R.string.slide_1_desc,
            R.string.slide_2_desc,
            R.string.slide_3_desc,
    };
// return headings vì headings là một mảng chứa các phần tử, mỗi phần tử là một số nguyên, nó sẽ trả về một số nguyên
    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container, false);
        ImageView slideImageView = view.findViewById(R.id.slider_image);
        TextView slideHeading = view.findViewById(R.id.slider_heading);
        TextView slideDescription = view.findViewById(R.id.slider_desc);
        slideImageView.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(descriptions[position]);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
