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
import android.widget.EditText;
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


public class Frag1 extends Fragment {

    View view;
    EditText theCity, theCountry;
    Button button;
    private final String url = "https://api.openweathermap.org/data/2.5/weather";
    private final String apiKey = "e803d046b4883d678b040e7751853895";
    DecimalFormat df = new DecimalFormat("#.##");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_frag1, container, false);
        button =  view.findViewById(R.id.btnGet);
        theCity=view.findViewById(R.id.theCity);
        theCountry=view.findViewById(R.id.theCountry);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempUrl = "";
                String city = theCity.getText().toString().trim();
                String country = theCountry.getText().toString().trim();
                if(city.equals("")){
                }else{
                    if(!country.equals("")){
                        tempUrl = url + "?q=" + city + "," + country + "&apiKey=" + apiKey;
                    }else{
                        tempUrl = url + "?q=" + city + "&apiKey=" + apiKey;
                    }
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, tempUrl, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                JSONArray jsonArray = jsonResponse.getJSONArray("weather");
                                JSONObject jsonObjectWeather = jsonArray.getJSONObject(0);

                                Log.d("Tag", String.valueOf(jsonResponse));
                                Log.d("Tag", String.valueOf(jsonArray));
                                Log.d("Tag", String.valueOf(jsonObjectWeather));

                                String description = jsonObjectWeather.getString("description");
                                JSONObject jsonObjectMain = jsonResponse.getJSONObject("main");
                                String iconName  = jsonObjectWeather.getString("icon");
                                String iconUrl = "https://openweathermap.org/img/w/";
                                double doubleTemp = jsonObjectMain.getDouble("temp") - 273.15;
                                int temp = (int) doubleTemp;
                                double doubleFeelsLike = jsonObjectMain.getDouble("feels_like") - 273.15;
                                int feelsLike = (int) doubleFeelsLike;
                                JSONObject jsonObjectClouds = jsonResponse.getJSONObject("clouds");
                                String clouds = jsonObjectClouds.getString("all");
                                JSONObject jsonObjectSys = jsonResponse.getJSONObject("sys");
                                String countryName = jsonObjectSys.getString("country");
                                String cityName = jsonResponse.getString("name");

                                Bundle bundle = new Bundle();

                                bundle.putString("city", cityName);
                                bundle.putString("country", countryName);
                                bundle.putString("temp", df.format(temp));
                                bundle.putString("feelsLike", df.format(feelsLike));
                                bundle.putString("description", description);
                                bundle.putString("clouds", clouds);
                                bundle.putString("iconUrl", iconUrl);
                                bundle.putString("iconName", iconName);

                                Frag2 frag2 = new Frag2();
                                frag2.setArguments(bundle);


                                replaceFragment(frag2);


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