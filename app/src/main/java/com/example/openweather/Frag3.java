package com.example.openweather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;


public class Frag3 extends Fragment {

    private final String url = "https://api.openweathermap.org/data/2.5/forecast";
    private final String apiKey = "e803d046b4883d678b040e7751853895";
    DecimalFormat df = new DecimalFormat("#.##");

    View view;
    TextView city;

    TextView day1;
    TextView day2;
    TextView day3;
    TextView day4;
    TextView day5;
    TextView day6;
    TextView day7;

    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frag3, container, false);

        Bundle bundle = this.getArguments();

        if(bundle != null) {
            city = view.findViewById(R.id.city);

            day1 = view.findViewById(R.id.day1);
            imageView1 = view.findViewById(R.id.imageView1);

            day2 = view.findViewById(R.id.day2);
            imageView2 = view.findViewById(R.id.imageView2);

            day3 = view.findViewById(R.id.day3);
            imageView3 = view.findViewById(R.id.imageView3);

            day4 = view.findViewById(R.id.day4);
            imageView4 = view.findViewById(R.id.imageView4);

            day5 = view.findViewById(R.id.day5);
            imageView5 = view.findViewById(R.id.imageView5);

            day6 = view.findViewById(R.id.day6);
            imageView6 = view.findViewById(R.id.imageView6);

            day7 = view.findViewById(R.id.day7);
            imageView7 = view.findViewById(R.id.imageView7);


            String theCity = bundle.getString("city");

            String theTemp1 = bundle.getString("temp1");
            String theIconUrl1 = bundle.getString("iconUrl1");
            String theIconName1 = bundle.getString("iconName1");

            String theTemp2 = bundle.getString("temp2");
            String theIconUrl2 = bundle.getString("iconUrl2");
            String theIconName2 = bundle.getString("iconName2");

            String theTemp3 = bundle.getString("temp3");
            String theIconUrl3 = bundle.getString("iconUrl3");
            String theIconName3 = bundle.getString("iconName3");

            String theTemp4 = bundle.getString("temp4");
            String theIconUrl4 = bundle.getString("iconUrl4");
            String theIconName4 = bundle.getString("iconName4");

            String theTemp5 = bundle.getString("temp5");
            String theIconUrl5 = bundle.getString("iconUrl5");
            String theIconName5 = bundle.getString("iconName5");

            String theTemp6 = bundle.getString("temp6");
            String theIconUrl6 = bundle.getString("iconUrl6");
            String theIconName6 = bundle.getString("iconName6");

            String theTemp7 = bundle.getString("temp7");
            String theIconUrl7 = bundle.getString("iconUrl7");
            String theIconName7 = bundle.getString("iconName7");




            city.setText(theCity);

            day1.setText(theTemp1+"°C");
            day2.setText(theTemp2+"°C");
            day3.setText(theTemp3+"°C");
            day4.setText(theTemp4+"°C");
            day5.setText(theTemp5+"°C");
            day6.setText(theTemp6+"°C");
            day7.setText(theTemp7+"°C");


            Glide.with(Frag3.this).load(theIconUrl1+theIconName1+".png").into(imageView1);
            Glide.with(Frag3.this).load(theIconUrl2+theIconName2+".png").into(imageView2);
            Glide.with(Frag3.this).load(theIconUrl3+theIconName3+".png").into(imageView3);
            Glide.with(Frag3.this).load(theIconUrl4+theIconName4+".png").into(imageView4);
            Glide.with(Frag3.this).load(theIconUrl5+theIconName5+".png").into(imageView5);
            Glide.with(Frag3.this).load(theIconUrl6+theIconName6+".png").into(imageView6);
            Glide.with(Frag3.this).load(theIconUrl7+theIconName7+".png").into(imageView7);


        }




        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }
}