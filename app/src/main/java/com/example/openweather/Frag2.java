package com.example.openweather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.DecimalFormat;

public class Frag2 extends Fragment {

    View view;
    Button button;
    TextView city;
    TextView temp;
    TextView feelsLike;
    TextView description;
    ImageView imageView;

    private final String url = "https://api.openweathermap.org/data/2.5/forecast";
    private final String apiKey = "e803d046b4883d678b040e7751853895";
    DecimalFormat df = new DecimalFormat("#.##");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_frag2, container, false);

        button = view.findViewById(R.id.btnGet2);
        Bundle bundle = this.getArguments();

        if (bundle != null) { // ANVÄND DETTA I FRAG3 OCKSÅ
            imageView = view.findViewById(R.id.imageView);
            city = view.findViewById(R.id.city);
            temp = view.findViewById(R.id.temp);
            feelsLike = view.findViewById(R.id.feelsLike);
            description = view.findViewById(R.id.description);


            String theCity = bundle.getString("city");
            String theCountry = String.valueOf(bundle.get("country"));
            String theTemp = bundle.getString("temp");
            String theFeelLike = bundle.getString("feelsLike");
            String theDescription = bundle.getString("description");
            String theIconUrl = bundle.getString("iconUrl");
            String theIconName = bundle.getString("iconName");


            city.setText(theCity + " " + theCountry);
            temp.setText(theTemp + "°C");
            feelsLike.setText("Feels like " + theFeelLike + "°C");
            description.setText(theDescription);
            Glide.with(Frag2.this).load(theIconUrl + theIconName + ".png").into(imageView);

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String city = bundle.getString("city");
                Log.d("tag", bundle.getString("city"));
                String tempUrl = url + "?q=" + city + ","  + "&apiKey=" + apiKey;

                StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Bundle bundle2 = new Bundle();

                            JSONObject jsonResponse = new JSONObject(response);
                            JSONArray jsonArray = jsonResponse.getJSONArray("list");

                            JSONObject jsonObjectDay1 = jsonArray.getJSONObject(0);
                            JSONObject jsonObjectDay2 = jsonArray.getJSONObject(1);
                            JSONObject jsonObjectDay3 = jsonArray.getJSONObject(2);
                            JSONObject jsonObjectDay4 = jsonArray.getJSONObject(3);
                            JSONObject jsonObjectDay5 = jsonArray.getJSONObject(4);
                            JSONObject jsonObjectDay6 = jsonArray.getJSONObject(5);
                            JSONObject jsonObjectDay7 = jsonArray.getJSONObject(6);


                            JSONObject jsonObjectMain1 = jsonObjectDay1.getJSONObject("main");
                            JSONArray jsonObjectWeather1 = jsonObjectDay1.getJSONArray("weather");
                            JSONObject jsonObjetIcon1 = jsonObjectWeather1.getJSONObject(0);
                            String iconName1  = jsonObjetIcon1.getString("icon");
                            String iconUrl1 = "https://openweathermap.org/img/w/";
                            double doubleTemp1 = jsonObjectMain1.getDouble("temp") - 273.15;
                            int temp1 = (int) doubleTemp1;
                            bundle2.putString("temp1", df.format(temp1));
                            bundle2.putString("iconUrl1", iconUrl1);
                            bundle2.putString("iconName1", iconName1);

                            JSONObject jsonObjectMain2 = jsonObjectDay2.getJSONObject("main");
                            JSONArray jsonObjectWeather2 = jsonObjectDay2.getJSONArray("weather");
                            JSONObject jsonObjetIcon2 = jsonObjectWeather2.getJSONObject(0);
                            String iconName2  = jsonObjetIcon2.getString("icon");
                            String iconUrl2 = "https://openweathermap.org/img/w/";
                            double doubleTemp2 = jsonObjectMain2.getDouble("temp") - 273.15;
                            int temp2 = (int) doubleTemp2;
                            bundle2.putString("temp2", df.format(temp2));
                            bundle2.putString("iconUrl2", iconUrl2);
                            bundle2.putString("iconName2", iconName2);

                            JSONObject jsonObjectMain3 = jsonObjectDay3.getJSONObject("main");
                            JSONArray jsonObjectWeather3 = jsonObjectDay3.getJSONArray("weather");
                            JSONObject jsonObjetIcon3 = jsonObjectWeather3.getJSONObject(0);
                            String iconName3  = jsonObjetIcon3.getString("icon");
                            String iconUrl3 = "https://openweathermap.org/img/w/";
                            double doubleTemp3 = jsonObjectMain3.getDouble("temp") - 273.15;
                            int temp3 = (int) doubleTemp3;
                            bundle2.putString("temp3", df.format(temp3));
                            bundle2.putString("iconUrl3", iconUrl3);
                            bundle2.putString("iconName3", iconName3);

                            JSONObject jsonObjectMain4 = jsonObjectDay4.getJSONObject("main");
                            JSONArray jsonObjectWeather4 = jsonObjectDay4.getJSONArray("weather");
                            JSONObject jsonObjetIcon4 = jsonObjectWeather4.getJSONObject(0);
                            String iconName4  = jsonObjetIcon4.getString("icon");
                            String iconUrl4 = "https://openweathermap.org/img/w/";
                            double doubleTemp4 = jsonObjectMain4.getDouble("temp") - 273.15;
                            int temp4 = (int) doubleTemp4;
                            bundle2.putString("temp4", df.format(temp4));
                            bundle2.putString("iconUrl4", iconUrl4);
                            bundle2.putString("iconName4", iconName4);

                            JSONObject jsonObjectMain5 = jsonObjectDay5.getJSONObject("main");
                            JSONArray jsonObjectWeather5 = jsonObjectDay5.getJSONArray("weather");
                            JSONObject jsonObjetIcon5 = jsonObjectWeather5.getJSONObject(0);
                            String iconName5  = jsonObjetIcon5.getString("icon");
                            String iconUrl5 = "https://openweathermap.org/img/w/";
                            double doubleTemp5 = jsonObjectMain5.getDouble("temp") - 273.15;
                            int temp5 = (int) doubleTemp5;
                            bundle2.putString("temp5", df.format(temp5));
                            bundle2.putString("iconUrl5", iconUrl5);
                            bundle2.putString("iconName5", iconName5);

                            JSONObject jsonObjectMain6 = jsonObjectDay6.getJSONObject("main");
                            JSONArray jsonObjectWeather6 = jsonObjectDay6.getJSONArray("weather");
                            JSONObject jsonObjetIcon6 = jsonObjectWeather6.getJSONObject(0);
                            String iconName6  = jsonObjetIcon6.getString("icon");
                            String iconUrl6 = "https://openweathermap.org/img/w/";
                            double doubleTemp6 = jsonObjectMain6.getDouble("temp") - 273.15;
                            int temp6 = (int) doubleTemp6;
                            bundle2.putString("temp6", df.format(temp6));
                            bundle2.putString("iconUrl6", iconUrl6);
                            bundle2.putString("iconName6", iconName6);

                            JSONObject jsonObjectMain7 = jsonObjectDay7.getJSONObject("main");
                            JSONArray jsonObjectWeather7 = jsonObjectDay7.getJSONArray("weather");
                            JSONObject jsonObjetIcon7 = jsonObjectWeather7.getJSONObject(0);
                            String iconName7  = jsonObjetIcon7.getString("icon");
                            String iconUrl7 = "https://openweathermap.org/img/w/";
                            double doubleTemp7 = jsonObjectMain7.getDouble("temp") - 273.15;
                            int temp7 = (int) doubleTemp7;
                            bundle2.putString("temp7", df.format(temp7));
                            bundle2.putString("iconUrl7", iconUrl7);
                            bundle2.putString("iconName7", iconName7);

                            bundle2.putString("city",bundle.getString("city") );

                            Frag3 frag3 = new Frag3();
                            frag3.setArguments(bundle2);


                            replaceFragment(frag3);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
                requestQueue.add(stringRequest);



            }
        });

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }
}
